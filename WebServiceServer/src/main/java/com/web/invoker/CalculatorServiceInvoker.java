package com.web.invoker;

import com.web.services.CalculatorService;
import com.web.services.CalculatorServiceImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

public class CalculatorServiceInvoker {

    private CalculatorService calculatorService;
    public CalculatorServiceInvoker(){
        this.calculatorService = new CalculatorServiceImpl();
    }

    @WebMethod
    public int add(int number1,int number2){
        return this.calculatorService.add(number1,number2);
    }

    @WebMethod
    public int substract(int number1,int number2){
        return this.calculatorService.subtract(number1,number2);
    }
    @WebMethod
    public int multi(int number1,int number2){
        return this.calculatorService.multiply(number1,number2);
    }
    @WebMethod
    public int divide(int number1,int number2){
        return this.calculatorService.divide(number1,number2);
    }
}
