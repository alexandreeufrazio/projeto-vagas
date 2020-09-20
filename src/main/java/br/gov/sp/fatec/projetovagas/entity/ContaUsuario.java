package br.gov.sp.fatec.projetovagas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "con_conta_usuario")
@Entity
public class ContaUsuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Long id;

    @Column(name = "con_nome_usuario", length = 50, nullable = false)
    private String nomeUsuario;

    @Column(name = "con_senha", length = 50, nullable = false)
    private String senha;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    private Empresa conta;


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

    public Empresa getConta() {
        return conta;
    }

    public void setConta(Empresa conta) {
        this.conta = conta;
    }
    
    
}