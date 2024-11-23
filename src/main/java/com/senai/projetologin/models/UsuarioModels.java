
package com.senai.projetologin.models;


import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import org.hibernate.envers.Audited;

@Entity
@Table(name="USUARIO")
@Data
@Audited

public class UsuarioModels {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome_usuario", nullable = false, length = 90)
    private String nome;
    
    @Column(name = "email_usuario", nullable = false, length = 90)
    private String email;
    
    @Column(name = "senha_usuario", nullable = false, length = 90)
    private String senha; 

}
