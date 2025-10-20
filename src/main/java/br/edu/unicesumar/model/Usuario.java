package br.edu.unicesumar.model;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

// INFORMACAO PARA O JPA QUE ESTA OBJETO É UMA TABELA NO BANCO
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationTyoe.AUTO) // indicar a estrategia que vai utilizar para que o banco controle o identificador na tabela
    private int id;

    @Column(name = "nome_usuario")
    private String nome;

    @Column(name = "cpf_usuario", nullable = false)
    private String cpf_usuario;

    // CONSTRUTORES
    public Usuario () {}

    public Usuario (int id, String nome, String cpf_usuario) {
        this.id = id;
        this.nome = nome;
        this.cpf_usuario = cpf_usuario;
    }

    // MÉTODOS GET E SET
    public int getId () {
        return this.id;
    }

    public int getNome () {
        return this.nome;
    }

    public int getCpf () {
        return this.cpf_usuario;
    }

    public void setId (int id) {
        this.id = id;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public void setCpf (String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }
}
