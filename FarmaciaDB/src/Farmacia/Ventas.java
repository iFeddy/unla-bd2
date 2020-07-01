package Farmacia;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ventas {

@SerializedName("id")
@Expose
private String id;
@SerializedName("ticket")
@Expose
private Integer ticket;
@SerializedName("total")
@Expose
private Float total;
@SerializedName("formapago")
@Expose
private Integer formapago;
@SerializedName("vendedor")
@Expose
private String vendedor;
@SerializedName("cajero")
@Expose
private String cajero;
@SerializedName("cliente")
@Expose
private String cliente;
@SerializedName("inventario")
@Expose
private List<Inventario> inventario = null;
@SerializedName("tipoos")
@Expose
private Integer tipoos;
@SerializedName("sucursal")
@Expose
private Integer sucursal;
@SerializedName("fecha")
@Expose
private String fecha;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public Integer getTicket() {
return ticket;
}

public void setTicket(Integer ticket) {
this.ticket = ticket;
}

public Float getTotal() {
return total;
}

public void setTotal(Float total) {
this.total = total;
}

public Integer getFormapago() {
return formapago;
}

public void setFormapago(Integer formapago) {
this.formapago = formapago;
}

public String getVendedor() {
return vendedor;
}

public void setVendedor(String vendedor) {
this.vendedor = vendedor;
}

public String getCajero() {
return cajero;
}

public void setCajero(String cajero) {
this.cajero = cajero;
}

public String getCliente() {
return cliente;
}

public void setCliente(String cliente) {
this.cliente = cliente;
}

public List<Inventario> getInventario() {
return inventario;
}

public void setInventario(List<Inventario> inventario) {
this.inventario = inventario;
}

public Integer getTipoos() {
return tipoos;
}

public void setTipoos(Integer tipoos) {
this.tipoos = tipoos;
}

public Integer getSucursal() {
return sucursal;
}

public void setSucursal(Integer sucursal) {
this.sucursal = sucursal;
}

public String getFecha() {
return fecha;
}

public void setFecha(String fecha) {
this.fecha = fecha;
}

}