package com.rocha.userregistrationapp;

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
}
