package br.gov.sp.fatec.projetovagas.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "usu_usuario")
@Entity
public class Usuario {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;
  
    @Column(name = "usu_nome_usuario")
    private String nomeUsuario;

    @Column(name = "usu_senha")
    private String senha;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
    private Set<Vaga> vagas;

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

    public Set<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(Set<Vaga> vagas) {
        this.vagas = vagas;
    }
}