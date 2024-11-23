package com.senai.projetologin.repositorys;

import com.senai.projetologin.models.UsuarioModels;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModels,Long> {
    
    //- Método que realiza o select no banco de dados filtrando no where o email do usuário
    public Optional<UsuarioModels> findByEmail(String email);
    
    
}