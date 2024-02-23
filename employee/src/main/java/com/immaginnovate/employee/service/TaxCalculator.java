package com.immaginnovate.employee.service;

public interface TaxCalculator {

    boolean accepts(int salary);
    int calculateTax(int salary);
}
