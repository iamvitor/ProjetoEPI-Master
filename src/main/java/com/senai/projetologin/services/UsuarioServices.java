package com.senai.projetologin.services;

import com.senai.projetologin.dtos.*;
import com.senai.projetologin.models.UsuarioModels;
import com.senai.projetologin.repositorys.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {

    @Autowired
    UsuarioRepository repository;

    public boolean autenticar(LoginDto loginDto) {

        Optional<UsuarioModels> OptionalUsuario = repository.findByEmail(loginDto.getEmail());

        if (OptionalUsuario.isPresent()) {
            if (OptionalUsuario.get().getSenha().equals(loginDto.getSenha())) {
                return true;
            }
        }
        return false;
    }

    public boolean cadastrarUsuario(CadastrarDto cadastrar) {


               if (repository.findByEmail(cadastrar.getEmail()).isPresent()) {
            return false;
        }


        if (cadastrar.getSenha() == null || cadastrar.getSenha().length() < 5) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 5 caracteres.");
        }

        UsuarioModels usuario = new UsuarioModels();
        usuario.setNome(cadastrar.getNome());
        usuario.setEmail(cadastrar.getEmail());
        usuario.setSenha(cadastrar.getSenha());

        repository.save(usuario);
        return true;
    }

    public boolean deletarUsuario(Long codigo) {

        Optional<UsuarioModels> optionalUsuario = repository.findById(codigo);

        if (optionalUsuario.isPresent()) {
            repository.deleteById(codigo);
            return true;
        }

        return false;

    }

    public UsuarioDto obterUsuario(Long id) {

        Optional<UsuarioModels> optionalUsuario = repository.findById(id);

        UsuarioDto usuarioDto = new UsuarioDto();

        if (!optionalUsuario.isPresent()) {
            usuarioDto.setId(0L);
            return usuarioDto;
        }

        usuarioDto.setId(optionalUsuario.get().getId());
        usuarioDto.setEmail(optionalUsuario.get().getEmail());
        usuarioDto.setNome(optionalUsuario.get().getNome());

        return usuarioDto;
    }

    public List<UsuarioDto> obterListaUsuarios() {

        List<UsuarioModels> listaUsuarioModel = repository.findAll();

        List<UsuarioDto> listaUsuario = new ArrayList();

        for (UsuarioModels usuario : listaUsuarioModel) {

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.getId());
            usuarioDto.setEmail(usuario.getEmail());
            usuarioDto.setNome(usuario.getNome());

            listaUsuario.add(usuarioDto);
        }

        return listaUsuario;

    }

    public boolean atualizarUsuario(AtualizarDto atualizarDto, Long id) {



        UsuarioModels usuarioAtualizado = repository.findById(id).get();

        if (!atualizarDto.getSenha().isEmpty()) {
            usuarioAtualizado.setSenha(atualizarDto.getSenha());
            usuarioAtualizado.setNome(atualizarDto.getNome());
            usuarioAtualizado.setEmail(atualizarDto.getEmail());
            repository.save(usuarioAtualizado);

        } else {
            usuarioAtualizado.setNome(atualizarDto.getNome());
            usuarioAtualizado.setEmail(atualizarDto.getEmail());
            repository.save(usuarioAtualizado);

        }
        return true;
    }

    public AtualizarDto obterUsuarioAtualizar(Long id) {

        Optional<UsuarioModels> optionalUsuario = repository.findById(id);

        AtualizarDto atualizarDto = new AtualizarDto();

        if (!optionalUsuario.isPresent()) {
            atualizarDto.setId(0L);
            return atualizarDto;
        }

        atualizarDto.setId(optionalUsuario.get().getId());
        atualizarDto.setEmail(optionalUsuario.get().getEmail());
        atualizarDto.setNome(optionalUsuario.get().getNome());
        atualizarDto.setSenha(optionalUsuario.get().getSenha());

        return atualizarDto;
    }

}
