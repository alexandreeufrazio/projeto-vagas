package br.gov.sp.fatec.projetovagas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.gov.sp.fatec.projetovagas.entity.PersistenceManager;
import br.gov.sp.fatec.projetovagas.entity.Usuario;

public class UsuarioDaoJpa implements UsuarioDao {

    private EntityManager em;

    public UsuarioDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }

    public UsuarioDaoJpa(EntityManager em){
        this.em = em;
    }

    @Override
    public Usuario cadastrarUsuario(String nomeUsuario, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(senha);
        return salvarUsuario(usuario);
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario){
        try{
            em.getTransaction().begin();
            if(usuario.getId() == null){
                em.persist(usuario);
            }
            else{
                em.merge(usuario);
            }
            em.getTransaction().commit();
            return usuario;
        }catch(PersistenceException e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar Usuário!", e);
        }
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        String jpql = "select u from Usuario u where u.id = :id";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void removerUsuario(Long id) {
        Usuario usuario = buscarUsuarioPorId(Id);
        if(usuario == null){
            throw new RuntimeException("Usuario não cadastrado!");
        }
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();    
    }
    
}