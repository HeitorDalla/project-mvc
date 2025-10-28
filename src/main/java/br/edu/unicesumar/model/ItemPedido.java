package br.edu.unicesumar.model;

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
@Table(name="item_pedido_tbl")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_item_pedido")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto_item_pedido", referencedColumnName = "id_produto")
    private Produto produto;
    
    @Column(name="quantidade_item_pedido", nullable = false)
    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido_item_pedido", nullable = false)
    private Pedido pedido;

    // CONSTRUTORES
    public ItemPedido () {}

    public ItemPedido(int id, Produto produto, int quantidade, Pedido pedido) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedido = pedido;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}