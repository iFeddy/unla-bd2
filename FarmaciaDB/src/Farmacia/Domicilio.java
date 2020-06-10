package Farmacia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Domicilio {

    @SerializedName("id")
    @Expose private Integer id;
    @SerializedName("calle")
    @Expose private String calle;
    @SerializedName("localidad")
    @Expose private String localidad;
    @SerializedName("provincia")
    @Expose private String provincia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}