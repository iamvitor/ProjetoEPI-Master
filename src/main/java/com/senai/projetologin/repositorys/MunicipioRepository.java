
package com.senai.projetologin.repositorys;


import com.senai.projetologin.models.MunicipioModels;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioModels,Long> {
    

    public Optional<MunicipioModels> findById(Long id);
    
}