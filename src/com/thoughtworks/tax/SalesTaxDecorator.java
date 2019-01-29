package com.thoughtworks.tax;

import java.math.BigDecimal;
import java.util.List;

public abstract class SalesTaxDecorator {

    public static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");
    public static final BigDecimal DOMESTIC_TAX = new BigDecimal("10");
    public static final BigDecimal IMPORTED_TAX = new BigDecimal("5");

    public abstract BigDecimal salesTax();

    public void setSalesTax(Item item) {
        if (salesTax().intValue() != 0.0) {
            item.setSalesTax(roundOff(item.getPrice().multiply(salesTax()).divide(new BigDecimal("100"))));
        }
    }

    public BigDecimal totalPrice(List<Item> itemList) {
        BigDecimal bigDecimal = new BigDecimal("0.0");
        for (Item item : itemList) {
            bigDecimal = bigDecimal.add(item.getPrice().add(item.getSalesTax()));
        }
        return bigDecimal;
    }

    public BigDecimal totalSalesPrice(List<Item> itemList) {
        BigDecimal bigDecimal = new BigDecimal("0.0");
        for (Item item : itemList) {
            bigDecimal = bigDecimal.add(item.getSalesTax());
        }
        return bigDecimal;
    }

    private BigDecimal roundOff(BigDecimal value) {
        value = value.divide(ROUND_FACTOR);
        value = new BigDecimal(Math.ceil(value.doubleValue()));
        value = value.multiply(ROUND_FACTOR);
        return value;
    }
}
