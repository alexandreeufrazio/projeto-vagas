package br.gov.sp.fatec.projetovagas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.gov.sp.fatec.projetovagas.entity.Usuario;

public class App {
    

	public static void main( String[] args ){
        EntityManagerFactory factory = Persistence.
            createEntityManagerFactory("vaga");
        EntityManager manager = factory.createEntityManager();

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("alexandre");
        usuario.setSenha("senha");

        try{
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.getTransaction().commit();
        }catch(Exception e){
            manager.getTransaction().rollback();
        }

        System.out.println(usuario.getId());
        manager.close();
    }
}