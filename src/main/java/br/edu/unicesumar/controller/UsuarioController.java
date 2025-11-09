package br.edu.unicesumar.controller;

import br.edu.unicesumar.service.UsuarioService;

import br.edu.unicesumar.model.Endereco;
import br.edu.unicesumar.model.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UsuarioController {
    /* PRIMEIRO VAI CRIAR OS OBJETOS 'ENDERECO' E 'USUARIO'. DEPOIS CHAMA O 'USUARIOSERVICE' */
    /* NUNCA VAI ACESSAR O BANCO DE DADOS */

    /* ligacao entre a view e controller */
    @FXML
    private Label label;

    UsuarioService usuarioService = new UsuarioService();

    @FXML
    public void saveUsuario () {
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

        // Vai enviar um objeto com os dados para salvar e verificar no banco de dados
        boolean sucesso = usuarioService.saveUsuario(u);

        // Mensagem de verificação
        if (sucesso) {
            label.setText("Usuário e Endereço salvo com sucesso!");
        } else {
            label.setText("Erro ao salvar o usuário. Verifique os dados!");
        }
    }
}