package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by PATTY on 19/06/2017.
 */

public class AgregarPersonaActivity extends Fragment {

    private EditText tvFechaCA;
    private EditText tvNombreA, tvApellidoA, tvDireccionA, tvNumDocA, tvEdadA;
    private Spinner spTipoDocA, spCarac;
    private String Tipo = null;
    private String carac = null;


    private Button btnAceptarA;
    private PersonaEntity mPersonaA;


    public final View.OnClickListener btnAceptarAOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validar()) {
                if (mCallback != null) {
                    PersonaEntity personaEntity = new PersonaEntity();
                    personaEntity.setId(java.util.UUID.randomUUID().toString());
                    personaEntity.setNombre(tvNombreA.getText().toString());
                    personaEntity.setApellido(tvApellidoA.getText().toString());
                    personaEntity.setEdad(Integer.valueOf(tvEdadA.getText().toString()));
                    personaEntity.setDirecion(tvDireccionA.getText().toString());
                    personaEntity.setNumeroDocumento(tvNumDocA.getText().toString());
                    personaEntity.setFecha(tvFechaCA.getText().toString());
                    personaEntity.setTipoDocumento(spTipoDocA.getSelectedItem().toString());
                    personaEntity.setCarac(spCarac.getSelectedItem().toString());


                    mCallback.onListaFragmentClick(personaEntity);
                }

            }
        }
    };

    interface Callback {
        void onListaFragmentClick(PersonaEntity personaEntity);
    }

    private Callback mCallback;

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    public boolean validar()
    {
        if (tvNombreA.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (tvApellidoA.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese un apellido", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (tvFechaCA.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese un telefono", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (tvNumDocA.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese una direccion", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (tvEdadA.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese una edad", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (tvDireccionA.getText().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese una edad", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (spTipoDocA.getSelectedItem().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese una edad", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (spCarac.getSelectedItem().toString().trim().isEmpty()) {
            Toast.makeText(this.getActivity(), "Ingrese una edad", Toast.LENGTH_SHORT).show();
            return false;
        }
        return  true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_datos_persona_agregar,container,false);


        tvNombreA=(EditText)view.findViewById(R.id.tvNombreA);
        tvApellidoA=(EditText)view.findViewById(R.id.tvApellidoA);
        tvDireccionA=(EditText)view.findViewById(R.id.tvDireccionA);
        tvNumDocA=(EditText)view.findViewById(R.id.tvNumDocA);
        tvEdadA=(EditText)view.findViewById(R.id.tvEdadA);


        tvFechaCA=(EditText) view.findViewById(R.id.tvFechaCA);
        tvFechaCA.setOnClickListener(tvFechaCAOnClickListener);



        spTipoDocA =(Spinner)view.findViewById(R.id.spTipoDocA);
        spCarac = (Spinner)view. findViewById(R.id.spCarac);
        btnAceptarA=(Button)view.findViewById(R.id.btnAceptar);

        btnAceptarA.setOnClickListener(btnAceptarAOnClickListener);


        events();
        return view;
    }

    public final View.OnClickListener tvFechaCAOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // showDialog(100);
        }
    };

private  void  events()
{
    spCarac.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
            Log.v("CONSOLE","spCarac"+adapterView.getAdapter().getItem(i));
            Tipo=adapterView.getAdapter().getItem(i).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

    spTipoDocA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
