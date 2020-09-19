package br.gov.sp.fatec.projetovagas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.gov.sp.fatec.projetovagas.entity.Empresa;
import br.gov.sp.fatec.projetovagas.entity.Vagas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence
	        .createEntityManagerFactory("vagas");
        EntityManager manager = factory.createEntityManager();

        /*
        Empresa empresa = new Empresa();
        empresa.setNomeFantasia("Apple");
        empresa.setCnpj("11111111111111");
        empresa.setResponsavel("Alexandre");
        empresa.setTelefone("129111111");

        try{
            manager.getTransaction().begin();
            manager.persist(empresa);
            manager.getTransaction().commit();
        }catch(IllegalStateException e){
            e.printStackTrace();
            manager.getTransaction().rollback();   
        }
        */

        Empresa empresa = manager.find(Empresa.class, 1L);
        System.out.println(empresa.getId());
        System.out.println(empresa.getNomeFantasia());
        for(Vagas vagas: empresa.getVagasAnunciadas()){
            System.out.println(vagas.getCargo());
        }
        manager.close();

    }


}
