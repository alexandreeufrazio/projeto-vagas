package br.gov.sp.fatec.projetovagas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.gov.sp.fatec.projetovagas.entity.Empresa;
import br.gov.sp.fatec.projetovagas.entity.PersistenceManager;

public class EmpresaDaoJpa implements EmpresaDao {
    private EntityManager em;

    public EmpresaDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }

    public EmpresaDaoJpa(EntityManager em){
        this.em = em;
    }

    @Override
    public Empresa cadastrarEmpresa(String nomeUsuario, String senha,  String razao_social) {
        Empresa empresa = new Empresa();
        empresa.setNomeUsuario(nomeUsuario);
        empresa.setSenha(senha);
        empresa.setRazao_social(razao_social);
        return salvarEmpresa(empresa);
    }

    @Override
    public Empresa salvarEmpresa(Empresa empresa){
        try{
            em.getTransaction().begin();
            salvarEmpresaSemCommit(empresa);
            em.getTransaction().commit();
            return empresa;
        }catch(PersistenceException e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar Empresa!", e);
        }
    }

    @Override
     public Empresa salvarEmpresaSemCommit(Empresa empresa){
        if(empresa.getId() == null){
            em.persist(empresa);
        }
        else{
            em.merge(empresa);
        }
        return empresa;
    }

    @Override
    public Empresa buscarEmpresa(String nomeUsuario) {
        String jpql = "select e from Empresa e where e.nomeUsuario = :nomeUsuario";
        TypedQuery<Empresa> query = em.createQuery(jpql, Empresa.class);
        query.setParameter("nomeUsuario", nomeUsuario);
        return query.getSingleResult();
    }

    @Override
    public void removerEmpresa(String nomeUsuario) {
        Empresa empresa = buscarEmpresa(nomeUsuario);
        if(empresa == null){
            throw new RuntimeException("Empresa não cadastrado!");
        }
        em.getTransaction().begin();
        em.remove(empresa);
        em.getTransaction().commit();    
    }
}