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
@Table(name = "CATEGORIA")
@Data
@Audited

public class CategoriaModels {

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_categoria", nullable = false, length = 90)
    private String nome;



}
