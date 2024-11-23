package com.senai.projetologin.controllers;

import com.senai.projetologin.dtos.*;
import com.senai.projetologin.services.CategoriaServices;
import com.senai.projetologin.services.MunicipioServices;
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

public class CadastrarMunicipioController {

    
@Autowired
MunicipioServices municipioServices;
@Autowired
CategoriaServices estadoService;

    
    
    
    @GetMapping("/municipios")
    public String municipiosView(Model model) {

       MunicipioDto municipioDto = new MunicipioDto();
       model.addAttribute("municipioDto", municipioDto);
       model.addAttribute("municipios", municipioServices.obterListaMunicipios());
      
       
       
      return "listarmunicipios";

    }
    @GetMapping("/cadastrarmunicipio")
    public String cadMunicipio(Model model) {

        MunicipioDto municipioDto = new MunicipioDto();

        model.addAttribute("municipioDto", municipioDto);
       // model.addAttribute("estados", estadoService.obterListaEstados());

        return "cadastrarmunicipio";
    }

    
    
    
    @PostMapping("/cadastrarmunicipio")
    public String cadastrarMunicipio(@ModelAttribute("municipio") MunicipioDto municipioDto) {

        boolean cadastro = municipioServices.cadastrarMunicipio(municipioDto);

        if (cadastro) {
            return "redirect:/municipios";
        }

        return "redirect:/municipios";
    }
    
    @DeleteMapping("/municipio/{id}")
    public ResponseEntity<String> excluirMunicipio(@PathVariable Long id) {

        boolean excluir = municipioServices.excluirMunicipio(id);

        if (excluir) {
            return ResponseEntity.ok("Municipio excluído com sucesso.");

        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possivel excluir Municipio.");

    }

    
    
  
}
