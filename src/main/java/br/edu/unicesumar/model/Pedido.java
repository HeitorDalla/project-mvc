package br.edu.unicesumar.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemPedido> itens = new ArrayList<>();
    
    @Column(name="valor_total_pedido", nullable = false)
    private double valorTotal;

    // @Column(name="status_pedido", nullable = false)
    // private StatusPedido status;

    // CONSTRUTORES
    
}