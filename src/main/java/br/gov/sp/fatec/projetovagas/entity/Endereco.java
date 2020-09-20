package br.gov.sp.fatec.projetovagas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "end_endereco")
@Entity
public class Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_id")
    private Long id;

    @Column(name = "end_tipo", length = 10, nullable = false)
    private String tipo;

    @Column(name = "end_tipo_descricao", length = 50)
    private String tipoDescricao;

    @Column(name = "end_numero", length = 10)
    private String numero;

    @Column(name = "end_cidade", length = 20)
    private String cidade;

    @Column(name = "end_estado", length = 20)
    private String estado;

    @Column(name = "end_pais", length = 20)
    private String pais;

    /*
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    private Empresa endereco;
    */
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    public void setTipoDescricao(String tipoDescricao) {
        this.tipoDescricao = tipoDescricao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    /*
    public Empresa getEndereco() {
        return endereco;
    }

    public void setEndereco(Empresa endereco) {
        this.endereco = endereco;
    }
    */

    
        
}