package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.CategoriaService;

import br.edu.unicesumar.model.Categoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CategoriaController {
    private CategoriaService categoriaService;
    
    public CategoriaController() {
        this.categoriaService = new CategoriaService();
    }

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void saveCategoria () {
        Categoria c = new Categoria();
        c.setNome("Eletrônicos");

        // Salva tudo de uma vez
        boolean sucesso = categoriaService.saveCategoria(c);

        // Mensagem de conclusão
        if (sucesso) {
            label.setText("Categoria adicionada com sucesso!");
        } else {
            label.setText("Erro ao tentar salvar categoria. Verifique os dados!");
        }
    }
}