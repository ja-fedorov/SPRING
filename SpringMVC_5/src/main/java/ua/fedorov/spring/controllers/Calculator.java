package ua.fedorov.spring.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Calculator {

    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request,
                             Model model) {
        int result = 000;

        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        String action = request.getParameter("action");

        if (action.equals("multiplication")) {result = a * b;}
        if (action.equals("division")) {result = a / b;}
        if (action.equals("adding")) {result = a + b;}
        if (action.equals("subtraction")) {result = a - b;}
        model.addAttribute("calc", "The result is: " + result);

        System.out.println(result);
        return "first/calculator";
    }

//    @GetMapping("/calculator")
//    public String calculator(@RequestParam("a") int a,
//                             @RequestParam("b") int b,
//                             @RequestParam("action") String action,
//                             Model model){
//        int result = 0;
//
//        if (action.equals("multiplication")) {result = a * b;}
//        if (action.equals("division")) {result = a / b;}
//        if (action.equals("adding")) {result = a + b;}
//        if (action.equals("subtraction")) {result = a - b;}
//        model.addAttribute("calc", "The result is: " + result);
//
//        return "first/calculator";
//    }


}
