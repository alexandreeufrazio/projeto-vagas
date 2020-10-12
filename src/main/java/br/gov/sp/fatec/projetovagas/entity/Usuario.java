package br.gov.sp.fatec.projetovagas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Usuario {
   
    @Column(name = usu_id)
    private Long id;
  
    @Column(name = usu_nome_usuario)
    private String nomeUsuario;

    @Column(name = usu_senha)
    private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
    }
    
    

	 
}