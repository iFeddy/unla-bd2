package Farmacia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Productos {

    @SerializedName("id")
    @Expose private String id;
    @SerializedName("tipo")
    @Expose private Integer tipo;
    @SerializedName("desc")
    @Expose private String desc;
    @SerializedName("laboratorio")
    @Expose private String laboratorio;
    @SerializedName("codnum")
    @Expose private Integer codnum;
    @SerializedName("precio")
    @Expose private String precio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getCodnum() {
        return codnum;
    }

    public void setCodnum(Integer codnum) {
        this.codnum = codnum;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}