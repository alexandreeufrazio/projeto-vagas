package br.gov.sp.fatec.projetovagas.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "usu_usuario")
@Entity
public class Usuario extends Conta {
   
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
    private Set<Vaga> vagas;

    public Set<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(Set<Vaga> vagas) {
        this.vagas = vagas;
    }
}