package br.gov.sp.fatec.projetovagas.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "vag_vaga")
@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vag_id")
    private Long id;

    @Column(name = "vag_descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_anunciante_id")
    private Empresa anunciante;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ace_acesso",
	joinColumns = { @JoinColumn(name = "vag_id")},
	inverseJoinColumns = { @JoinColumn(name = "usu_id")})
    private Set<Usuario> usuarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Empresa getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Empresa anunciante) {
        this.anunciante = anunciante;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
}