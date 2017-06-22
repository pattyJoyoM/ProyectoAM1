package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PATTY on 19/06/2017.
 */

public class UsuarioAplication extends Application {

    private List<UsuarioEntity> lstUsuario;
    private UsuarioEntity usuarioEntity;

    @Override
    public void onCreate() {
        super.onCreate();
        lstUsuario=new ArrayList<>();

        UsuarioEntity usu1=new UsuarioEntity(1,"patty","joyo");
        UsuarioEntity usu2=new UsuarioEntity(2,"isil","123");

        lstUsuario.add(usu1);
        lstUsuario.add(usu2);
    }

  /* public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }*/

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

  /*  public void addUsuario(UsuarioEntity usuarioEntity)

    {
        lstUsuario.add(usuarioEntity);
    }
*/

    /*public UsuarioEntity findUsuariobyId(int idUsu){
        UsuarioEntity usuarioEntity=null;
        for(int i = 0; i<this.lstUsuario.size(); i++){
            usuarioEntity = lstUsuario.get(i);
            if(usuarioEntity.getIdUsu()== idUsu){
                break;
            }
        }
        return usuarioEntity;
    }
*/
    public List<UsuarioEntity> allUsers()
    {return this.lstUsuario;}

    public UsuarioEntity lastUser(){
        if(this.lstUsuario.size()>0){
            return this.lstUsuario.get(this.lstUsuario.size()-1);
        }
        return null;
    }

    public UsuarioEntity validar(String usu, String password){
        int position = -1;
        UsuarioEntity usuarioEntity = null;

        for (int i = 0; i <this.lstUsuario.size() ; i++){
            UsuarioEntity u = lstUsuario.get(i);
            if(u.getUsuario().equals(usu) && u.getPassword().equals(password)){
                position = i;
                break;
            }
        }
        if(position>=0 && position<lstUsuario.size())
        {
            usuarioEntity = lstUsuario.get(position);
        }
        return usuarioEntity;
    }

    public boolean validarUsuario(String usuario){
        Boolean bool = false;
        UsuarioEntity usuarioEntity;
        for (int i = 0; i <this.lstUsuario.size() ; i++){
            usuarioEntity = lstUsuario.get(i);
            if(usuarioEntity.getUsuario().equals(usuario)){
                bool = false;
                break;
            }
            else{
                bool = true;
            }
        }
        return bool;
    }

}
