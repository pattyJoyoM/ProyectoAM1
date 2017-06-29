package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by PATTY on 21/06/2017.
 */

public class EditarPersonaActivity extends Fragment {

    private Button btnEditarE,btnEliminarE;
    private PersonaEntity mPersonaE;
    private EditText tvFechaCE;
    private EditText tvNombreE, tvApellidoE,tvDireccionE,tvNumDocE,tvEdadE;
    private Spinner spTipoDocE,spCaracE;
    private  String Tipo=null;
    private String carac=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_datos_persona_editar,container,false);

        tvNombreE=(EditText)view.findViewById(R.id.tvNombreE);
        tvApellidoE=(EditText)view.findViewById(R.id.tvApellidoE);
        tvDireccionE=(EditText)view.findViewById(R.id.tvDireccionE);
        tvEdadE=(EditText)view.findViewById(R.id.tvEdadE);
        tvFechaCE=(EditText) view.findViewById(R.id.tvFechaCE);
        tvNumDocE=(EditText)view.findViewById(R.id.tvNumDocE);

        spTipoDocE =(Spinner)view.findViewById(R.id.spTipoDocE);
        spCaracE = (Spinner)view. findViewById(R.id.spCaracE);
        btnEditarE=(Button)view.findViewById(R.id.btnEditarE);
        btnEliminarE=(Button)view.findViewById(R.id.btnEliminarE) ;

        btnEliminarE.setOnClickListener(btnEliminarEOnClickListener);
        btnEditarE.setOnClickListener(btnEditarEOnClickListener);


      //  mPersonaE=getIntent().getParcelableExtra("arg_persona");

        if (mPersonaE!=null) {

            tvNombreE.setText(mPersonaE.getNombre());
            tvApellidoE.setText(mPersonaE.getApellido());
            tvDireccionE.setText(mPersonaE.getDirecion());
            tvEdadE.setText(String.valueOf(mPersonaE.getEdad()));
            tvFechaCE.setText(mPersonaE.getFecha());
            tvNumDocE.setText(String.valueOf(mPersonaE.getNumeroDocumento()));

        }

        events();

        return view;
    }

    public void events()
    {
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

    private final View.OnClickListener btnEditarEOnClickListener=new View.OnClickListener() {
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
         //   setResult(RESULT_OK,intent);
           // finish();
        }
    };


    private final View.OnClickListener btnEliminarEOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

}
