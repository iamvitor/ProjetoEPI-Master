package com.senai.projetologin.controllers;



import com.senai.projetologin.dtos.UsuarioDto;
import com.senai.projetologin.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizarusuario")
public class VisualizarUsuarioController {
    
    @Autowired
    UsuarioServices usuarioService;
    
    @GetMapping("/{id}")
    public String exibirVisualizarUsuario(Model model, @PathVariable Long id, HttpServletRequest request){
        HttpSession session = request.getSession(false); // Obtém a sessão sem criar uma nova
         
         if (session == null || session.getAttribute("loginDto") == null) {
            return "redirect:/login"; // Redireciona para o login se não estiver autenticado
         }

        UsuarioDto usuario = usuarioService.obterUsuario(id);
                
        model.addAttribute("usuarioDto", usuario);
        
        if (usuario.getId() > 0){
            return "visualizarusuario";
        }
        
        return "redirect:/listausuarios";
        
    }
    
}
