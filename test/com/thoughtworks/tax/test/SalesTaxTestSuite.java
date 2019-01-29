package com.thoughtworks.tax.test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 *
 * @author Home
 */
public class SalesTaxTestSuite extends TestSuite {

    static public Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(SalesTaxTester.class);
        return suite;
    }
}
