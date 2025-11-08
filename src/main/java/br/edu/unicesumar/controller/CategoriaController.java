package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.CategoriaService;
import br.edu.unicesumar.model.Categoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CategoriaController {
    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    CategoriaService categoriaService = new CategoriaService();

    @FXML
    public void saveCategoria () {
        Categoria c = new Categoria();
        c.setNome("Eletrônicos");

        categoriaService.saveCategoria(c);
    }
}