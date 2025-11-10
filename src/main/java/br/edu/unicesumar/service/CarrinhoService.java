package br.edu.unicesumar.service;

import java.util.List;

import br.edu.unicesumar.dao.CarrinhoDAO;

import br.edu.unicesumar.model.Carrinho;
import br.edu.unicesumar.model.ItemCarrinho;

public class CarrinhoService {
    private CarrinhoDAO carrinhoDAO;

    public CarrinhoService () {
        this.carrinhoDAO = new CarrinhoDAO();
    }

    public boolean saveCarrinho (Carrinho carrinho) {
        // Verificar se o carrinho esta vazio, se tiver, nao salva
        if (carrinho == null) {
            return false;
        }

        // Verificar se a lista de itens esta vazia, se tiver, nao salva
        List<ItemCarrinho> itens = carrinho.getItens();
        if (itens == null || itens.isEmpty()) {
            return false;
        }
        
        // Verificar itens sem produto ou quantidade, se tiver, nao salva
        for (ItemCarrinho item : itens) {
            if (item.getProduto() == null || item.getQuantidade() <= 0) {
                return false;
            }
        }

        carrinhoDAO.save(carrinho);
        return true;
    }

    // Recebe o id do Controller, busca o carrinho no DAO e retorna o resultado ao Controller
    public Carrinho findById(int id) {
        return carrinhoDAO.findById(id);
    }

    // Método para listar todos os Carrinhos
    public List<Carrinho> listAll () {
        return carrinhoDAO.listAll();
    }
}