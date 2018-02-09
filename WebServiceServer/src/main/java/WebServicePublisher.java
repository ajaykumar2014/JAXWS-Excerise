import com.web.invoker.CalculatorServiceInvoker;
import com.web.services.CalculatorServiceImpl;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8088/WS/CalculatorService", new CalculatorServiceImpl());

    }
}
