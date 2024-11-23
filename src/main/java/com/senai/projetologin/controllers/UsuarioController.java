package com.senai.projetologin.controllers;

import com.senai.projetologin.dtos.*;
import com.senai.projetologin.services.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServices usuarioServices;



    @PostMapping()
    public String cadastrarUsuario(@ModelAttribute("usuario") CadastrarDto cadastrar, HttpServletRequest request) {

        boolean sucesso = usuarioServices.cadastrarUsuario(cadastrar);

        if (sucesso) {
            return "sucesso.html";
        }

        return "redirect:cadastrarusuario?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirUsuario(@PathVariable Long id, HttpServletRequest request) {

        boolean sucesso = usuarioServices.deletarUsuario(id);

        if (sucesso) {
            return ResponseEntity.ok("Usuário excluído com sucesso.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possivel excluir usuário.");

    }

}
