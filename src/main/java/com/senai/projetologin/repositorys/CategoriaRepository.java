
package com.senai.projetologin.repositorys;

import com.senai.projetologin.models.CategoriaModels;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModels,Long> {
    

    public Optional<CategoriaModels> findById(Long id);
    
}