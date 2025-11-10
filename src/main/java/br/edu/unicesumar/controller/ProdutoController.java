package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.ProdutoService;

import br.edu.unicesumar.model.Produto;
import br.edu.unicesumar.model.Categoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProdutoController {
    // Injeção de Dependência
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void saveProduto () {
        Categoria c = new Categoria();
        c.setNome("Comida");

        Produto p = new Produto();
        p.setNome("Limao");
        p.setDescricao("Bom para salada");
        p.setPreco(10);
        p.setCategoria(c); // adicionando a categoria ao produto

        // Salva tudo de uma vez
        boolean sucesso = produtoService.saveProduto(p);

        // Mensagem de conclusão
        if (sucesso) {
            label.setText("Produto adicionado com sucesso!");
        } else {
            label.setText("Erro ao salvar o produto. Verifique os dados!");
        }
    }
}