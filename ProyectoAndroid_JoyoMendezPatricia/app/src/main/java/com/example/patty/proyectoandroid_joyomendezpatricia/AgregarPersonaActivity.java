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
    /*
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_datos_persona_agregar);

            tvNombreA=(EditText)findViewById(R.id.tvNombreA);
            tvApellidoA=(EditText)findViewById(R.id.tvApellidoA);
            tvDireccionA=(EditText)findViewById(R.id.tvDireccionA);
            tvNumDocA=(EditText)findViewById(R.id.tvNumDocA);
            tvEdadA=(EditText)findViewById(R.id.tvEdadA);


            tvFechaCA=(TextView) findViewById(R.id.tvFechaCA);
            tvFechaCA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog(100);
                }
            });


            spTipoDocA =(Spinner)findViewById(R.id.spTipoDocA);
            spCarac = (Spinner) findViewById(R.id.spCarac);
            btnAceptarA=(Button)findViewById(R.id.btnAceptar);

            btnAceptarA.setOnClickListener(btnAceptarAOnClickListener);


            mPersonaA=getIntent().getParcelableExtra("arg_persona");

            if (mPersonaA!=null) {
                tvNumDocA.setText(String.valueOf(mPersonaA.getNumeroDocumento()));
                tvNombreA.setText(mPersonaA.getNombre());
                tvApellidoA.setText(mPersonaA.getApellido());
                tvDireccionA.setText(mPersonaA.getDirecion());
                tvEdadA.setText(String.valueOf(mPersonaA.getEdad()));
                tvFechaCA.setText(mPersonaA.getFecha());
            }

            events();


    }
    */
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
    /*@Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        switch (id) {
            case 100:
                final Calendar c=Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);

                return new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        String s= dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
                        Log.v("CONSOLE", "s "+s);
                        tvFechaCA.setText(s);
                        tvFechaCA.setTag(1);


                    }
                }, year, month, day);

            default:
                break;
        }
        return null;
    }*/
/*

    public final View.OnClickListener btnAceptarAOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mPersonaA==null)
            {mPersonaA=new PersonaEntity();

                mPersonaA.setId(java.util.UUID.randomUUID().toString());
            }

            mPersonaA.setNombre(tvNombreA.getText().toString());
            mPersonaA.setApellido(tvApellidoA.getText().toString());
            mPersonaA.setEdad(Integer.parseInt(tvEdadA.getText().toString()));
            mPersonaA.setDirecion(tvDireccionA.getText().toString());
            mPersonaA.setCarac(spCarac.getSelectedItem().toString());
            mPersonaA.setTipoDocumento(spTipoDocA.getSelectedItem().toString());
            mPersonaA.setNumeroDocumento(tvNumDocA.getText().toString());
            mPersonaA.setFecha(tvFechaCA.getText().toString());
            Intent intent=new Intent();
            intent.putExtra("arg_persona",mPersonaA);
            setResult(RESULT_OK,intent);
            finish();
        }
    };*/

}
