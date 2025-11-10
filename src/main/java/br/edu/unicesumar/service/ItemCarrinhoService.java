package br.edu.unicesumar.service;

import br.edu.unicesumar.dao.ItemCarrinhoDAO;

import br.edu.unicesumar.model.ItemCarrinho;

public class ItemCarrinhoService {
    // Injeção de Dependência
    private final ItemCarrinhoDAO itemCarrinhoDAO;
    private final ProdutoService produtoService;

    public ItemCarrinhoService (ItemCarrinhoDAO itemCarrinhoDAO, ProdutoService produtoService) {
        this.itemCarrinhoDAO = itemCarrinhoDAO;
        this.produtoService = produtoService;
    }

    // Método que salvar/validar no banco de dados
    public boolean saveItemCarrinho (ItemCarrinho itemCarrinho) {
        if (!validarItemCarrinho(itemCarrinho)) {
            return false;
        }

        itemCarrinhoDAO.save(itemCarrinho);

        return true;
    }

    // Validar o ItemCarrinho antes de salvar no banco de dados
    public boolean validarItemCarrinho (ItemCarrinho itemCarrinho) {
        if (itemCarrinho.getProduto() == null) {
            return false;
        }

        // Chame o ProdutoService para validar o produto completo
        if (!produtoService.validarProduto(itemCarrinho.getProduto())) {
            return false;
        }

        if (itemCarrinho.getQuantidade() <= 0) {
            return false;
        }

        return true;
    }
}