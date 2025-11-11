package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.ItemPedidoService;
import br.edu.unicesumar.service.PedidoService;
import br.edu.unicesumar.service.ProdutoService;
import br.edu.unicesumar.exception.BusinessException;
import br.edu.unicesumar.model.ItemPedido;
import br.edu.unicesumar.model.Pedido;
import br.edu.unicesumar.model.Produto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ItemPedidoController {
    private PedidoService pedidoService;
    private ItemPedidoService itemPedidoService;
    private ProdutoService produtoService;

    public ItemPedidoController() {
        this.pedidoService = new PedidoService();
        this.itemPedidoService = new ItemPedidoService();
        this.produtoService = new ProdutoService();
    }

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void saveItemPedido () {
        try {
            // Vai vir da UI (exemplo: 1)
            int idPedido = 1;
            int quantidadeSelecionada = 1;
            
            // Controller - Service
            Pedido pedido = pedidoService.findById(idPedido);
            if (pedido == null) {
                label.setText("Pedido não encontrado!");
                return;
            }

            // Vai vir da UI (exemplo: 1)
            Produto produto = produtoService.findById(1);
            if (produto == null) {
                label.setText("Produto não encontrado!");
                return;
            }

            ItemPedido ip = new ItemPedido();
            ip.setProduto(produto);
            ip.setQuantidade(quantidadeSelecionada);

            // Adiciona o item ao pedido - ja calcula o valor total e set o pedido no item
            pedido.addItemPedido(ip);

            // Salva tudo de uma vez
            itemPedidoService.saveItemPedido(pedido, ip);

            label.setText("Item adicionado ao pedido salvo com sucesso!");
        } catch (BusinessException ex) {
            label.setText(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();

            label.setText("Erro ao tentar salvar item no carrinho. Verifique os dados!");
        }
    }
}