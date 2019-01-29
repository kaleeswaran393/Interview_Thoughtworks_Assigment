/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thoughtworks.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class TaxCalculator {

    private static final String SPACE = " ";
    private static final String NEWLINE = "\n";
    private static final String SEMICOLON = ":";
    private static final String SALES_TAX = "Sales Tax ";
    private static final String TOTAL = "Total Price ";
    private static final List<Category> taxExemptionList;

    static {
        taxExemptionList = new ArrayList<Category>();
        taxExemptionList.add(Category.BOOK);
        taxExemptionList.add(Category.FOOD);
        taxExemptionList.add(Category.MEDICAL);
    }

    public static StringBuilder calculateTax(List<Item> itemList) {
        SalesTaxDecorator salesTaxDecorator = null;
        StringBuilder receipt = new StringBuilder();
        for (Item item : itemList) {
            salesTaxDecorator = item;
            if (!taxExemptionList.contains(item.getCategory())) {
                salesTaxDecorator = new BasicTax(salesTaxDecorator);
            }
            if (item.isImported()) {
                salesTaxDecorator = new ImportedSalesTax(salesTaxDecorator);
            }
            salesTaxDecorator.setSalesTax(item);
            receipt.append(item.getQuantity());
            receipt.append(SPACE);
            receipt.append(item.getName());
            receipt.append(SEMICOLON);
            receipt.append(item.getPrice().add(item.getSalesTax()));
            receipt.append(NEWLINE);
        }
        receipt.append(SALES_TAX);
        receipt.append(SEMICOLON);
        receipt.append(salesTaxDecorator.totalSalesPrice(itemList));
        receipt.append(NEWLINE);
        receipt.append(TOTAL);
        receipt.append(SEMICOLON);
        receipt.append(salesTaxDecorator.totalPrice(itemList));
        return receipt;
    }

}