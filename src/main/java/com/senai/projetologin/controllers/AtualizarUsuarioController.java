package com.senai.projetologin.controllers;



import com.senai.projetologin.dtos.AtualizarDto;
import com.senai.projetologin.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atualizarusuario/{id}")
public class AtualizarUsuarioController {
    
    @Autowired
    UsuarioServices usuarioService;
    
    @GetMapping
    public String exibirAtualizarUsuario(Model model, @PathVariable Long id, HttpServletRequest request){
        HttpSession session = request.getSession(false); // Obtém a sessão sem criar uma nova
         
         if (session == null || session.getAttribute("loginDto") == null) {
            return "redirect:/login"; // Redireciona para o login se não estiver autenticado
         }
        AtualizarDto atualizarDto = usuarioService.obterUsuarioAtualizar(id);
                
        model.addAttribute("atualizarDto", atualizarDto);
        
      
            return "atualizarusuario";
        }
        
    @PostMapping
    public String atualizarUsuario(@ModelAttribute("usuario") AtualizarDto atualizarDto, @PathVariable Long id) {
    boolean sucesso = usuarioService.atualizarUsuario(atualizarDto, id);

    if (sucesso) {
        return "sucesso.html"; //
    }

    return "redirect:/atualizarusuario?erro"; // 
}
    
        
    
    
}
