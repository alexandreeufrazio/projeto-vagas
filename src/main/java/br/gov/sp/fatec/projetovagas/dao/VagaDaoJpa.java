package br.gov.sp.fatec.projetovagas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.gov.sp.fatec.projetovagas.entity.PersistenceManager;
import br.gov.sp.fatec.projetovagas.entity.Vaga;

public class VagaDaoJpa implements VagaDao {
    private EntityManager em;

    public VagaDaoJpa() {
        this(PersistenceManager.getInstance().getEntityManager());
    }

    public VagaDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public Vaga salvarVaga(Vaga vaga) {
        try{
            em.getTransaction().begin();
             if(vaga.getAnunciante() != null && vaga.getAnunciante().getId() == null){
                EmpresaDao empresaDao = new EmpresaDaoJpa(em);
                empresaDao.salvarEmpresaSemCommit(vaga.getAnunciante());

            }
            if(vaga.getId() == null){
                em.persist(vaga);
            }
            else{
                em.merge(vaga);
            }
            em.getTransaction().commit();
            return vaga;
        }catch(PersistenceException e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao salvar Vaga!", e);
        }
    }

    @Override
    public Vaga buscarVaga(Long id) {
        return em.find(Vaga.class, id);
    }

    @Override
    public void removerVaga(Long id) {
        Vaga vaga = buscarVaga(id);
        if(vaga == null){
            throw new RuntimeException("Vaga não cadastrado!");
        }
        em.getTransaction().begin();
        em.remove(vaga);
        em.getTransaction().commit();  
    }
    
}