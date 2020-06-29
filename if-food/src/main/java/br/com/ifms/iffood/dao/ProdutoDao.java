package br.com.ifms.iffood.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transaction;

import com.mysql.cj.Session;

import br.com.ifms.iffood.model.Produto;

public class ProdutoDao {

  Session session;
  Transaction transaction;


  private EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("iffood");
    private EntityManager em = factory.createEntityManager();
 

 
  public String save(Produto produto) {
          try {
                em.getTransaction().begin();
                em.persist(produto);
                em.getTransaction().commit();
                
                return "listaProdutos";
          } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                return "error";
          }
    }
     

    public List<Produto> findAll() {
      em.getTransaction().begin();
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Produto.class));
      return em.createQuery(cq).getResultList();
}

    public boolean deletarProduto(Produto produto) {
          try {
                em.remove(produto);
                return true;
          } catch (Exception e) {
                e.printStackTrace();
                return false;
          }
    }
}