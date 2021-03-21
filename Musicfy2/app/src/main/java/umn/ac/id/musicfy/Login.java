package umn.ac.id.musicfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;
    Button bckbtn;

    String correct_username = "uasmobile";
    String correct_password = "uasmobilegenap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button);
        bckbtn = findViewById(R.id.bckbtn);

        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty((password.getText().toString()))){
                    Toast.makeText(Login.this,"Empty Data", Toast.LENGTH_LONG).show();
                }else if (username.getText().toString().equals(correct_username)) {
                    if (password.getText().toString().equals(correct_password)) {
                        Sukses();
                    } else {
                        Toast.makeText(Login.this, "Invalid Username", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(Login.this, "Invalid Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Sukses() {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}