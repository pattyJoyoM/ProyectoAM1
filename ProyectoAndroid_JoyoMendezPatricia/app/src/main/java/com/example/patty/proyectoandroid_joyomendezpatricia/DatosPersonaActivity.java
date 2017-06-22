package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by PATTY on 21/06/2017.
 */

public class DatosPersonaActivity extends AppCompatActivity {
    private TextView tvNombreV,tvApellidoV,tvEdadV, tvDireccionV,tvNumDocV,tvFechaCV,tvTipoDocV,tvCaracV;
    private Button btnVolver;


    private PersonaEntity mPersonaV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_persona);



        tvNombreV=(TextView) findViewById(R.id.tvNombreV);
        tvApellidoV=(TextView)findViewById(R.id.tvApellidoV);
       tvDireccionV=(TextView)findViewById(R.id.tvDireccionV);
        tvEdadV=(TextView)findViewById(R.id.tvEdadV);
      // tvFechaCV=(TextView)findViewById(R.id.tvFechaCV);
      // tvTipoDocV=(TextView)findViewById(R.id.tvTipoDocV);
       //tvNumDocV=(TextView)findViewById(R.id.tvNumDocV);
        tvCaracV=(TextView)findViewById(R.id.tvCaracV);



        btnVolver=(Button)findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(btnVolverOnClickListener);


        mPersonaV=getIntent().getParcelableExtra("arg_persona");

        if (mPersonaV!=null) {

            tvNombreV.setText(mPersonaV.getNombre());
            tvApellidoV.setText(mPersonaV.getApellido());
           tvDireccionV.setText(mPersonaV.getDirecion());
            tvEdadV.setText(String.valueOf(mPersonaV.getEdad()));
            //  tvNumDocV.setText(mPersonaV.getNumeroDocumento());
          // tvFechaCV.setText(mPersonaV.getFecha());
         //  tvTipoDocV.setText(mPersonaV.getTipoDocumento());
            tvCaracV.setText(String.valueOf(mPersonaV.getCarac()));
        }

    }



    private final View.OnClickListener btnVolverOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(DatosPersonaActivity.this,ListaPersonaActivity.class);
            startActivity(intent);
            finish();
        }
    };

}
