package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.ProdutoService;
import br.edu.unicesumar.model.Produto;
import br.edu.unicesumar.model.Categoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProdutoController {
    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    ProdutoService produtoService = new ProdutoService();

    @FXML
    public void saveProduto () {
        Categoria c = new Categoria();
        c.setNome("Comida");

        Produto p = new Produto();
        p.setNome("Limao");
        p.setDescricao("Bom para salada");
        p.setPreco(10);
        p.setCategoria(c); // adicionando a categoria ao produto

        produtoService.saveProduto(p);
    }
}