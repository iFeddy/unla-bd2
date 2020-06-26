package Farmacia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clientes {

    @SerializedName("id")
    @Expose private String id;
    @SerializedName("nombre")
    @Expose private String nombre;
    @SerializedName("apellido")
    @Expose private String apellido;
    @SerializedName("domicilio")
    @Expose private Domicilio domicilio;
    @SerializedName("obrasocial")
    @Expose private ObraSocial obrasocial;

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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public ObraSocial getObrasocial() {
        return obrasocial;
    }

    public void setObrasocial(ObraSocial obrasocial) {
        this.obrasocial = obrasocial;
    }

}