package com.example.patty.proyectoandroid_joyomendezpatricia;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by PATTY on 19/06/2017.
 */

public class PersonaEntity implements Parcelable {
    private String id;
    private String nombre;
    private String apellido;
    private String direcion;
    private int edad;
    private  String numeroDocumento;
    private String tipoDocumento;
    private String carac;
    private String fecha;

    public PersonaEntity(String id, String nombre, String apellido, String direcion, int edad, String numeroDocumento, String tipoDocumento, String carac, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direcion = direcion;
        this.edad = edad;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.carac = carac;
        this.fecha = fecha;
    }

    public PersonaEntity() {
    }

    protected PersonaEntity(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        apellido = in.readString();
        direcion = in.readString();
        edad = in.readInt();
        numeroDocumento = in.readString();
        tipoDocumento = in.readString();
        carac = in.readString();
        fecha = in.readString();
    }

    public static final Creator<PersonaEntity> CREATOR = new Creator<PersonaEntity>() {
        @Override
        public PersonaEntity createFromParcel(Parcel source) {
            return new PersonaEntity(source);
        }

        @Override
        public PersonaEntity[] newArray(int size) {
            return new PersonaEntity[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCarac() {
        return carac;
    }

    public void setCarac(String carac) {
        this.carac = carac;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.nombre);
        dest.writeString(this.apellido);
        dest.writeString(this.direcion);
        dest.writeInt(this.edad);
        dest.writeString(this.numeroDocumento);
        dest.writeString(this.tipoDocumento);
        dest.writeString(this.carac);
        dest.writeString(this.fecha);
    }


}
