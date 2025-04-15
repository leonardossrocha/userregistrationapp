/*package com.rocha.userregistrationapp;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

// Classe UserDatabase gerencia a Room Database
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase instance;

    public abstract UserDao userDao();

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase.class, "user-database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
        }
        return instance;
    }
}
*/
// Define o pacote onde essa classe está localizada
package com.rocha.userregistrationapp;

// Importa as anotações e classes da biblioteca Room e do Android
import androidx.room.Database;              // Anotação para marcar a classe como um banco de dados Room
import androidx.room.Room;                 // Classe usada para criar a instância do banco de dados
import androidx.room.RoomDatabase;         // Classe base que representa o banco de dados
import android.content.Context;           // Classe que representa o contexto da aplicação (necessário para acessar recursos)

// Anotação que define que esta classe representa o banco de dados Room
// Ela especifica as entidades (tabelas) que o banco irá conter e a versão do banco
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    // Instância única (singleton) do banco de dados
    private static UserDatabase instance;

    // Método abstrato que será implementado automaticamente pelo Room.
    // Ele serve para acessar as operações de banco definidas no UserDao.
    public abstract UserDao userDao();

    // Método que retorna a instância do banco de dados
    // O uso de 'synchronized' garante que apenas uma thread possa acessar este método por vez,
    // evitando que duas instâncias do banco sejam criadas acidentalmente.
    public static synchronized UserDatabase getInstance(Context context) {
        // Verifica se a instância já existe
        if (instance == null) {
            // Cria a instância do banco de dados usando o Room
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),  // Usa o contexto da aplicação para evitar vazamento de memória
                            UserDatabase.class,               // Classe do banco de dados
                            "user-database")                  // Nome do arquivo .db que será criado no dispositivo
                    .fallbackToDestructiveMigration() // Se houver mudança de versão e não houver migração,
                    // o banco será recriado do zero (isso apaga os dados)
                    .allowMainThreadQueries()         // Permite realizar operações de banco na thread principal (⚠️ só para apps pequenos/testes)
                    .build();                         // Constrói o banco de dados
        }

        // Retorna a instância criada
        return instance;
    }
}
