package com.client.controllers;

import com.client.jaxws.models.CalculatorService;
import com.client.jaxws.models.CalculatorServiceImplService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorRestController {

    enum OPERAND {
        ADD("ADD"), SUB("SUB"), MUL("MUL"), DIV("DIV");
        private final String operator;

        OPERAND(String operator) {
            this.operator = operator;
        }

        public static OPERAND getOperand(String value) {
            for (OPERAND v : values())
                if (v == valueOf(value)) return v;
            throw new IllegalArgumentException();
        }
    }

    private CalculatorService calculatorService = new CalculatorServiceImplService().getCalculatorServiceImplPort();

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok("Welcome to my first SOAP Simulator Client.");
    }

    @PostMapping(path = "/{OPERAND_NAME}")
    public ResponseEntity<?> doOperation(@PathVariable("OPERAND_NAME") String action, @RequestBody JsonNode jsonNode) {
        try {
            int number1 = jsonNode.get("val1").asInt();
            int number2 = jsonNode.get("val2").asInt();
            OPERAND operator = OPERAND.getOperand(action.toUpperCase());
            int result = 0;
            switch (operator) {
                case ADD:
                    result = calculatorService.add(number1, number2);
                    break;
                case SUB:
                    result = calculatorService.subtract(number1, number2);
                    break;
                case MUL:
                    result = calculatorService.multiply(number1, number2);
                    break;
                case DIV:
                    result = calculatorService.divide(number1, number2);
                    break;
                default:
                    return ResponseEntity.ok().body("Oops!! Invalid Action Name. Possible action is {'Add/Sub/Mul/Div'");

            }
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.ok().body("Oops!! Something is wrong here.");
        }
    }
}
