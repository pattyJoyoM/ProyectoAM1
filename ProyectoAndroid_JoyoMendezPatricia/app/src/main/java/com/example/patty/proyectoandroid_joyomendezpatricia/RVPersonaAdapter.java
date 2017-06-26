package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PATTY on 19/06/2017.
 */

public class RVPersonaAdapter  extends RecyclerView.Adapter<RVPersonaAdapter.RVPersonaAdapterViewHolder>{

    interface RVPersonaAdapterListener
    {
        void onClickButtom(PersonaEntity personaEntity);
    }
    private RVPersonaAdapterListener mRVPersonaAdapterListener;

    public void setmRVPersonaAdapterListener(RVPersonaAdapterListener rvPersonaAdapterListener) {
        this.mRVPersonaAdapterListener = rvPersonaAdapterListener;
    }

    private List<PersonaEntity> mLstPersona=new ArrayList<>();


       public  void addAll(List<PersonaEntity>lstPersona)
       {
           mLstPersona.clear();
           mLstPersona.addAll(lstPersona);
           notifyDataSetChanged();
       }

       public void add(PersonaEntity personaEntity){
           for (int i=0; i<mLstPersona.size();i++)
               if (mLstPersona.get(i).getId().equals(personaEntity.getId()))
               {
                update(personaEntity,i);
                   return;
               }
               mLstPersona.add(personaEntity);
           notifyItemInserted(mLstPersona.size()-1);

       }

    private void update(PersonaEntity personaNew,int position){
           PersonaEntity personaEntity=mLstPersona.get(position);
           personaEntity.setNombre(personaNew.getNombre());
           personaEntity.setApellido(personaNew.getApellido());
           personaEntity.setCarac(personaNew.getCarac());
           personaEntity.setFecha(personaNew.getFecha());
           personaEntity.setDirecion(personaNew.getDirecion());
           personaEntity.setEdad(personaNew.getEdad());
           personaEntity.setNumeroDocumento(personaNew.getNumeroDocumento());
           personaEntity.setTipoDocumento(personaNew.getTipoDocumento());

       }

    public void removePersonaById(String id)
    {
        int position=-1;
        PersonaEntity persona;
        for (int i = 0; i <this.mLstPersona.size() ; i++)
        {
            persona= mLstPersona.get(i);
            if(persona.getId()==id)
            {
                position=i;
                break;
            }
        }
        if(position>=0 && position<mLstPersona.size())
        {
            this.mLstPersona.remove(position);
        }
    }
   private void addStart(PersonaEntity personaEntity){
       mLstPersona.add(0,personaEntity);
       notifyItemChanged(0);
   }
   @Override
   public RVPersonaAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_persona_detalle,parent,false);
       RVPersonaAdapterViewHolder rvPersonaAdapterViewHolder=new RVPersonaAdapterViewHolder(view);
       return rvPersonaAdapterViewHolder;
   }

    @Override
    public void onBindViewHolder(RVPersonaAdapterViewHolder holder, int position) {
        PersonaEntity personaEntity=mLstPersona.get(position);

        holder.itemView.setTag(personaEntity);

        //  holder.itemView.setOnClickListener(itemViewOnClickListener);

        holder.btnEditar.setTag(personaEntity);

        holder.btnEditar.setOnClickListener(btnEditarOnClickListener);

        holder.tvNombreCompleto.setText(personaEntity.getNombre()+" "+personaEntity.getApellido());
        holder.tvDireccion.setText(personaEntity.getDirecion());
        holder.tvEdad.setText(String.valueOf(personaEntity.getEdad()));
        holder.tvCarac.setText(personaEntity.getCarac());
    }
    @Override
    public int getItemCount() {
        return mLstPersona.size();
    }


    public class RVPersonaAdapterViewHolder extends RecyclerView.ViewHolder {
       private TextView tvNombreCompleto,tvDireccion,tvEdad,tvCarac;

        private Button btnEditar;


        public RVPersonaAdapterViewHolder(View itemView) {
            super(itemView);
            tvNombreCompleto=(TextView)itemView.findViewById(R.id.tvNombreCompleto);
            tvDireccion=(TextView)itemView.findViewById(R.id.tvDireccion);
            tvEdad=(TextView)itemView.findViewById(R.id.tvEdad);
            tvCarac=(TextView)itemView.findViewById(R.id.tvCarac);

            btnEditar=(Button)itemView.findViewById(R.id.btnEditar);

        }
    }
    private final View.OnClickListener btnEditarOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (mRVPersonaAdapterListener != null)
                mRVPersonaAdapterListener.onClickButtom((PersonaEntity) view.getTag());

        }
    };





}
