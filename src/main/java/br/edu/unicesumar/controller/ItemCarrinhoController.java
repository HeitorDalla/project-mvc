package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.ItemCarrinhoService;
import br.edu.unicesumar.service.ProdutoService;

import br.edu.unicesumar.model.ItemCarrinho;
import br.edu.unicesumar.model.Produto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ItemCarrinhoController {
    private ItemCarrinhoService itemCarrinhoService;
    private ProdutoService produtoService;
    
    public ItemCarrinhoController() {
        this.itemCarrinhoService = new ItemCarrinhoService();
        this.produtoService = new ProdutoService();
    }

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void saveItemCarrinho () {
        // Vai vir da UI
        int idProdutoSelecionado = 1;
        int quantidadeSelecionada = 2;

        Produto produto = produtoService.findById(idProdutoSelecionado);
        if (produto == null) {
            return;
        }

        ItemCarrinho ic = new ItemCarrinho();
        ic.setProduto(produto);
        ic.setQuantidade(quantidadeSelecionada);
        
        // Salva tudo de uma vez
        boolean sucesso = itemCarrinhoService.saveItemCarrinho(ic);

        // Mensagem de conclusão
        if (sucesso) {
            label.setText("Item adicionada ao carrinho com sucesso!");
        } else {
            label.setText("Erro ao tentar salvar item no carrinho. Verifique os dados!");
        }
    }
}