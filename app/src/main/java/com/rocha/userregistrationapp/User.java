// Define o pacote ao qual esta classe pertence
package com.rocha.userregistrationapp;

// Importa as anotações do Room necessárias para mapear esta classe como uma entidade do banco de dados
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Anotação que indica que esta classe representa uma entidade (tabela) no banco de dados Room
@Entity
public class User {

    // Define o campo 'id' como chave primária da tabela e configura para ser gerado automaticamente
    @PrimaryKey(autoGenerate = true)
    private int id;

    // Campos que representam as colunas da tabela para armazenar os dados do usuário
    private String name;   // Nome do usuário
    private String cpf;    // CPF do usuário
    private String email;  // Email do usuário
    private String phone;  // Telefone do usuário

    // Construtor da classe que será usado para criar novos objetos User
    public User(String name, String cpf, String email, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    // Métodos getter e setter para acessar e modificar os dados do objeto User

    // Retorna o ID do usuário
    public int getId() { return id; }

    // Define o ID do usuário (usado pelo Room para preencher automaticamente)
    public void setId(int id) { this.id = id; }

    // Retorna o nome do usuário
    public String getName() { return name; }

    // Retorna o CPF do usuário
    public String getCpf() { return cpf; }

    // Retorna o email do usuário
    public String getEmail() { return email; }

    // Retorna o telefone do usuário
    public String getPhone() { return phone; }
}