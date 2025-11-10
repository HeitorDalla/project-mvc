package br.edu.unicesumar.service;

import java.util.List;

import br.edu.unicesumar.dao.PedidoDAO;

import br.edu.unicesumar.model.ItemPedido;
import br.edu.unicesumar.model.Pedido;

public class PedidoService {
    private PedidoDAO pedidoDAO;
    private UsuarioService usuarioService;

    public PedidoService () {
        this.pedidoDAO = new PedidoDAO();
        this.usuarioService = new UsuarioService();
    }

    // Salva o pedido e envia para o DAO armazenar/validar no banco de dados
    public boolean savePedido (Pedido pedido) {
        if (!validarPedido(pedido)) {
            return false;
        }

        // Se todos as validações forem corretas, ele chama o DAO para salvar no banco de dados
        pedidoDAO.save(pedido);

        return true;
    }

    // Adiciona o itemPedido ao pedido
    public boolean addItemPedido (Pedido pedido, ItemPedido itemPedido) {
        // Validar item antes de adicionar
        if (!validarItemPedido(itemPedido)) {
            return false;
        }
        
        pedido.addItemPedido(itemPedido);

        return true;
    }

    // Valida o pedido antes de salvar no banco de dados (DAO)
    public boolean validarPedido (Pedido pedido) {
        // Apenas verifica se o objeto Usuario não é nulo, não verifica campo algum do objeto
        if (pedido.getUsuario() == null) {
            return false;
        }

        // Chame o UsuarioService para validar o Usuario completo
        if (!usuarioService.validarUsuario(pedido.getUsuario())) {
            return false;
        }

        return true;
    }

    // Valida as informacoes do item antes de adicionar ao pedido
    public boolean validarItemPedido (ItemPedido itemPedido) {
        if (itemPedido.getProduto() == null) {
            return false;
        }
        
        if (itemPedido.getQuantidade() <=0) {
            return false;
        }

        return true;
    }

    // Recebe o id do Controller, busca o Pedido no DAO e retorna o resultado ao Controller
    public Pedido findById(int id) {
        return pedidoDAO.findById(id);
    }

    // Método para listar todos os Usuários
    public List<Pedido> listAll () {
        return pedidoDAO.listAll();
    }
}