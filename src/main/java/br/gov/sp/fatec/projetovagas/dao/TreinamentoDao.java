package br.gov.sp.fatec.projetovagas.dao;

import br.gov.sp.fatec.projetovagas.entity.Treinamento;

public class TreinamentoDao {
    public Treinamento cadastrarTreinamento(String descricao);

    public Treinamento salvarTreinamento(Treinamento treinamento);

    public Treinamento salvarTreinamentoSemCommit(Treinamento treinamento);

    public Treinamento buscarEmpresa(String descricao);

    public void removerTreinamento(String descricao);  
    
}