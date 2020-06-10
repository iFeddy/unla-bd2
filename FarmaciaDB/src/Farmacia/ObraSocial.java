package Farmacia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObraSocial {

    @SerializedName("nombre")
    @Expose private String nombre;
    @SerializedName("numafiliado")
    @Expose private Integer numafiliado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumafiliado() {
        return numafiliado;
    }

    public void setNumafiliado(Integer numafiliado) {
        this.numafiliado = numafiliado;
    }

}