package com.web.services;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface CalculatorService {

    @WebMethod
    int add(int a, int b);

    @WebMethod
    int subtract(int a, int b);

    @WebMethod
    int multiply(int a, int b);

    @WebMethod
    int divide(int a, int b);

}
