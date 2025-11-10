package br.edu.unicesumar.service;

import br.edu.unicesumar.dao.UsuarioDAO;

import br.edu.unicesumar.model.Usuario;

import br.edu.unicesumar.utils.Utils;

public class UsuarioService {
    /* Aqui vai ter regras de negócio */
    /* Se algo der errado, ele vai retornar SEM SALVAR */
    /* Chama o DAO para acessar o banco de dados */

    // Atributo que vai armazenar o usuarioDAO
    private final UsuarioDAO usuarioDAO;

    // Construtor da classe servico do usuario
    public UsuarioService (UsuarioDAO usuarioDAO) {
        /* Instancia o usuarioDAO, que vai ser responsabilizado por chamar o banco de dados */
        this.usuarioDAO = usuarioDAO;
    }

    // Método que vai salvar usuario e validar/enviar para o banco de dados
    public boolean saveUsuario (Usuario usuario) { // recebe o objeto passado do controller do ususario
        if (!validarUsuario(usuario)) {
            return false;
        }

        // Caso as validações estejam corretas, ele chama o DAO para savar/validar no banco de dados
        usuarioDAO.save(usuario);

        return true;
    }

    // Método que validar cada campo do Usuario
    public boolean validarUsuario (Usuario usuario) {
        // Apenas verifica se o objeto Usuario não é nulo, não verifica campo algum do objeto
        if (usuario == null) {
             return false;
        }

        // Validação para o nome do usuário
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            return false;
        }

        // Validação complexa para o cpf
        if (!Utils.validarCPF(usuario.getCpf())) {
            return false;
        }

        return true;
    }
}