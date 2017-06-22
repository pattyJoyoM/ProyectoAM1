package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etuser,etpass;
    private Button btningresar,btncancelar;
    UsuarioEntity usuarioEntity;
    private String usu,password,u,p;
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
                usu=etuser.getText().toString().trim();
                password=etpass.getText().toString().trim();

                gotoMain();

               /* if (validar())
                {
                    UsuarioAplication aplication=(UsuarioAplication)getApplication();
                    aplication.setUsuarioEntity(usuarioEntity);

                    gotoMain();


                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Revisa usuario y contraseña",
                            Toast.LENGTH_SHORT).show();
                }*/
            }
        });


        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

 /*   private boolean validar()
    {
        usu=etuser.getText().toString().trim();
        password=etpass.getText().toString().trim();

 UsuarioAplication application=(UsuarioAplication)getApplication();
        if(usu.isEmpty()){
            etuser.setError("Obligatorio");
            return false;
        }
        if(password.isEmpty()){
            etpass.setError("Obligatorio");
            return false;
        }

       usuarioEntity = application.validar(usu,password);

        if(usuarioEntity==null){
            return false;
        }

        return true;
    }*/

    private void gotoMain()
    {
        Intent intent = new Intent(LoginActivity.this,ListaPersonaActivity.class);
        startActivity(intent);
        finish();
    }

}
