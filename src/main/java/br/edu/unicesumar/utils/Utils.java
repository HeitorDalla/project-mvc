package br.edu.unicesumar.utils;

// MÉTODOS QUE VAO SER UTILIZADO POR DIFERENTES CLASSES
public class Utils {
    public static boolean validarCPF (String cpf) {
        // VALIDAÇÃO GENÉRICA DE CPF
        if (cpf.length() < 11) {
            return false;
        }

        return true;
    }
}