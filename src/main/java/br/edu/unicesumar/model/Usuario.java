package br.edu.unicesumar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import jakarta.persistence.CascadeType;

//INFORMANDO PARA O JPA QUE ESTE OBJETO É UMA TABELA NO BANCO
@Entity
@Table(name="usuario_tbl")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_usuario")
    private int id;

    @Column(name="nome_usuario", nullable = false)
    private String nome;
    
    @Column(name="cpf_usuario", nullable = false)
    private String cpf;

    @Column(name="email_usuario", nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_usuario", referencedColumnName = "id_endereco")
    private Endereco endereco;

    // CONSTRUTORES
    public Usuario () {}

    public Usuario(int id, String nome, String cpf, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    // MÉTODOS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}