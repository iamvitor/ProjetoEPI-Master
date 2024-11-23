package com.senai.projetologin.controllers;

import com.senai.projetologin.dtos.*;
import com.senai.projetologin.services.UsuarioServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping()
@Controller

public class LoginController {

    @Autowired
    UsuarioServices usuarioService;

    @GetMapping("/login")
    public String viewLogin(Model model) {

        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);

        return "login";

    }

    @PostMapping("/login")
    public String autenticar(@ModelAttribute ("usuarioDto") LoginDto loginDto, HttpServletRequest request) {
        if (usuarioService.autenticar(loginDto)) {
           
            request.getSession().setAttribute("loginDto", loginDto);
            return "redirect:/home";
        } else {
             
            return "redirect:login?erro"; // 

        }
    }
    
      
    
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
    System.out.println("Logout!");
    request.getSession().invalidate(); 
    return "redirect:login?logout"; 
    
    
}
      

}

