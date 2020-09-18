package br.gov.sp.fatec.projetovagas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "con_conta_usuario")
@Entity
public class ContaUsuario{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "con_id")
    private Long id;

    @Column(name = "con_nome_usuario")
    private String nomeUsuario;

    @Column(name = "con_senha")
    private String senha;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   
}