package com.senai.projetologin.controllers;

import com.senai.projetologin.dtos.*;
import com.senai.projetologin.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()

public class CadastrarCategoriaController {

    @Autowired
    CategoriaServices categoriaServices;

    @GetMapping("/categoria")
    public String categoriaView(Model model) {

        CategoriaDto categoriaDto = new CategoriaDto();
        model.addAttribute("categoriaDto", categoriaDto);
        model.addAttribute("categorias", categoriaServices.obterListaCategoria());

        return "listarcategoria";

    }

    @GetMapping("/cadastrarcategoria")
    public String exibirCategoria(Model model) {

        CategoriaDto categoriaDto = new CategoriaDto();

        model.addAttribute("categoriaDto", categoriaDto);

        return "cadastrarcategoria";
    }

    @PostMapping("/cadastrarcategoria")
    public String cadastrarCategoria(@ModelAttribute("categoria") CategoriaDto categoriaDto) {

        boolean cadastro = categoriaServices.cadastrarCategoria(categoriaDto);

        if (cadastro) {
            return "sucesso.html";
        }

        return "sucesso.html";
    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<String> excluirCategoriaDto(@PathVariable Long id) {

        boolean excluir = categoriaServices.excluirCategoria(id);

        if (excluir) {
            return ResponseEntity.ok("Categoria excluída com sucesso.");

        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possivel excluir Categoria.");

    }

}
