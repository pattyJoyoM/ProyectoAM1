package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by PATTY on 19/06/2017.
 */

public class ListaPersonaActivity extends Fragment implements RVPersonaAdapter.RVPersonaAdapterListener{
    private RecyclerView rvListaPersona;
    private RVPersonaAdapter mRVPersonaAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_lista_persona,container,false);

        mRVPersonaAdapter=new RVPersonaAdapter();

        rvListaPersona=(RecyclerView)view.findViewById(R.id.rvListaPersona);
        rvListaPersona.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvListaPersona.setAdapter(mRVPersonaAdapter);
        return view;


    }

    public  void add(PersonaEntity personaEntity)
    {
        mRVPersonaAdapter.add(personaEntity);
    }


    @Override
    public void onClickButtom(PersonaEntity personaEntity) {
      /*  Intent intent = new Intent(getActivity(),EditarPersonaActivity.class);
        intent.putExtra("arg_persona",personaEntity);
        startActivity(intent);*/
     /*   Fragment fragment = new FragmentoInicio();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment).commit()*/

    }
/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            mRVPersonaAdapter.add((PersonaEntity) data.getParcelableExtra("arg_persona"));

    }*/
}
