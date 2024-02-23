package com.immaginnovate.employee.service;

import org.springframework.stereotype.Component;

@Component
public class FirstSlabTaxCalculator implements TaxCalculator{
    @Override
    public boolean accepts(int salary) {
        return salary > 250000;
    }

    @Override
    public int calculateTax(int salary) {
        if(salary > 500000) {
            return 12500;
        }
        return (int) ((salary - 250000)*0.05);
    }
}
