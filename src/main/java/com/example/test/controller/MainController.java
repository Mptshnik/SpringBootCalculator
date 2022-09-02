package com.example.test.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class MainController
{
    @GetMapping("/")
    public String greeting(Model model)
    {
        model.addAttribute("title", "main page");
        return "home";
    }
/*
    @GetMapping("/calc")
    public String calc(Model model)
    {
        model.addAttribute("title", "10");
        return "home";
    }*/

    @GetMapping("/getres")
    public String res(@RequestParam(value = "variable",
            required = false,
            defaultValue = "0") int a,
                      @RequestParam(value = "variable2",
                              required = false,
                              defaultValue = "0") int b,Model model)
    {
        int c = a + b;
        model.addAttribute("answer", c);
        return "result";
    }

    @PostMapping("/showres")
    public String showres(@RequestParam(value = "variable",
            required = false,
            defaultValue = "0") int a,
                      @RequestParam(value = "variable2",
                              required = false,
                              defaultValue = "0") int b,Model model)
    {
        int c = a + b;
        model.addAttribute("answer", c);
        return "result";
    }

    @RequestMapping(value = "/getJson", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getJson()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("response","Hello");

        return new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
    }

    @RequestMapping(value = "/getString", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getString() {
        return Collections.singletonMap("response", "Hello World");
    }
}
