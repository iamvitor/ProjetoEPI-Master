
package com.senai.projetologin.repositorys;

import com.senai.projetologin.models.ColaboradoresModels;
import java.util.Optional;

import com.senai.projetologin.models.UsuarioModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradoresRepository extends JpaRepository<ColaboradoresModels,Long> {
    

    public Optional<ColaboradoresModels> findById(Long id);
    public Optional<ColaboradoresModels> findByEmail(String email);
    
}