package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
public class HelloController
{

//    Handles request at path /hello
    @GetMapping("hello")
    public String hello(){
        return "Hello, Spring!";
    }

//    Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, String language) {
        return createMessage(name, language);
    }

//    Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }


    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "    <option value=''>--Please choose an option--</option>" +
                "    <option value='german'>German</option>" +
                "    <option value='french'>French</option>" +
                "    <option value='italian'>Italian</option>" +
                "    <option value='spanish'>Spanish</option>" +
                "    <option value='english'>English</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language){
        String message = null;
        
        if(language.equals("spanish")){
            message = "Hola " + name + "!";
        } else if(language.equals("french")){
            message = "Bonjour " + name + "!";
        } else if( language.equals("german")){
            message = "Guten Tag " + name + "!";
        } else if( language.equals("italian")){
            message = "Ciao " + name + "!";
        } else if( language.equals("english")){
            message = "Sup " + name + "!";
        }
        
        return message;
    }
}
