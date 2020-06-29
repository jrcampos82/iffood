package br.com.ifms.iffood.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_produto")
public class Produto implements AbstractEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private String descricao;
  private double preco;
  private int quantidade;
  

  public Produto() {
  }



  public Produto(Long id, String nome, String descricao, double preco, int quantidade) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.quantidade = quantidade;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getPreco() {
    return this.preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public int getQuantidade() {
    return this.quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public Produto id(Long id) {
    this.id = id;
    return this;
  }

  public Produto nome(String nome) {
    this.nome = nome;
    return this;
  }

  public Produto descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  public Produto preco(double preco) {
    this.preco = preco;
    return this;
  }

  public Produto quantidade(int quantidade) {
    this.quantidade = quantidade;
    return this;
    
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao) && preco == produto.preco && quantidade == produto.quantidade;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, descricao, preco, quantidade);
  }

  @Override
  public String toString() {
    return "{" +
      " id=' 1 '" +
      ", nome='" + getNome() + "'" +
      ", descricao='" + getDescricao() + "'" +
      ", preco='" + getPreco() + "'" +
      ", quantidade='" + getQuantidade() + "'" +
      "}";
  }









    @Override
    public Long getId() {
        return this.id;// TODO
    }
}