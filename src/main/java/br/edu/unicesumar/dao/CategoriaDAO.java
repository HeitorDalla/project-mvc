package br.edu.unicesumar.dao;

import java.util.List;

import br.edu.unicesumar.model.Categoria;
import jakarta.persistence.TypedQuery;

public class CategoriaDAO extends DAO<Categoria>{

    //LISTANDO TODOS AS CATEGORIAS
    public List<Categoria> listAll(){
        try {
            TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c", Categoria.class);

            return query.getResultList();
        } catch (Exception e) {
            return List.of();
        }
    }

    //LISTANDO O CATEGORIA PELO IDENTIFICADOR
    public Categoria findById(int id){
        try {
            TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c " + "WHERE c.id = :id", Categoria.class);

            query.setParameter("id", id);

            return query.getSingleResult();      
        } catch (Exception e) {
            return null;
        }
    }
}