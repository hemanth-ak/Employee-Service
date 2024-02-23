package com.immaginnovate.employee.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaxCalculatorService {

    private final List<TaxCalculator> taxCalculatorList;
    public int calculateTax(int salary) {
        return taxCalculatorList.stream()
                .filter(taxCalculator -> taxCalculator.accepts(salary))
                .map(taxCalculator -> taxCalculator.calculateTax(salary))
                .reduce(0, Integer::sum);
    }

    public int calculateCess(int salary) {
        return salary > 2500000 ? (int) ((salary - 2500000) * 0.02) : 0;
    }
}
