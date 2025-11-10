package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.CategoriaService;

import br.edu.unicesumar.model.Categoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CategoriaController {
    // Injeção de Dependência
    private final CategoriaService categoriaService;
    
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void saveCategoria () {
        Categoria c = new Categoria();
        c.setNome("Eletrônicos");

        // Salva tudo de uma vez
        categoriaService.saveCategoria(c);

        // Mensagem de conclusão
        label.setText("Categoria adicionada com sucesso!");
    }
}