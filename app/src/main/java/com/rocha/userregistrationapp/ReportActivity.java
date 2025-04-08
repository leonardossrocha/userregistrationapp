package com.rocha.userregistrationapp;

import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;

public class ReportActivity extends AppCompatActivity {
    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        textViewReport = findViewById(R.id.textViewReport);

        // Encontra o botão e define um clique para voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> voltarParaCadastro());

        UserDatabase db = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "user-database").allowMainThreadQueries().build();
        UserDao userDao = db.userDao();

        List<User> userList = userDao.getAllUsers();
        StringBuilder report = new StringBuilder();

        for (User user : userList) {
            report.append("Nome: ").append(user.getName()).append("\n")
                    .append("CPF: ").append(user.getCpf()).append("\n\n");
        }

        textViewReport.setText(report.toString());
    }

    public void voltarParaCadastro() {
        // Intenção para abrir a tela de cadastro
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Fecha a tela de relatório para não ficar acumulada na pilha de atividades
    }
}
