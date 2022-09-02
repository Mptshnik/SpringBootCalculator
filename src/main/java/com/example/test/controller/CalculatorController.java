package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculatorController
{

    @GetMapping("/calc")
    public String getCalculatorPage(Model model)
    {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam(value = "number1", defaultValue = "0", required = true) int a,
                            @RequestParam(value = "number2", defaultValue = "0", required = true) int b,
                            HttpServletRequest request,
                            Model model)
    {
        int answer = 0;
        String action = request.getParameter("actions");
        switch (action)
        {
            case "*":
                answer = a * b;
                break;
            case "/":
                if(b != 0)
                    answer = a / b;
                break;
            case "-":
                answer = a - b;
                break;
            case "+":
                answer = a + b;
                break;
        }
        model.addAttribute("answer", answer);

        return "calculator";
    }
}
