package Data;

public class Consultas {

    private int id;
    
	public Consultas(int nro) {
        this.id = nro - 1;
        System.out.println("\n" + this.id + ". Consulta " + this.id + " : ");    
        System.out.println("Detalle y totales de ventas para la cadena completa y por sucursal, entre fechas");  
        System.out.println("Terminado.-");  
	}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}