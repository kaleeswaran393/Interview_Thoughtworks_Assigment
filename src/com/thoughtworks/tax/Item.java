/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thoughtworks.tax;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Home
 */
public class Item extends SalesTaxDecorator implements Serializable {

    private Integer quantity;
    private String name;
    private BigDecimal price;
    private Category category;
    private boolean imported;
    private BigDecimal salesTax = new BigDecimal("0.0");
    protected BigDecimal tax = new BigDecimal("0.0");

    public Item(Integer quantity, String name, BigDecimal price, Category category, boolean imported) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.category = category;
        this.imported = imported;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the imported
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * @param imported the imported to set
     */
    public void setImported(boolean imported) {
        this.imported = imported;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public BigDecimal salesTax() {
        return new BigDecimal("0.0");
    }

    /**
     * @return the salesTax
     */
    public BigDecimal getSalesTax() {
        return salesTax;
    }

    /**
     * @return the salesTax
     */
    public BigDecimal tax() {
        return tax;
    }

    /**
     * @param salesTax the salesTax to set
     */
    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }
}
