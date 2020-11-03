package br.gov.sp.fatec.projetovagas.dao;

import br.gov.sp.fatec.projetovagas.entity.Vaga;

public interface VagaDao {
   
    public Vaga salvarVaga(Vaga vaga);

    public Vaga buscarVaga(Long id);

    public void removerVaga(Long id);  
}