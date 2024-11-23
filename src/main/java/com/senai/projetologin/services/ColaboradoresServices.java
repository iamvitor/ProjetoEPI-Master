package com.senai.projetologin.services;

import com.senai.projetologin.dtos.*;
import com.senai.projetologin.models.ColaboradoresModels;
import com.senai.projetologin.repositorys.ColaboradoresRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradoresServices {

    @Autowired
    ColaboradoresRepository repository;



    public boolean cadastrarColaboradores(CadastrarDto cadastrar) {

        if (repository.findByEmail(cadastrar.getEmail()).isPresent()) {
            return false;
        }


        ColaboradoresModels colaboradores = new ColaboradoresModels();

        colaboradores.setNome(cadastrar.getNome());
        colaboradores.setEmail(cadastrar.getEmail());
        colaboradores.setFuncao(cadastrar.getFuncao());
        colaboradores.setNascimento(cadastrar.getNascimento());


        repository.save(colaboradores);
        return true;

    }

    public boolean deletarColaboradores(Long codigo) {

        Optional<ColaboradoresModels> optionalColaboradores = repository.findById(codigo);

        if (optionalColaboradores.isPresent()) {
            repository.deleteById(codigo);
            return true;
        }

        return false;

    }

    public ColaboradoresDto obterColaboradores(Long id) {

        Optional<ColaboradoresModels> optionalColaboradores = repository.findById(id);

        ColaboradoresDto colaboradoresDto = new ColaboradoresDto();

        if (!optionalColaboradores.isPresent()) {
            colaboradoresDto.setId(0L);
            return colaboradoresDto;
        }

        colaboradoresDto.setId(optionalColaboradores.get().getId());
        colaboradoresDto.setEmail(optionalColaboradores.get().getEmail());
        colaboradoresDto.setNome(optionalColaboradores.get().getNome());
        colaboradoresDto.setNascimento(optionalColaboradores.get().getNascimento());
        colaboradoresDto.setFuncao(optionalColaboradores.get().getFuncao());


        return colaboradoresDto;
    }

    public List<ColaboradoresDto> obterListaColaboradores() {

        List<ColaboradoresModels> listaColaboradoresModels = repository.findAll();

        List<ColaboradoresDto> listaColaboradores = new ArrayList();

        for (ColaboradoresModels Colaboradores : listaColaboradoresModels) {

            ColaboradoresDto colaboradoresDto = new ColaboradoresDto();

            colaboradoresDto.setId(Colaboradores.getId());
            colaboradoresDto.setEmail(Colaboradores.getEmail());
            colaboradoresDto.setNome(Colaboradores.getNome());
            colaboradoresDto.setFuncao(Colaboradores.getFuncao());
            colaboradoresDto.setNascimento(Colaboradores.getNascimento());


            listaColaboradores.add(colaboradoresDto);
        }

        return listaColaboradores;

    }

    public boolean atualizarColaboradores(ColaboradoresDto colaboradoresDto, Long id) {
        ColaboradoresModels colaboradoresNovo = repository.findById(id).orElse(null);

        colaboradoresNovo.setNome(colaboradoresDto.getNome());
        colaboradoresNovo.setEmail(colaboradoresDto.getEmail());
        colaboradoresNovo.setFuncao(colaboradoresDto.getFuncao());
        colaboradoresNovo.setId(colaboradoresDto.getId());
        colaboradoresNovo.setNascimento(colaboradoresDto.getNascimento());


        repository.save(colaboradoresNovo);
        return true;
    }

}
