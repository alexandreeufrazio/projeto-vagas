package br.gov.sp.fatec.projetovagas.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "emp_empresa")
@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_cnpj", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "emp_nome_fantasia", length = 50, nullable = false)
    private String nomeFantasia;

    @Column(name = "emp_responsavel", length = 100, nullable = false)
    private String responsavel;

    @Column(name = "emp_telefone", length = 15, nullable = false)
    private String telefone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy =  "empresa")
    private Set<Vagas> vagas;
    /*
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "emp_id")
    private Set<ContaUsuario> conta;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "endereco")
    private Set<Endereco> endereco;*/

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    public Set<Vagas> getVagas() {
        return vagas;
    }

    public void setVagas(Set<Vagas> vagas) {
        this.vagas = vagas;
    }

    /*

    public Set<ContaUsuario> getConta() {
        return conta;
    }
    /*
    public void setConta(Set<ContaUsuario> conta) {
        this.conta = conta;
    }

    public Set<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }

    */
       
}