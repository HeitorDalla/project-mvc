package br.edu.unicesumar.service;

import java.util.List;

import br.edu.unicesumar.dao.CategoriaDAO;

import br.edu.unicesumar.model.Categoria;

import br.edu.unicesumar.exception.BusinessException;

public class CategoriaService {
    private final CategoriaDAO categoriaDAO;

    public CategoriaService () {
        this.categoriaDAO = new CategoriaDAO();
    }

    // Método que vai enviar o objeto para ser salvo no banco de dados
    public void saveCategoria (Categoria categoria) throws BusinessException {
        validarCategoria(categoria);

        categoriaDAO.save(categoria);
    }

    // Método que vai validar cada campo da categoria
    public void validarCategoria (Categoria categoria) throws BusinessException {
        if (categoria == null) {
            throw new BusinessException("Categoria não pode ser nula.");
        }

        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            throw new BusinessException("Nome da categoria não pode ser nula.");
        }
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