/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thoughtworks.tax;

import java.math.BigDecimal;

/**
 *
 * @author Home
 */
public class ImportedSalesTax extends SalesTaxDecorator {

    SalesTaxDecorator product;

    public ImportedSalesTax(SalesTaxDecorator product) {
        this.product = product;
    }

    @Override
    public BigDecimal salesTax() {
        return product.salesTax().add(IMPORTED_TAX);
    }
}
