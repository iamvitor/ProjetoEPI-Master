
package com.senai.projetologin.dtos;


import lombok.Data;

@Data
public class AtualizarDto {
    
    private Long id;
    
    private String email;
    
    private String nome;
    
    private String senha;
    
}
