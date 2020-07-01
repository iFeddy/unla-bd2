package Farmacia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sucursales {

@SerializedName("id")
@Expose
private String id;
@SerializedName("sucursal")
@Expose
private Integer sucursal;
@SerializedName("puntoventa")
@Expose
private Integer puntoventa;
@SerializedName("domicilio")
@Expose
private Domicilio domicilio;
@SerializedName("encargado")
@Expose
private String encargado;
@SerializedName("tipo")
@Expose
private Integer tipo;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public Integer getSucursal() {
return sucursal;
}

public void setSucursal(Integer sucursal) {
this.sucursal = sucursal;
}

public Integer getPuntoventa() {
return puntoventa;
}

public void setPuntoventa(Integer puntoventa) {
this.puntoventa = puntoventa;
}

public Domicilio getDomicilio() {
return domicilio;
}

public void setDomicilio(Domicilio domicilio) {
this.domicilio = domicilio;
}

public String getEncargado() {
return encargado;
}

public void setEncargado(String encargado) {
this.encargado = encargado;
}

public Integer getTipo() {
return tipo;
}

public void setTipo(Integer tipo) {
this.tipo = tipo;
}

}