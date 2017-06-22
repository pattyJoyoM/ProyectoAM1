package com.example.patty.proyectoandroid_joyomendezpatricia;

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
    interface RVPersonaAdapterListener{
        void  onClickItem(PersonaEntity personaEntity);
        void  onClickButton(PersonaEntity personaEntity);

    }

    private List<PersonaEntity> mLstPersona=new ArrayList<>();
    private RVPersonaAdapterListener mRVPersonaAdapterListener;

    public void setRVPersonaAdapterListener(RVPersonaAdapterListener rvPersonaAdapterListener) {
      this.mRVPersonaAdapterListener=rvPersonaAdapterListener;
       }

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

       private void addStart(PersonaEntity personaEntity){
           mLstPersona.add(0,personaEntity);
           notifyItemChanged(0);
       }

    @Override
    public RVPersonaAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVPersonaAdapterViewHolder(LayoutInflater.from(parent.
                getContext()).inflate(R.layout.activity_lista_persona_detalle,parent,false));
    }

    @Override
    public void onBindViewHolder(RVPersonaAdapter.RVPersonaAdapterViewHolder holder, int position) {
        PersonaEntity personaEntity=mLstPersona.get(position);

        holder.itemView.setTag(personaEntity);

        holder.itemView.setOnClickListener(itemViewOnClickListener);

        holder.btnEditar.setTag(personaEntity);

        holder.btnEditar.setOnClickListener(btnEditarOnClickListener);

        holder.tvNombreCompleto.setText(personaEntity.getNombre()+" "+personaEntity.getApellido());
        holder.tvDireccion.setText(personaEntity.getDirecion());
        holder.tvEdad.setText(String.valueOf(personaEntity.getEdad()));
        holder.tvCarac.setText(personaEntity.getCarac());
    }

    private final View.OnClickListener itemViewOnClickListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mRVPersonaAdapterListener!=null)
                mRVPersonaAdapterListener.onClickItem((PersonaEntity)v.getTag());
        }
    };

    private final View.OnClickListener btnEditarOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mRVPersonaAdapterListener!=null)
                mRVPersonaAdapterListener.onClickButton((PersonaEntity)v.getTag());
        }
    };

    @Override
    public int getItemCount() {
        return mLstPersona.size();
    }

    public class RVPersonaAdapterViewHolder extends RecyclerView.ViewHolder {
       private TextView tvNombreCompleto,tvDireccion,tvEdad,tvCarac,tvF,tvtd,tvnd;

        private Button btnEditar;


        public RVPersonaAdapterViewHolder(View itemView) {
            super(itemView);
            tvNombreCompleto=(TextView)itemView.findViewById(R.id.tvNombreCompleto);
            tvDireccion=(TextView)itemView.findViewById(R.id.tvDireccion);
            tvEdad=(TextView)itemView.findViewById(R.id.tvEdad);
            tvCarac=(TextView)itemView.findViewById(R.id.tvCarac);

           /* tvF=(TextView)itemView.findViewById(R.id.tvF);
            tvtd=(TextView)itemView.findViewById(R.id.tvtd);
            tvnd=(TextView)itemView.findViewById(R.id.tvnd);*/

            btnEditar=(Button)itemView.findViewById(R.id.btnEditar);

        }
    }



}
