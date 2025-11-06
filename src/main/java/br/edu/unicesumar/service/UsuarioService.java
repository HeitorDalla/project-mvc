package br.edu.unicesumar.service;

import br.edu.unicesumar.dao.UsuarioDAO;
import br.edu.unicesumar.model.Usuario;
import br.edu.unicesumar.utils.Utils;

public class UsuarioService {
    /* Aqui vai ter regras de negócio */
    /* Se algo der errado, ele vai retornar SEM SALVAR */
    /* NUNCA VAI ACESSAR O BANCO DE DADOS */
    /* Sempre vai pedir para o DAO fazer isso */

    // Atributo que vai armazenar o usuarioDAO
    private UsuarioDAO usuarioDAO;

    // Construtor da classe servico do usuario
    public UsuarioService () {
        /* Instancia o usuarioDAO, que vai ser responsabilizado por chamar o banco de dados */
        this.usuarioDAO = new UsuarioDAO();
    }

    public void saveUsuario (Usuario usuario) { // recebe o objeto passado do controller do ususario
        // Validação para o nome do usuário
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            return;
        }

        // Validação simples para o cpf do usuario
        if (usuario.getCpf() == null || usuario.getCpf().isEmpty()) {
            return;
        }

        // Validação complexa para o cpf
        if (!Utils.validarCPF(usuario.getCpf())) {
            return;
        }

        // Caso as validações estejam corretas, ele 
        usuarioDAO.save(usuario);
    }
}