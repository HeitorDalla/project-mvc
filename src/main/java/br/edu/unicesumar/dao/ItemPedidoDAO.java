package br.edu.unicesumar.dao;

import java.util.List;

import br.edu.unicesumar.model.ItemPedido;
import jakarta.persistence.TypedQuery;

public class ItemPedidoDAO extends DAO<ItemPedido>{

    //LISTANDO TODOS OS ITENS DO PEDIDO
    public List<ItemPedido> listAllOrderItens(){
        try {
            TypedQuery<ItemPedido> query = em.createQuery("SELECT ip FROM ItemPedido ip", ItemPedido.class);

            return query.getResultList();
        } catch (Exception e) {
            return List.of();
        }
    }

    //LISTANDO O ITEM DO PEDIDO PELO IDENTIFICADOR
    public ItemPedido findOrderItemById(int id){
        try {
            TypedQuery<ItemPedido> query = em.createQuery("SELECT ip FROM ItemPedido ip " + "WHERE ip.id = :id", ItemPedido.class);

            query.setParameter("id", id);

            return query.getSingleResult();      
        } catch (Exception e) {
            return null;
        }
    }
}