package com.senai.projetologin.controllers;



import com.senai.projetologin.dtos.*;;
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
@RequestMapping("/atualizarcategoria/{id}")

public class AtualizarCategoriaController {

    @Autowired
    CategoriaServices categoriaService;

    @GetMapping
    public String exibirAtualizarCategoria(Model model, @PathVariable Long id, HttpServletRequest request){
        HttpSession session = request.getSession(false); // Obtém a sessão sem criar uma nova

        if (session == null || session.getAttribute("loginDto") == null) {
            return "redirect:/login"; // Redireciona para o login se não estiver autenticado
        }
        CategoriaDto categoriaDto = categoriaService.obterCategoria(id);

        model.addAttribute("categoriaDto", categoriaDto);


        return "atualizarcategoria";
    }

    @PostMapping
    public String atualizarCategoria(@ModelAttribute("categorias")CategoriaDto categoriaDto, @PathVariable Long id) {
        boolean sucesso = categoriaService.atualizarCategoria(categoriaDto, id);

        if (sucesso) {
            return "sucesso.html"; //
        }

        return "redirect:/atualizarcategoria?erro"; //
    }

}