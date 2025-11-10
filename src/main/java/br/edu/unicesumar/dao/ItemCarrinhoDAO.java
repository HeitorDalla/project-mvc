package br.edu.unicesumar.dao;

import java.util.List;

import br.edu.unicesumar.model.ItemCarrinho;
import jakarta.persistence.TypedQuery;

public class ItemCarrinhoDAO extends DAO<ItemCarrinho>{

    //LISTANDO TODOS OS ITENS DO CARRINHO
    public List<ItemCarrinho> listAll(){
        try {
            TypedQuery<ItemCarrinho> query = em.createQuery("SELECT ic FROM ItemCarrinho ic", ItemCarrinho.class);

            return query.getResultList();
        } catch (Exception e) {
            return List.of();
        }
    }

    //LISTANDO O ITEM DO CARRINHO PELO IDENTIFICADOR
    public ItemCarrinho findById(int id){
        try {
            TypedQuery<ItemCarrinho> query = em.createQuery("SELECT ic FROM ItemCarrinho ic " + "WHERE ic.id = :id", ItemCarrinho.class);

            query.setParameter("id", id);

            return query.getSingleResult();      
        } catch (Exception e) {
            return null;
        }
    }
}