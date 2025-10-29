package br.edu.unicesumar.dao;

import java.util.List;

import br.edu.unicesumar.model.Pedido;
import jakarta.persistence.TypedQuery;

public class PedidoDAO extends DAO<Pedido>{

    //LISTANDO TODOS OS PEDIDOS
    public List<Pedido> listAllOrders(){
        try {
            TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p", Pedido.class);

            return query.getResultList();
        } catch (Exception e) {
            return List.of();
        }
    }

    //LISTANDO O PEDIDO PELO IDENTIFICADOR
    public Pedido findOrderById(int id){
        try {
            TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p " + "WHERE p.id = :id", Pedido.class);

            query.setParameter("id", id);

            return query.getSingleResult();      
        } catch (Exception e) {
            return null;
        }
    }
}
