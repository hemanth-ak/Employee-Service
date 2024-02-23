package com.immaginnovate.employee.service;

import org.springframework.stereotype.Component;

@Component
public class SecondSlabTaxCalculator implements TaxCalculator{
    @Override
    public boolean accepts(int salary) {
        return salary > 500000;
    }

    @Override
    public int calculateTax(int salary) {
        if(salary > 1000000) {
            return 50000;
        }
        return (int) ((salary - 500000)*0.1);
    }
}
