
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
@RequestMapping("/colaboradores")
public class ColaboradoresController {

    @Autowired
    ColaboradoresServices colaboradoresServices;

    @PostMapping()
    public String cadastrarColaboradores(@ModelAttribute("colaboradores") CadastrarDto cadastrar, HttpServletRequest request) {

        boolean cadastroOk = colaboradoresServices.cadastrarColaboradores(cadastrar);

        if (cadastroOk) {
            return "sucesso.html";
        }

        return "redirect:cadastrarusuario?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirColaboradores(@PathVariable Long id) {

        boolean cadastroOk = colaboradoresServices.deletarColaboradores(id);

        if (cadastroOk) {
            return ResponseEntity.ok("Colaborador excluído com sucesso.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possivel excluir Colaborador.");

    }
}
