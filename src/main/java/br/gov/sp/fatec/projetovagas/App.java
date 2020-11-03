package br.gov.sp.fatec.projetovagas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.gov.sp.fatec.projetovagas.entity.Empresa;
import br.gov.sp.fatec.projetovagas.entity.Usuario;
import br.gov.sp.fatec.projetovagas.entity.Vaga;

public class App {
    
	public static void main( String[] args ){
        EntityManagerFactory factory = Persistence.
            createEntityManagerFactory("vaga");
        EntityManager manager = factory.createEntityManager();


        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Alexandre");
        usuario.setSenha("senha");

        Empresa empresa = new Empresa();
        empresa.setRazao_social("IBM");
        empresa.setNomeUsuario("Lucas");
        empresa.setSenha("senhaF0rte");
        
        Vaga vaga = new Vaga();
        vaga.setDescricao("Analista de Sistemas");
        vaga.setAnunciante(empresa);
        vaga.setUsuarios(new HashSet<Usuario>());
        vaga.getUsuarios().add(usuario);
        
        try{
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.persist(empresa);
            manager.persist(vaga);
            manager.getTransaction().commit();
        }catch(PersistenceException e){
            e.printStackTrace();
            manager.getTransaction().rollback();
        }

        manager.clear();

        usuario = manager.find(Usuario.class, usuario.getId());
        System.out.println(usuario.getId());
        System.out.println(usuario.getNomeUsuario());
        for(Vaga vaga1: usuario.getVagas()){
	        System.out.println(vaga1.getDescricao());
        }

        manager.clear();
        
        // Busca vaga pelo ID
        vaga = manager.find(Vaga.class, vaga.getId());
        System.out.println(vaga.getDescricao());
        for(Usuario usuario1: vaga.getUsuarios()){
	        System.out.println(usuario1.getNomeUsuario());
        }

        vaga.setDescricao("Diretor");
        try{
            manager.getTransaction().begin();
            manager.merge(vaga);
            manager.getTransaction().commit();
        }catch(PersistenceException e){
            e.printStackTrace();
            manager.getTransaction().rollback();
        }

        String queryString = "select t from Vaga t inner join t.usuarios u where u.nomeUsuario like :nome";
        TypedQuery<Vaga> query = manager.createQuery(queryString, Vaga.class);
        query.setParameter("nome", "%lexandr%");

        List<Vaga> resultados = query.getResultList();
        for(Vaga vag: resultados){
            System.out.println("Vaga: " + vag.getDescricao());
        }

        // Apaga registro (permite re-execução)

        try{
            manager.getTransaction().begin();
            empresa = vaga.getAnunciante();
            vaga.setAnunciante(null);
            Set<Usuario> usuarios = vaga.getUsuarios();
            vaga.setUsuarios(null);
            manager.remove(vaga);
            manager.remove(empresa);
            for(Usuario us: usuarios){
                manager.remove(us);
            }
            manager.getTransaction().commit();
        }catch(PersistenceException e){
            e.printStackTrace();
            manager.getTransaction().rollback();
            
        } 
        
        manager.close();
    }
}