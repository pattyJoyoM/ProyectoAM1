package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by PATTY on 19/06/2017.
 */

public class PrincipalActivity extends AppCompatActivity implements AgregarPersonaActivity.Callback {

    ListaPersonaActivity listaPersonaActivity;
    AgregarPersonaActivity agregarPersonaActivity;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        listaPersonaActivity=(ListaPersonaActivity)ListaPersonaActivity.instantiate(PrincipalActivity.this,ListaPersonaActivity.class.getName());
        getFragmentManager().beginTransaction().replace(R.id.flLista,listaPersonaActivity).commit();

        agregarPersonaActivity=(AgregarPersonaActivity)AgregarPersonaActivity.instantiate(PrincipalActivity.this,AgregarPersonaActivity.class.getName());
        getFragmentManager().beginTransaction().replace(R.id.flDatos,agregarPersonaActivity).commit();

        agregarPersonaActivity.setCallback(PrincipalActivity.this);
    }

    @Override
    public void onListaFragmentClick(PersonaEntity personaEntity) {
        listaPersonaActivity.add(personaEntity);
    }

}
