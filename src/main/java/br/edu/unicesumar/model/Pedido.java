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
@Table(name="pedido_tbl")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_pedido")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_pedido", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_item_pedido_pedido", referencedColumnName = "id_item_pedido")
    private ItemPedido[] itens;
    
    @Column(name="valor_total_pedido", nullable = false)
    private String valorTotal;

    // @Column(name="status_pedido", nullable = false)
    // private StatusPedido status;

    // CONSTRUTORES
    
}