/** Thoughtwork confidential */
package com.thoughtworks.tax;

import java.math.BigDecimal;
/**
 * 
 * @author Kaleeswaran
 */
public class BasicTax extends SalesTaxDecorator {

    SalesTaxDecorator product;

    public BasicTax(SalesTaxDecorator product) {
        this.product = product;
    }

    @Override
    public BigDecimal salesTax() {
        return product.salesTax().add(DOMESTIC_TAX);
    }
}
