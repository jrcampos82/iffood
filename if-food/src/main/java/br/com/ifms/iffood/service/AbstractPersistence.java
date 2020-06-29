package br.com.ifms.iffood.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ifms.iffood.model.AbstractEntity;

public class AbstractPersistence<T extends AbstractEntity> {  

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("iffood");
  EntityManager em = emf.createEntityManager();

  public T save(T e){
      em.getTransaction().begin();      
      em.persist(e);
      em.getTransaction().commit();
      return e;
   
  }


  


}