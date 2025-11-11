package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.CategoriaService;
import br.edu.unicesumar.exception.BusinessException;
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
        try {
            Categoria c = new Categoria();
            c.setNome("Eletrônicos");

            // Salva tudo de uma vez
            categoriaService.saveCategoria(c);

            label.setText("Categoria adicionada com sucesso!");
        } catch (BusinessException ex) {
            label.setText(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();

            label.setText("Erro ao tentar salvar categoria. Verifique os dados!");
        }
    }
}