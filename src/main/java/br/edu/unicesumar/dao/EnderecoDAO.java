package br.edu.unicesumar.dao;

import java.util.List;

import br.edu.unicesumar.model.Endereco;
import jakarta.persistence.TypedQuery;

public class EnderecoDAO extends DAO<Endereco>{

    //LISTANDO TODOS OS ENDERECOS
    public List<Endereco> listAll(){
        try {
            TypedQuery<Endereco> query = em.createQuery("SELECT e FROM Endereco e", Endereco.class);

            return query.getResultList();
        } catch (Exception e) {
            return List.of();
        }
    }

    //LISTANDO O ENDERECO PELO IDENTIFICADOR
    public Endereco findById(int id){
        try {
            TypedQuery<Endereco> query = em.createQuery("SELECT e FROM Endereco e " + "WHERE e.id = :id", Endereco.class);

            query.setParameter("id", id);

            return query.getSingleResult();      
        } catch (Exception e) {
            return null;
        }
    }
}
