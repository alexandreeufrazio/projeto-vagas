package br.gov.sp.fatec.projetovagas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.gov.sp.fatec.projetovagas.entity.PersistenceManager;
import br.gov.sp.fatec.projetovagas.entity.Treinamento;


public class TreinamentoDaoJpa implements TreinamentoDao {
    private EntityManager em;

    public TreinamentoDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }

    public TreinamentoDaoJpa(EntityManager em){
        this.em = em;
    }

    @Override
    public Treinamento cadastrarTreinamento(String descricao) {
        Treinamento treinamento = new Treinamento();
        treinamento.setDescricao(descricao);
        return salvarTreinamento(treinamento);
    }

    @Override
    public Treinamento salvarTreinamento(Treinamento treinamento){
        try{
            em.getTransaction().begin();
            salvarTreinamentoSemCommit(treinamento);
            em.getTransaction().commit();
            return treinamento;
        }catch(PersistenceException e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar Empresa!", e);
        }
    }

    @Override
     public Treinamento salvarTreinamentoSemCommit(Treinamento treinamento){
        if(treinamento.getId() == null){
            em.persist(treinamento);
        }
        else{
            em.merge(treinamento);
        }
        return treinamento;
    }

    @Override
    public Treinamento buscarTreinamento(String descricao){
        String jpql = "select t from Treinamento t where t.descricao = :descricao";
        TypedQuery<Treinamento> query = em.createQuery(jpql, Treinamento.class);
        query.setParameter("descricao", descricao);
        return query.getSingleResult();
    }

    @Override
    public void removerTreinamento(String descricao) {
        Treinamento treinamento = buscarTreinamento(descricao);
        if(treinamento == null){
            throw new RuntimeException("Empresa não cadastrado!");
        }
        em.getTransaction().begin();
        em.remove(treinamento);
        em.getTransaction().commit();    
    }
    
}