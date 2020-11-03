package br.gov.sp.fatec.projetovagas.dao;

import br.gov.sp.fatec.projetovagas.entity.Usuario;

public interface UsuarioDao {
    
    public Usuario cadastrarUsuario(String nomeUsuario, String senha);

    public Usuario salvarUsuario(Usuario usuario);

    public Usuario buscarUsuarioPorId(Long id);

    public void removerUsuario(Long id);  
    
}