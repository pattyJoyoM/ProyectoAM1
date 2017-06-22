package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by PATTY on 19/06/2017.
 */

public class UsuarioEntity implements Parcelable {

    private int idUsu;
    private String usuario;
    private String password;

    public UsuarioEntity() {
    }

    public UsuarioEntity(int idUsu, String usuario, String password) {
        this.idUsu = idUsu;
        this.usuario = usuario;
        this.password = password;
    }
    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    protected UsuarioEntity(Parcel in) {
        idUsu = in.readInt();
        usuario = in.readString();
        password = in.readString();
    }

    public static final Creator<UsuarioEntity> CREATOR = new Creator<UsuarioEntity>() {
        @Override
        public UsuarioEntity createFromParcel(Parcel source) {
            return new UsuarioEntity(source);
        }

        @Override
        public UsuarioEntity[] newArray(int size) {
            return new UsuarioEntity[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idUsu);
        dest.writeString(this.usuario);
        dest.writeString(this.password);
    }
}
