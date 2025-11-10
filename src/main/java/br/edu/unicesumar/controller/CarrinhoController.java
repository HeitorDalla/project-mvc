package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.CarrinhoService;

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
        boolean sucesso = carrinhoService.saveCarrinho(carrinhoAtual);

        // Mensagem de conclusão
        if (sucesso) {
            label.setText("Carrinho adicionado com sucesso!");
        } else {
            label.setText("Erro ao tentar salvar carrinho!");
        }
    }
}