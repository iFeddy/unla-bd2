package Farmacia;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ventas {
    @SerializedName("id")
    @Expose private String id;
    @SerializedName("ticket")
    @Expose private Integer ticket;
    @SerializedName("total")
    @Expose private String total;
    @SerializedName("formapago")
    @Expose private Integer formapago;
    @SerializedName("vendedor")
    @Expose private String vendedor;
    @SerializedName("cajero")
    @Expose private String cajero;
    @SerializedName("inventario")
    @Expose private List<Inventario> inventario = null;

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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
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

    public List<Inventario> getInventario() {
        return inventario;
    }

    public void setInventario(List<Inventario> inventario) {
        this.inventario = inventario;
    }
}