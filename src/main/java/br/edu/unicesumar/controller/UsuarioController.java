package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.UsuarioService;

import br.edu.unicesumar.model.Endereco;
import br.edu.unicesumar.model.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import br.edu.unicesumar.exception.BusinessException;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }
    
    /* PRIMEIRO VAI CRIAR OS OBJETOS 'ENDERECO' E 'USUARIO'. DEPOIS CHAMA O 'USUARIOSERVICE' */
    /* NUNCA VAI ACESSAR O BANCO DE DADOS */

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    @FXML
    public void saveUsuario () {
        try {
            Endereco e = new Endereco();
            e.setLogradouro("Avenida Paulista");
            e.setNumero("66");
            e.setBairro("Bairro Jardim Estatal");
            e.setCidade("Ribeirão Preto");
            e.setEstado("São Paulo");
            e.setCep("86049013");

            Usuario u = new Usuario();
            u.setNome("Heitor");
            u.setCpf("000000000-0");
            u.setEmail("email@gmail.com");
            u.setEndereco(e);

            usuarioService.saveUsuario(u);

            label.setText("Usuário e Endereço salvo com sucesso!");
        } catch (BusinessException ex) {
            label.setText(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            
            label.setText("Erro ao salvar o usuário. Verifique os dados!");
        }
    }
}