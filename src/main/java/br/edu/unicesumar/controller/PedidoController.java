package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.PedidoService;

import br.edu.unicesumar.enumerate.StatusPedido;

import br.edu.unicesumar.model.Endereco;
import br.edu.unicesumar.model.Pedido;
import br.edu.unicesumar.model.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PedidoController {
    // Dependência Injetada
    private final PedidoService pedidoService;
    
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void savePedido () {
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.ABERTO);

        Endereco e = new Endereco();
        e.setLogradouro("Avenida Paulista");
        e.setNumero("66");
        e.setBairro("Bairro Jardim Estatal");
        e.setCidade("Ribeirão Preto");
        e.setEstado("São Paulo");
        e.setCep("86049013");

        Usuario u = new Usuario();
        u.setNome("Heitor");
        u.setCpf("000000000-0");
        u.setEmail("email@gmail.com");
        u.setEndereco(e); // adicionando o endereco ao cliente

        pedido.setUsuario(u); // adicionando o cliente ao pedido

        // Salvando no banco (cascade - salva tudo automaticamente)
        boolean sucesso = pedidoService.savePedido(pedido);

        // Mensagem de conclusão
        if (sucesso) {
            label.setText("Pedido salvo com sucesso!");
        } else {
            label.setText("Erro ao tentar salvar pedido. Verifique os dados!");
        }
    }
}