package com.web.services;

import javax.jws.WebService;

@WebService(endpointInterface = "com.web.services.CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }
}
