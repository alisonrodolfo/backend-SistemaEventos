package com.example.sistemaeventos.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author https://github.com/alisonrodolfo
 */
@Controller
public class IndexController {
    /* Created by Alison on 12/02/2022 */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/form")
    public String evento(){
        return "formevento";
    }
}
