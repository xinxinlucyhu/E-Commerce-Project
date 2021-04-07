package com.tts.ecommerce;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController
{
    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String login(User user)
    {
        return "signin";
    }

    @PostMapping("/signin")
    public String signup(@Valid User user, @RequestParam String submit, BindingResult bindingResult, HttpServletRequest request) throws ServletException
    {
        String password = user.getPassword();
        if(submit.equals("up"))
        {
            if(userService.testPassword(password)== false) {
                bindingResult.rejectValue("password", "error.user","Password must be longer than 8 characters. "
                        +"must contain a number, a capital letter, a lowercase letter."+"and a special character.");
                return "signin";
            }
            if(userService.findByUsername(user.getUsername()) == null)
            {
                userService.saveNew(user);
            }
            else
            {
                bindingResult.rejectValue("username", "error.user", "Username is already taken.");
                return "signin";
            }
        }
        request.login(user.getUsername(), password);
        return "redirect:/";
    }

}