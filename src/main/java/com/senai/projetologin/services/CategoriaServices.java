package com.senai.projetologin.services;

import com.senai.projetologin.dtos.*;
import com.senai.projetologin.models.CategoriaModels;
import com.senai.projetologin.models.ColaboradoresModels;
import com.senai.projetologin.models.UsuarioModels;
import com.senai.projetologin.repositorys.CategoriaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServices {

    @Autowired
    CategoriaRepository repositorioCategoria;
    
    
 

    public boolean cadastrarCategoria (CategoriaDto categoriaDto){
         
        CategoriaModels categoriaModels = new CategoriaModels();
        
         categoriaModels.setNome(categoriaDto.getNome());



        repositorioCategoria.save(categoriaModels);
        
        
        return false;
        
    }

     public List<CategoriaDto> obterListaCategoria() {

        List<CategoriaModels> listaCategoriaModels = repositorioCategoria.findAll();

        List<CategoriaDto> listaCategoria = new ArrayList();

        for (CategoriaModels categorias : listaCategoriaModels) {

            CategoriaDto categoriaDto = new CategoriaDto();

            categoriaDto.setId(categorias.getId());
            categoriaDto.setNome(categorias.getNome());
            listaCategoria.add(categoriaDto);
        }

        return listaCategoria;

    }
     
     public boolean excluirCategoria(Long id) {

        Optional<CategoriaModels> optionalCategoria = repositorioCategoria.findById(id);

            if (optionalCategoria.isPresent()) {
              repositorioCategoria.deleteById(id);
         return true;
    }

    return false; 
}
    public CategoriaDto obterCategoria(Long id) {

        Optional<CategoriaModels> optionalCategoria = repositorioCategoria.findById(id);

        CategoriaDto categoriaDto = new CategoriaDto();

        if (!optionalCategoria.isPresent()) {
            categoriaDto.setId(0L);
            return categoriaDto;
        }

        categoriaDto.setId(optionalCategoria.get().getId());
        categoriaDto.setNome(optionalCategoria.get().getNome());

        return categoriaDto;
    }
    public boolean atualizarCategoria(CategoriaDto categoriaDto, Long id) {
        CategoriaModels categoriaNovo = repositorioCategoria.findById(id).orElse(null);

        categoriaNovo.setNome(categoriaDto.getNome());

        repositorioCategoria.save(categoriaNovo);
        return true;
    }





}


    

