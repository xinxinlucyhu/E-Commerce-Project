package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.Data;

@Data
@Controller
@ControllerAdvice
public class MainController
{
    @Autowired
    ProductService productService;
    
    @GetMapping("/")
public String main() {
  
    return "main";
}
@ModelAttribute("products")
public List<Product> products(){
    return productService.findAll();
}

@ModelAttribute("categories")
public List<String> categories(){
    return productService.findDistincCategories();
}
}

