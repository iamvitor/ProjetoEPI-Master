
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
@Table(name="COLABORADORES")
@Data
@Audited
public class ColaboradoresModels {
    
    @Id
    @Column(name = "id_colaboradores")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome_colaboradores", nullable = false, length = 90)
    private String nome;
    
    @Column(name = "email_colaboradores", nullable = false, length = 90)
    private String email;
    
    @Column(name = "funcao_colaboradores", nullable = false, length = 90)
    private String funcao;
    
    @Column(name = "nascimento_colaboradores", nullable = false, length = 90)
    private String nascimento;


}