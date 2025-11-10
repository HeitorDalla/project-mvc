package br.edu.unicesumar.dao;

import java.util.List;

import br.edu.unicesumar.model.Pedido;
import jakarta.persistence.TypedQuery;

public class PedidoDAO extends DAO<Pedido>{

    //LISTANDO TODOS OS PEDIDOS
    public List<Pedido> listAll(){
        try {
            TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p", Pedido.class);

            return query.getResultList();
        } catch (Exception e) {
            return List.of();
        }
    }

    //LISTANDO O PEDIDO PELO IDENTIFICADOR
    public Pedido findById(int id){
        try {
            return em.find(Pedido.class, id);
        } catch (Exception e) {
            return null;
        }
    }
}