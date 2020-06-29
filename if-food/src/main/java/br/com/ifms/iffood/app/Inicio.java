package br.com.ifms.iffood.app;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ifms.iffood.dao.ProdutoDao;
import br.com.ifms.iffood.model.Produto;
import br.com.ifms.iffood.service.AbstractPersistence;

public class Inicio {

  public static void main(String[] args) {

    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("iffood-persistence");
    Produto p = new Produto();
    AbstractPersistence<Produto> dao = new AbstractPersistence<Produto>();
    ProdutoDao pdao = new ProdutoDao();
    
    List<Produto> lista = pdao.findAll();
    for (Produto prod : lista){
      System.out.println(prod.getNome());
    }


  }

}