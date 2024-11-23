
package com.senai.projetologin.dtos;



import lombok.Data;


@Data
public class UsuarioDto {


    private String senha;
    
    private Long id;
    
    private String email;
    
    private String nome;
    
    
}
