package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by PATTY on 25/06/2017.
 */

public class FragmentEditarActivity extends AppCompatActivity{
    EditarPersonaActivity editarPersonaActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_editar);
        editarPersonaActivity = (EditarPersonaActivity)EditarPersonaActivity.instantiate(FragmentEditarActivity.this,EditarPersonaActivity.class.getName());
        getFragmentManager().beginTransaction().replace(R.id.flEditar,editarPersonaActivity).commit();

    }
}
