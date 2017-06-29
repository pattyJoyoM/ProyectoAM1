package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etuser,etpass;
    private Button btningresar,btncancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etuser=(EditText)findViewById(R.id.etuser);
        etpass=(EditText)findViewById(R.id.etpass);
        btningresar=(Button)findViewById(R.id.btningresar);
        btncancelar=(Button)findViewById(R.id.btncancelar);

        events();

    }
    private  void  events(){
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (etuser.getText().toString().equals("isil") &&
                     etpass.getText().toString().equals("123")||etuser.getText().toString().equals("paty") &&
                     etpass.getText().toString().equals("joyo")){
                 gotoMain();
             }
             else
             {
                 Toast.makeText(getApplicationContext(), "Contraseña y/o usuario incorrecto",
                         Toast.LENGTH_SHORT).show();

             }

            }
        });


        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }



    private void gotoMain()
    {
        Intent intent = new Intent(LoginActivity.this,PrincipalActivity.class);
        startActivity(intent);
        finish();
    }



    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

}
