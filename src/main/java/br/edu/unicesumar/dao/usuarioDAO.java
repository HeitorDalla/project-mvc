package br.edu.unicesumar.dao;

import java.util.List;

import br.edu.unicesumar.models.Usuario;
import jakarta.persistence.TypedQuery;

public class usuarioDAO extends DAO<Usuario> {
    // LISTANDO TODOS OS USUÁRIOS
    public List<Usario> listUsers () {
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);

            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    // LISTANDO O USUARIO PELO IDENTIFICADOR
    public Usuario findUserById (int id) {
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", "WHERE u.id = :id", Usuario.class);

            query.setParameter(id, query);

            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}