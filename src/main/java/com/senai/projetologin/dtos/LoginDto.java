
package com.senai.projetologin.dtos;

import lombok.Data;

@Data
public class LoginDto {
    
    private Long id;
    
    private String email;
    
    private String senha;
    
}