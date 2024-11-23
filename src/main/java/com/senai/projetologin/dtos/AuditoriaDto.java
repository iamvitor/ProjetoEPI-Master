// AuditoriaDto.java
package com.senai.projetologin.dtos;

import java.time.LocalDateTime;

public class AuditoriaDto {
    private Long id;
    private String entidade;
    private String operacao;
    private LocalDateTime dataHora;
    private String usuario;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEntidade() { return entidade; }
    public void setEntidade(String entidade) { this.entidade = entidade; }
    public String getOperacao() { return operacao; }
    public void setOperacao(String operacao) { this.operacao = operacao; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
}
