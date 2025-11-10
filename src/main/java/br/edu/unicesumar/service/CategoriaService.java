package br.edu.unicesumar.service;

import java.util.List;

import br.edu.unicesumar.dao.CategoriaDAO;

import br.edu.unicesumar.model.Categoria;

public class CategoriaService {
    private final CategoriaDAO categoriaDAO;

    public CategoriaService () {
        this.categoriaDAO = new CategoriaDAO();
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

    // Recebe o id do Controller, busca a Categoria no DAO e retorna o resultado ao Controller
    public Categoria findById(int id) {
        return categoriaDAO.findById(id);
    }

    // Método para listar todos as Categorias
    public List<Categoria> listAll () {
        return categoriaDAO.listAll();
    }
}