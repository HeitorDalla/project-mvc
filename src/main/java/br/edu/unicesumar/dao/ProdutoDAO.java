package br.edu.unicesumar.dao;

import java.util.List;

import br.edu.unicesumar.model.Produto;
import jakarta.persistence.TypedQuery;

public class ProdutoDAO extends DAO<Produto>{

    //LISTANDO TODOS OS PRODUTOS
    public List<Produto> listAllProducts(){
        try {
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);

            return query.getResultList();
        } catch (Exception e) {
            return List.of();
        }
    }

    //LISTANDO O PRODUTO PELO IDENTIFICADOR
    public Produto findProductById(int id){
        try {
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p " + "WHERE p.id = :id", Produto.class);

            query.setParameter("id", id);

            return query.getSingleResult();      
        } catch (Exception e) {
            return null;
        }
    }
}