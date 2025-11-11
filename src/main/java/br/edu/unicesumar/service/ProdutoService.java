package br.edu.unicesumar.service;

import java.util.List;

import br.edu.unicesumar.dao.ProdutoDAO;

import br.edu.unicesumar.model.Produto;

import br.edu.unicesumar.exception.BusinessException;

public class ProdutoService {
    private final ProdutoDAO produtoDAO;
    private final CategoriaService categoriaService;

    public ProdutoService () {
        this.produtoDAO = new ProdutoDAO();
        this.categoriaService = new CategoriaService();
    }

    // Salvar o produto no banco de dados
    public void saveProduto (Produto produto) throws BusinessException {
        validarProduto(produto);

        categoriaService.validarCategoria(produto.getCategoria());

        produtoDAO.save(produto);
    }

    // Validar cada campo do produto
    public void validarProduto (Produto produto) throws BusinessException {
        if (produto == null) {
            throw new BusinessException("Produto não pode ser nulo.");
        }

        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new BusinessException("Nome do produto não pode ser nulo.");
        }

        if (produto.getDescricao() == null || produto.getDescricao().isEmpty()) {
            throw new BusinessException("Descrição do produto não pode ser nula.");
        }

        if (produto.getPreco() <= 0) {
            throw new BusinessException("Preco do produto não pode ser negativo.");
        }

        if (produto.getCategoria() == null) {
            throw new BusinessException("Categoria do produto não pode ser nula.");
        }
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