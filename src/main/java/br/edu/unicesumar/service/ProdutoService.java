package br.edu.unicesumar.service;

import br.edu.unicesumar.dao.ProdutoDAO;

import br.edu.unicesumar.model.Produto;
import br.edu.unicesumar.model.Categoria;

public class ProdutoService {
    // Injeção de dependência
    private final ProdutoDAO produtoDAO;
    private final CategoriaService categoriaService;

    public ProdutoService (ProdutoDAO produtoDAO, CategoriaService categoriaService) {
        this.produtoDAO = produtoDAO;
        this.categoriaService = categoriaService;
    }

    // Salvar o produto no banco de dados
    public boolean saveProduto (Produto produto) {
        if (!validarProduto(produto)) {
            return false;
        }

        produtoDAO.save(produto);

        return true;
    }

    // Validar cada campo do produto
    public boolean validarProduto (Produto produto) {
        if (produto == null) {
            return false;
        }

        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            return false;
        }

        if (produto.getDescricao() == null || produto.getDescricao().isEmpty()) {
            return false;
        }

        if (produto.getPreco() <= 0) {
            return false;
        }

        return true;
    }

    // Adicionar uma categoria a um produto ja existente
    public boolean addCategoria (Produto produto, Categoria categoria) {
        if (!validarCategoria(categoria)) {
            return false;
        }

        produto.addCategoria(categoria);

        return true;
    }
    
    // Validar categoria antes de adicionar um produto nela
    public boolean validarCategoria (Categoria categoria) {
        if (!categoriaService.validarCategoria(categoria)) {
            return false;
        }

        return true;
    }
}