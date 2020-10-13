package br.gov.sp.fatec.projetovagas.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "emp_empresa")
@Entity
public class Empresa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_razao_social")
    private String razao_social;

    @Column(name = "emp_senha")
    private String senha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "anunciante")
    private Set<Vaga> vagasAnunciadas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Vaga> getVagasAnunciadas() {
        return vagasAnunciadas;
    }

    public void setVagasAnunciadas(Set<Vaga> vagasAnunciadas) {
        this.vagasAnunciadas = vagasAnunciadas;
    }
}