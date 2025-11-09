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
@Entity // indica ao JAP que essa classe é uma ENTIDADE e deve ser mapeada dentro do banco de dados
@Table(name="usuario_tbl") // nome da tabela no banco de dados
public class Usuario {

    @Id // marca como a CHAVE PRIMÁRIA da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que o banco de dados é responsavel por gerar o valor (auto-increment)
    @Column(name="id_usuario")
    private int id;

    @Column(name="nome_usuario", nullable = false)
    private String nome;
    
    @Column(name="cpf_usuario", nullable = false)
    private String cpf;

    @Column(name="email_usuario", nullable = false)
    private String email;

    // OneToOne - relacionado a um e somente um endereco
    // cascade = CascadeType.ALL - se eu atualizar, remover ou persistir um Usuario, a operacao tambem correspondera ao Endereco
    // optional = false - indica que o Endereco é OBRIGATÓRIO para que um Usuario exista
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_usuario", nullable = false) // especifica a chave estrangeira, sendo obrigatória (nullable = false)
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