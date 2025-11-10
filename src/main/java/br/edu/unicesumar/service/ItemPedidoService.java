package br.edu.unicesumar.service;

import br.edu.unicesumar.dao.ItemPedidoDAO;

import br.edu.unicesumar.model.ItemPedido;
import br.edu.unicesumar.model.Pedido;

import java.util.List;

public class ItemPedidoService {
    private ItemPedidoDAO itemPedidoDAO;

    public ItemPedidoService () {
        this.itemPedidoDAO = new ItemPedidoDAO();
    }

    // Método que vai salvar o itemPedido dentro do pedido no banco de dados
    public boolean saveItemPedido (Pedido pedido, ItemPedido itemPedido) {
        if (!validarItemPedido(itemPedido)) {
            return false;
        }

        if (pedido == null) {
            return false;
        }

        itemPedidoDAO.save(itemPedido);

        return true;
    }

    // Método que vai validar todos o objeto ItemPedido e todos os campos de ItemPedido
    public boolean validarItemPedido (ItemPedido itemPedido) {
        if (itemPedido == null) {
            return false;
        }

        if (itemPedido.getProduto() == null) {
            return false;
        }

        if (itemPedido.getQuantidade() <= 0) {
            return false;
        }

        return true;
    }

    // Recebe o id do Controller, busca o ItemPedido no DAO e retorna o resultado ao Controller
    public ItemPedido findById(int id) {
        return itemPedidoDAO.findById(id);
    }

    // Listar todos os ItensPedido
    public List<ItemPedido> listAll () {
        return itemPedidoDAO.listAll();
    }
}