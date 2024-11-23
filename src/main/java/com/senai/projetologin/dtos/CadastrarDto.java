
package com.senai.projetologin.dtos;


import lombok.Data;

@Data
public class CadastrarDto {
   
    private String email;
    
    private String senha;
    
    private String nome;
      
    private String funcao;

    private String nascimento;
    
    
}
