package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.ItemCarrinhoService;

import br.edu.unicesumar.model.Categoria;
import br.edu.unicesumar.model.ItemCarrinho;
import br.edu.unicesumar.model.Produto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ItemCarrinhoController {
    private ItemCarrinhoService itemCarrinhoService;
    
    public ItemCarrinhoController() {
        this.itemCarrinhoService = new ItemCarrinhoService();
    }

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void saveItemCarrinho () {
        Categoria c = new Categoria();
        c.setNome("Eletronicos");

        Produto p = new Produto();
        p.setNome("Controle remoto");
        p.setDescricao("Eletronico utilizado para controlar remotamente um brinquedo.");
        p.setPreco(200);
        p.setCategoria(c);

        ItemCarrinho ic = new ItemCarrinho();
        ic.setQuantidade(5);
        ic.setProduto(p);

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