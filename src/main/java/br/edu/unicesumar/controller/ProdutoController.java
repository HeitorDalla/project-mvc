package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.ProdutoService;

import br.edu.unicesumar.model.Produto;
import br.edu.unicesumar.exception.BusinessException;
import br.edu.unicesumar.model.Categoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController() {
        this.produtoService = new ProdutoService();
    }

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void saveProduto () {
        try {
            Categoria c = new Categoria();
            c.setNome("Comida");

            Produto p = new Produto();
            p.setNome("Limao");
            p.setDescricao("Bom para salada");
            p.setPreco(10);
            p.setCategoria(c); // adicionando a categoria ao produto

            // Salva tudo de uma vez
            produtoService.saveProduto(p);

            label.setText("Produto adicionado com sucesso!");
        } catch (BusinessException ex) {
            label.setText(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();

            label.setText("Erro ao salvar o produto. Verifique os dados!");
        }
    }
}