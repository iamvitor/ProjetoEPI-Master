package com.senai.projetologin.controllers;

import com.senai.projetologin.dtos.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class CadastrarUsuarioController {
   
    
    @GetMapping("/cadastrarusuario")
    public String exibirUsuarios(Model model, HttpServletRequest request){
        
        HttpSession session = request.getSession(false); // Obtém a sessão sem criar uma nova
         
         if (session == null || session.getAttribute("loginDto") == null) {
            return "redirect:/login"; // Redireciona para o login se não estiver autenticado
         }
        
        CadastrarDto cadastrarDto = new CadastrarDto();
        
        model.addAttribute("usuarioDto", cadastrarDto);
        
        return "cadastrarusuario";
    }
    
    
}
