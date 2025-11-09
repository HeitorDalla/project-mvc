package br.edu.unicesumar.service;

import br.edu.unicesumar.dao.PedidoDAO;
import br.edu.unicesumar.model.Pedido;
import br.edu.unicesumar.model.Usuario;
import br.edu.unicesumar.utils.Utils;

public class PedidoService {
    // Atributo que vai armazenar o pedidoDAO
    private PedidoDAO pedidoDAO;

    // Construtor do pedido
    public PedidoService () {
        /* Instancia o pedidoDAO, que vai ser responsabilizado por chamar o banco de dados */
        this.pedidoDAO = new PedidoDAO();
    }

    public boolean savePedido (Pedido pedido) {
        // Apenas verifica se o objeto Usuario não é nulo, não verifica campo algum do objeto
        if (pedido.getUsuario() == null) {
            return false;
        }

        Usuario usuario = pedido.getUsuario();

        // Verificar cada campo do objeto usuario
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) { // verificar nome nulo ou vazio
            return false;
        }

        if (usuario.getCpf() == null || !Utils.validarCPF(usuario.getCpf())) {
            return false;
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            return false;
        }

        // Se todos as validações forem corretas, ele chama o DAO para salvar no banco de dados
        pedidoDAO.save(pedido);

        return true;
    }
}