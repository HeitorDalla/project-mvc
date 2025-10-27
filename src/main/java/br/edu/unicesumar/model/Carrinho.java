package br.edu.unicesumar.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//INFORMANDO PARA O JPA QUE ESTE OBJETO É UMA TABELA NO BANCO
@Entity
@Table(name="carrinho_tbl")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_carrinho")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_item_carrinho_carrinho", referencedColumnName = "id_item_carrinho")
    private ItemCarrinho itens;

    // CONSTRUTORES
    public Carrinho () {}

    public Carrinho(int id, ItemCarrinho itens) {
        this.id = id;
        this.itens = itens;
    }

    // MÉTODOS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemCarrinho getItens() {
        return itens;
    }

    public void setItens(ItemCarrinho itens) {
        this.itens = itens;
    }
}