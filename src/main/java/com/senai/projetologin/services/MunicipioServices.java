package com.senai.projetologin.services;

import com.senai.projetologin.dtos.MunicipioDto;
import com.senai.projetologin.models.CategoriaModels;
import com.senai.projetologin.models.MunicipioModels;
import com.senai.projetologin.repositorys.CategoriaRepository;
import com.senai.projetologin.repositorys.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MunicipioServices {

    @Autowired
    MunicipioRepository repositorioMunicipio;

    @Autowired
    CategoriaRepository categoriaRepository;

 
    public boolean cadastrarMunicipio(MunicipioDto municipioDto) {

        CategoriaModels estado = categoriaRepository.findById(municipioDto.getId()).orElse(null);

        if (estado == null) {
            
            return false; 
        }

        
        MunicipioModels municipio = new MunicipioModels();
        municipio.setNome(municipioDto.getNome());
        municipio.setEstado(estado);
        
        
        repositorioMunicipio.save(municipio);
        return true;
    }


    public List<MunicipioDto> obterListaMunicipios() {
        List<MunicipioModels> listaMunicipiosModels = repositorioMunicipio.findAll();
        List<MunicipioDto> listaMunicipio = new ArrayList<>();

  
        for (MunicipioModels municipio : listaMunicipiosModels) {
            MunicipioDto municipioDto = new MunicipioDto();
            municipioDto.setId(municipio.getId());
            municipioDto.setNome(municipio.getNome());

       
            if (municipio.getEstado() != null) {
                municipioDto.setEstado(municipio.getEstado().getNome());
            } else {
                municipioDto.setEstado("Estado não atribuído"); // Coloca um valor padrão caso o estado seja null
            }

            listaMunicipio.add(municipioDto);
        }

        return listaMunicipio;
    }

   
    public boolean excluirMunicipio(Long id) {
    
        Optional<MunicipioModels> optionalMunicipio = repositorioMunicipio.findById(id);

     
        if (optionalMunicipio.isPresent()) {
            repositorioMunicipio.deleteById(id);
            return true;
        }
        return false; //
    }
}
