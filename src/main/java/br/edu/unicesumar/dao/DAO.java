package br.edu.unicesumar.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAO<Object> {
    protected EntityManager em;
    // PADRÃO SINGLETON

    // FAZER UMA UNICA CONEXAR AO BANCO DE DADOS
    private static DAO instance; // não pode ter outras instancias

    protected DAO () {
        em = getEntityManager();
    }

    private EntityManager getEntityManager () {
        // VERIFICAR SE EXISTE UM INSTANCIA (OU SEJA, SE ESTA IGUAL A NULO - SIGNIFICANDO QUE NAO FOI INSTANCIADO)
        if (em == null) {
            // PADRÃO FACTORY METHOD
            EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("projeto_unicesumar");
            em = emf.createEntityManager();
        }

        return em;
    }

    public static DAO getInstance () {
        if (instance == null) {
            instance = new DAO<>();
        }
        return instance;
    }
}