package ua.fedorov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
// Если мы сделаем следущее - наш путь будет соятоять "/first/hello"
// При этол просто "first" ничего не будет выводить т.к. это папка))
//@RequestMapping("/first")
public class FirstController {


    @GetMapping("/hello")
    public String helloPage (HttpServletRequest request) {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println(" Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
//    required (default) true - обязательное внесение доп парамметров, false - необязательное (может быть может и не быть)
//    По технологии HttpServletRequest request - всегда стоит "false"

//    public String goodByePage(@RequestParam("name") String name,
//                              @RequestParam("surname") String surname) {

        public String goodByePage(@RequestParam(value = "name", required = false) String name,
                @RequestParam(value = "surname", required = false) String surname) {
        System.out.println(" Hello " + name + " " + surname);

        return "first/goodbye";
    }

}
