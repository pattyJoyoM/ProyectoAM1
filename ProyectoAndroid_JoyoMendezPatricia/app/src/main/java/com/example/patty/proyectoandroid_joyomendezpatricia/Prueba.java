package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by PATTY on 29/06/2017.
 */

public class Prueba extends AppCompatActivity {
    private EditText tvFechaCE;
    private EditText tvNombreE, tvApellidoE,tvDireccionE,tvNumDocE,tvEdadE;
    private Spinner spTipoDocE,spCaracE;
    private  String Tipo=null;
    private String carac=null;


    private Button btnEditarE,btnEliminarE;
    private PersonaEntity mPersonaE;

    // private RVPersonaAdapter application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_persona_editar);

        tvNombreE=(EditText)findViewById(R.id.tvNombreE);
        tvApellidoE=(EditText)findViewById(R.id.tvApellidoE);
        tvDireccionE=(EditText)findViewById(R.id.tvDireccionE);
        tvEdadE=(EditText)findViewById(R.id.tvEdadE);
        tvFechaCE=(EditText) findViewById(R.id.tvFechaCE);
        tvNumDocE=(EditText)findViewById(R.id.tvNumDocE);

        tvFechaCE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showDialog(100);
            }
        });


        spTipoDocE =(Spinner)findViewById(R.id.spTipoDocE);
        spCaracE = (Spinner) findViewById(R.id.spCaracE);
        btnEditarE=(Button)findViewById(R.id.btnEditarE);

        btnEditarE.setOnClickListener(btnEditarEOnClickListener);


        mPersonaE=getIntent().getParcelableExtra("arg_persona");

        if (mPersonaE!=null) {

            tvNombreE.setText(mPersonaE.getNombre());
            tvApellidoE.setText(mPersonaE.getApellido());
            tvDireccionE.setText(mPersonaE.getDirecion());
            tvEdadE.setText(String.valueOf(mPersonaE.getEdad()));
            tvFechaCE.setText(mPersonaE.getFecha());
            tvNumDocE.setText(String.valueOf(mPersonaE.getNumeroDocumento()));

        }

        events();




    }

    public final View.OnClickListener btnEditarEOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mPersonaE==null)
            {mPersonaE=new PersonaEntity();

                mPersonaE.setId(java.util.UUID.randomUUID().toString());
            }

            mPersonaE.setNombre(tvNombreE.getText().toString());
            mPersonaE.setApellido(tvApellidoE.getText().toString());
            mPersonaE.setEdad(Integer.parseInt(tvEdadE.getText().toString()));
            mPersonaE.setDirecion(tvDireccionE.getText().toString());
            mPersonaE.setCarac(spCaracE.getSelectedItem().toString());
            Intent intent=new Intent();
            intent.putExtra("arg_persona",mPersonaE);
            setResult(RESULT_OK,intent);
            finish();


        }
    };
    public  void events(){
        spCaracE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                Log.v("CONSOLE","spCarac"+adapterView.getAdapter().getItem(i));
                Tipo=adapterView.getAdapter().getItem(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spTipoDocE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                Log.v("CONSOLE","spTipoDocA"+adapterView.getAdapter().getItem(i));
                Tipo=adapterView.getAdapter().getItem(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }




}
