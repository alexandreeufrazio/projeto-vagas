package br.gov.sp.fatec.projetovagas.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name = "emp_empresa")
@Entity
@PrimaryKeyJoinColumn(name = "emp_id")
public class Empresa extends Conta{

    @Column(name = "emp_razao_social")
    private String razao_social;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "anunciante")
    private Set<Vaga> vagasAnunciadas;

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public Set<Vaga> getVagasAnunciadas() {
        return vagasAnunciadas;
    }

    public void setVagasAnunciadas(Set<Vaga> vagasAnunciadas) {
        this.vagasAnunciadas = vagasAnunciadas;
    }
}