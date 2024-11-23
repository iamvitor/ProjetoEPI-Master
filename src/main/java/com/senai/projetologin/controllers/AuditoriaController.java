package com.senai.projetologin.controllers;

import com.senai.projetologin.dtos.AuditoriaDto;
import com.senai.projetologin.services.AuditoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaServices auditoriaServices;

    @GetMapping
    public String exibirAuditoria(Model model) {
        List<AuditoriaDto> auditorias = auditoriaServices.obterRevisoes();
        model.addAttribute("auditorias", auditorias);
        return "auditoria";
    }
}
