package com.senai.projetologin.models;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "MUNICIPIO")
@Data
@Audited

public class MunicipioModels {

    @Id
    @Column(name = "id_municipio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_municipio", nullable = false, length = 90)
    private String nome;

    @ManyToOne
    private CategoriaModels estado;

}
