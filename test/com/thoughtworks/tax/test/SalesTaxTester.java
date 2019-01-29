package com.thoughtworks.tax.test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thoughtworks.tax.Category;
import com.thoughtworks.tax.Item;
import com.thoughtworks.tax.SalesTaxDecorator;
import com.thoughtworks.tax.TaxCalculator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Home
 */
public class SalesTaxTester extends TestCase {

    public SalesTaxTester(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSalesTestInputOne() {
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(1, "book", new BigDecimal("12.49"), Category.BOOK, false));
        itemList.add(new Item(1, "music", new BigDecimal("14.99"), Category.OTHER, false));
        itemList.add(new Item(1, "chocolate", new BigDecimal("0.85"), Category.FOOD, false));
        System.out.println(TaxCalculator.calculateTax(itemList));
        //assertEquals("29.83", salesTaxDecorator.totalPrice(itemList).toString());
        System.out.println();
    }

    public void testSalesTestInputTwo() {
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(1, "imported box of chocolates", new BigDecimal("10.00"), Category.FOOD, true));
        itemList.add(new Item(1, "imported bottle of perfume", new BigDecimal("47.50"), Category.OTHER, true));
        SalesTaxDecorator salesTaxDecorator = null;
        System.out.println(TaxCalculator.calculateTax(itemList));
        //assertEquals("65.15", salesTaxDecorator.totalPrice(itemList).toString());
        System.out.println();
    }

    public void testSalesTestInputThree() {
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(1, "imported bottle of perfume", new BigDecimal("27.99"), Category.OTHER, true));
        itemList.add(new Item(1, "bottle of perfume", new BigDecimal("18.99"), Category.OTHER, false));
        itemList.add(new Item(1, "packet of headache pills", new BigDecimal("9.75"), Category.MEDICAL, false));
        itemList.add(new Item(1, "box of imported chocolates", new BigDecimal("11.25"), Category.FOOD, true));
        System.out.println(TaxCalculator.calculateTax(itemList));
        //assertEquals("74.68", salesTaxDecorator.totalPrice(itemList).toString());
    }
}
