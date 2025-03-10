package com.rocha.userregistrationapp;

// Importação das classes necessárias para a funcionalidade do aplicativo
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;

// Classe principal da atividade de cadastro de usuários
public class MainActivity extends AppCompatActivity {
    // Declaração dos campos de entrada de dados
    private EditText editTextName, editTextCPF, editTextEmail, editTextPhone;

    // Objeto para interagir com o banco de dados (DAO)
    private UserDao userDao;

    // Método chamado quando a atividade é criada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Define o layout da tela

        // Inicializa os campos de entrada de dados do layout
        editTextName = findViewById(R.id.editTextName);
        editTextCPF = findViewById(R.id.editTextCPF);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);

        // Inicializa os botões do layout
        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonReport = findViewById(R.id.buttonReport);

        // Configuração do banco de dados usando Room
        UserDatabase db = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "user-database").allowMainThreadQueries().build();
        userDao = db.userDao(); // Obtém uma instância do DAO para interagir com os dados

        // Configura o botão de salvar usuário
        buttonSave.setOnClickListener(v -> {
            // Obtém os valores digitados pelo usuário
            String name = editTextName.getText().toString();
            String cpf = editTextCPF.getText().toString();
            String email = editTextEmail.getText().toString();
            String phone = editTextPhone.getText().toString();

            // Verifica se os campos obrigatórios (Nome e CPF) foram preenchidos
            if (!name.isEmpty() && !cpf.isEmpty()) {
                // Cria um novo objeto usuário e insere no banco de dados
                User user = new User(name, cpf, email, phone);
                userDao.insert(user);

                // Exibe uma mensagem confirmando o cadastro
                Toast.makeText(MainActivity.this, "Usuário cadastrado!", Toast.LENGTH_SHORT).show();
            } else {
                // Exibe uma mensagem de erro se os campos obrigatórios não forem preenchidos
                Toast.makeText(MainActivity.this, "Preencha os campos obrigatórios!", Toast.LENGTH_SHORT).show();
            }
        });

        // Configura o botão de relatório para abrir a tela de relatório
        buttonReport.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ReportActivity.class))
        );
    }
}
