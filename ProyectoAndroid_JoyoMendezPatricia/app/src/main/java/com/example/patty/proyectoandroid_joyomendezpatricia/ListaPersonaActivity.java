package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by PATTY on 19/06/2017.
 */

public class ListaPersonaActivity extends AppCompatActivity implements RVPersonaAdapter.RVPersonaAdapterListener {
    private RecyclerView rvListaPersona;
    private RVPersonaAdapter mRVPersonaAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_persona);

        findViewById(R.id.btnAgregarP).setOnClickListener(btnAgregarPOnClickListener);
        rvListaPersona=(RecyclerView)findViewById(R.id.rvListaPersona);
        rvListaPersona.setLayoutManager(new LinearLayoutManager(ListaPersonaActivity.this));

        mRVPersonaAdapter=new RVPersonaAdapter();

        mRVPersonaAdapter.setRVPersonaAdapterListener(ListaPersonaActivity.this);
        rvListaPersona.setAdapter(mRVPersonaAdapter);

    }
    private final View.OnClickListener btnAgregarPOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        startActivityForResult(new Intent(ListaPersonaActivity.this,
                AgregarPersonaActivity.class),1);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK)
        {
            mRVPersonaAdapter.add((PersonaEntity)
            data.getParcelableExtra("arg_persona"));
        }
    }

    @Override
    public void onClickItem(PersonaEntity personaEntity) {

        Intent intent=new Intent(ListaPersonaActivity.this,DatosPersonaActivity.class);
        intent.putExtra("arg_persona",personaEntity);
        startActivityForResult(intent,1);
    }

    @Override
    public void onClickButton(PersonaEntity personaEntity) {
        Intent intent=new Intent(ListaPersonaActivity.this,EditarPersonaActivity.class);
        intent.putExtra("arg_persona",personaEntity);
        startActivityForResult(intent,2);
    }
}
