package br.gov.sp.fatec.projetovagas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "end_endereco")
@Entity
public class Endereco{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "end_id")
    private Long id;

    @Column(name = "end_tipo")
    private String tipo;

    @Column(name = "end_tipo_descricao")
    private String tipoDescricao;

    @Column(name = "end_numero")
    private String numero;

    @Column(name = "end_cidade")
    private String cidade;

    @Column(name = "end_estado")
    private String estado;

    @Column(name = "end_pais")
    private String pais;


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
        
}