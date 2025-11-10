package br.edu.unicesumar.service;

import java.util.List;

import br.edu.unicesumar.dao.ItemCarrinhoDAO;

import br.edu.unicesumar.model.ItemCarrinho;
import br.edu.unicesumar.model.Produto;

public class ItemCarrinhoService {
    private ItemCarrinhoDAO itemCarrinhoDAO;
    private ProdutoService produtoService;

    public ItemCarrinhoService () {
        this.itemCarrinhoDAO = new ItemCarrinhoDAO();
        this.produtoService = new ProdutoService();
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
        if (itemCarrinho == null) {
            return false;
        }

        if (itemCarrinho.getProduto() == null) {
            return false;
        }

        // Verificar se o produto ja existe no banco de dados
        Produto produto = produtoService.findById(itemCarrinho.getProduto().getId());
        if (produto == null) {
            return false;
        }

        if (itemCarrinho.getQuantidade() <= 0) {
            return false;
        }

        return true;
    }

    // Recebe o id do Controller, busca o ItemCarrinho no DAO e retorna o resultado ao Controller
    public ItemCarrinho findById(int id) {
        return itemCarrinhoDAO.findById(id);
    }

    // Método para listar todos os Usuários
    public List<ItemCarrinho> listAll () {
        return itemCarrinhoDAO.listAll();
    }
}