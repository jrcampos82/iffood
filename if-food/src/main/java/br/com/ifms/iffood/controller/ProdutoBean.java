package br.com.ifms.iffood.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import br.com.ifms.iffood.dao.ProdutoDao;
import br.com.ifms.iffood.model.Produto;

@ManagedBean
@SessionScoped
public class ProdutoBean {
  
  
  private Produto produto;
  private List<Produto> produtos;
  public ProdutoBean(){
    this.produto = new Produto();
  }


  public ProdutoBean(Produto produto) {
    this.produto = produto;
  }

  public Produto getProduto() {
    return this.produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public ProdutoBean produto(Produto produto) {
    this.produto = produto;
    return this;
  }

	public List<Produto> getProdutos() {
		//System.out.println("service: "+service);
		if (produtos == null) {
      ProdutoDao dao = new ProdutoDao();
			produtos = dao.findAll();
		}
		return produtos;
	}
 

  public String salvar(){
    
    ProdutoDao pdao = new ProdutoDao();
    if (produto != null){
      System.out.println(produto.toString());
      pdao.save(produto);
      

      PrimeFaces.current().dialog().showMessageDynamic(new
        FacesMessage(FacesMessage.SEVERITY_INFO, "Tudo certo", "Registro inserido!"));
      return "listaProdutos";
    }
    
    PrimeFaces.current().dialog().showMessageDynamic(new
        FacesMessage(FacesMessage.SEVERITY_INFO, "Ooppsss", "Algo deu errado!"));

    return "errro...";


  }

  public void remover(){
    
  }

  public void inserirProduto(){
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("modal", true);
        options.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("formProduto", options, null); 
        //System.out.println("dialog");
  }

  
}