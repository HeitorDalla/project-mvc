package br.edu.unicesumar.service;

import java.util.List;

import br.edu.unicesumar.dao.ProdutoDAO;

import br.edu.unicesumar.model.Produto;

public class ProdutoService {
    private final ProdutoDAO produtoDAO;
    private final CategoriaService categoriaService;

    public ProdutoService () {
        this.produtoDAO = new ProdutoDAO();
        this.categoriaService = new CategoriaService();
    }

    // Salvar o produto no banco de dados
    public boolean saveProduto (Produto produto) {
        if (!validarProduto(produto)) {
            return false;
        }

        if (!categoriaService.validarCategoria(produto.getCategoria())) {
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

        if (produto.getCategoria() == null) {
            return false;
        }

        return true;
    }

    // Recebe o id do Controller, busca o Produto no DAO e retorna o resultado ao Controller
    public Produto findById(int id) {
        return produtoDAO.findById(id);
    }

    // Método para listar todos os Produtos
    public List<Produto> listAll () {
        return produtoDAO.listAll();
    }
}