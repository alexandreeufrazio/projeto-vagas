package br.gov.sp.fatec.projetovagas;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

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
        
        vaga = manager.find(Vaga.class, vaga.getId());
        System.out.println(vaga.getDescricao());
        for(Usuario usuario1: vaga.getUsuarios()){
	        System.out.println(usuario1.getNomeUsuario());
        }

        manager.close();

    }
}