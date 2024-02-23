package com.immaginnovate.employee.service;

import org.springframework.stereotype.Component;

@Component
public class ThirdSlabTaxCalculator implements TaxCalculator{
    @Override
    public boolean accepts(int salary) {
        return salary > 1000000;
    }

    @Override
    public int calculateTax(int salary) {
        return (int) ((salary - 1000000)*0.2);
    }
}
