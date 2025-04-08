/*
package com.rocha.userregistrationapp;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM user")
    List<User> getAllUsers();
}
*/

// Define o pacote onde a interface está localizada
package com.rocha.userregistrationapp;
/*
O Data Access Object é o componente que serve para persistência de dados. Serve para definir
as operações que podem ser feitas no banco de dados com relação à entidade User
*/
// Importa as anotações do Room necessárias para definir o DAO (Data Access Object)
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

// Importa a classe List do Java para retornar uma lista de usuários
import java.util.List;

// Anotação que indica que esta interface é um DAO do Room
@Dao
public interface UserDao {

    // Método para inserir um usuário na tabela do banco de dados
    // A anotação @Insert informa ao Room que este método deve ser usado para inserir dados
    @Insert
    void insert(User user);

    // Método para buscar todos os usuários cadastrados no banco de dados
    // A anotação @Query permite definir uma consulta SQL personalizada
    @Query("SELECT * FROM user")
    List<User> getAllUsers();
}
