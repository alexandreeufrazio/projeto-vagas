package br.gov.sp.fatec.projetovagas.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "emp_empresa")
@Entity
public class Empresa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_cnpj")
    private String cnpj;

    @Column(name = "emp_nome_fantasia")
    private String nomeFantasia;

    @Column(name = "emp_responsavel")
    private String responsavel;

    @Column(name = "emp_telefone")
    private String telefone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy =  "emp_id")
    private Set<Vagas> vagasAnunciadas;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "emp_id")
    private Set<ContaUsuario> contaDoUsuario;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "emp_id")
    private Set<Endereco> enderecoEmpresa;

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

    public Set<Vagas> getVagasAnunciadas() {
        return vagasAnunciadas;
    }

    public void setVagasAnunciadas(Set<Vagas> vagasAnunciadas) {
        this.vagasAnunciadas = vagasAnunciadas;
    }

    public Set<Endereco> getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(Set<Endereco> enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public Set<ContaUsuario> getContaDoUsuario() {
        return contaDoUsuario;
    }

    public void setContasDosUsuario(Set<ContaUsuario> contaDoUsuario) {
        this.contaDoUsuario = contaDoUsuario;
    }
       
}