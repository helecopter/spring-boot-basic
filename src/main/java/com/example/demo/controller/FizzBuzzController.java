package com.example.demo.controller;

import com.example.demo.domain.Fibonacci;
import com.example.demo.domain.FizzBuzz;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fizz-buzz")
public class FizzBuzzController {

    @RequestMapping(value = "/{num}", method = RequestMethod.GET)
    public String getResult(@PathVariable int num) {
        return FizzBuzz.getValue(num);
    }
}
