package br.edu.unicesumar.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//INFORMANDO PARA O JPA QUE ESTE OBJETO É UMA TABELA NO BANCO
@Entity
@Table(name="item_carrinho_tbl")
public class ItemCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_item_carrinho")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto_item_carrinho", referencedColumnName = "id_produto")
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrinho_item_carrinho", referencedColumnName = "id_carrinho")
    private Carrinho carrinho;
    
    @Column(name="quantidade_item_carrinho", nullable = false)
    private int quantidade;

    // CONSTRUTORES
    public ItemCarrinho () {}

    public ItemCarrinho(int id, Produto produto, Carrinho carrinho, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.carrinho = carrinho;
        this.quantidade = quantidade;
    }

    // MÉTODOS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}