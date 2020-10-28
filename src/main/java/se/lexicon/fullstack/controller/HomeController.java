package se.lexicon.fullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */

@Controller
public class HomeController {


    @GetMapping("/index")
    public String showIndexPage(){
        System.out.println("#################################");
        return "index";
    }

    @GetMapping("/welcome")
    public String showWelcomePage(){
        return "welcome";
    }
}
