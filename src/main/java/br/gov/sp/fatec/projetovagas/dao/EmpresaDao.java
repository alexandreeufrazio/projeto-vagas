package br.gov.sp.fatec.projetovagas.dao;

import br.gov.sp.fatec.projetovagas.entity.Empresa;

public interface EmpresaDao {
    public Empresa cadastrarEmpresa(String nomeUsuario, String senha, String razao_social);

    public Empresa salvarEmpresa(Empresa empresa);

    public Empresa buscarEmpresa(String nomeUsuario);

    public void removerEmpresa(String nomeUsuario);  
    
}