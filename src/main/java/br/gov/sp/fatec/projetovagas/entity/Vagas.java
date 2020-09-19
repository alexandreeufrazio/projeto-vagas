package br.gov.sp.fatec.projetovagas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "vag_vagas")
@Entity
public class Vagas{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vag_id")
    private Long id;

    @Column(name = "vag_cargo")
    private String cargo;

    @Column(name = "vag_descricao")
    private String descricao;

    @Column(name = "vag_status")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    private Empresa empIdVagas;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Empresa getEmpIdVagas() {
        return empIdVagas;
    }

    public void setEmpIdVagas(Empresa empIdVagas) {
        this.empIdVagas = empIdVagas;
    }

    

    
     
}