package br.edu.unicesumar.service;

import br.edu.unicesumar.dao.CategoriaDAO;

import br.edu.unicesumar.model.Categoria;

public class CategoriaService {
    // Injeção de Dependência
    private final CategoriaDAO categoriaDAO;

    public CategoriaService (CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    // Método que vai enviar o objeto para ser salvo no banco de dados
    public boolean saveCategoria (Categoria categoria) {
        if (!validarCategoria(categoria))

        categoriaDAO.save(categoria);

        return true;
    }

    // Método que vai validar cada campo da categoria
    public boolean validarCategoria (Categoria categoria) {
        if (categoria == null) {
            return false;
        }

        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            return false;
        }

        return true;
    }
}