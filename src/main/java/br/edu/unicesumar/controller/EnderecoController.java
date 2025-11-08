package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.EnderecoService;
import br.edu.unicesumar.model.Endereco;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EnderecoController {
    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    EnderecoService enderecoService = new EnderecoService();

    @FXML
    public void saveEndereco () {
        Endereco e = new Endereco();
        
        e.setLogradouro("Exemplo de logradouro");
        e.setNumero("44");
        e.setBairro("Exe");
        e.setCidade("Ribeirão Preto");
        e.setEstado("São Paulo");
        e.setCep("86049013");

        enderecoService.saveEndereco(e);
    }
}