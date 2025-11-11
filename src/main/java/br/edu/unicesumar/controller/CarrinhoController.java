package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.CarrinhoService;
import br.edu.unicesumar.exception.BusinessException;
import br.edu.unicesumar.model.Carrinho;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CarrinhoController {
    private CarrinhoService carrinhoService;
    private Carrinho carrinhoAtual;
    
    public CarrinhoController() {
        this.carrinhoService = new CarrinhoService();
        this.carrinhoAtual = new Carrinho(); // carrinho começa vazio
    }

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void saveCarrinho () {
        try {
            carrinhoService.saveCarrinho(carrinhoAtual);

            label.setText("Carrinho adicionado com sucesso!");
        } catch (BusinessException ex) {
            label.setText(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();

            label.setText("Erro ao tentar salvar carrinho!");
        }
    }
}