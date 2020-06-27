package Data;

public class Consultas {

    private int id;
    public String[] consultasTexto = {
        "* Detalle y totales de ventas para la cadena completa y por sucursal, entre fechas",
        "* Detalle y totales de ventas para la cadena completa  y por sucursal,  por obra  social  o privados entre fechas",
        "* Detalle y totales de cobranza para la cadena completa y por sucursal, por medio de pago y entre fechas.",
        "* Detalle y totales de ventas de productos, total de la cadena y por sucursal, entre fechas, diferenciados entre farmacia y perfumería.",
        "* Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por monto.",
        "* Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por cantidad vendida. ",
        "* Ranking de clientes por compras, total de la cadena y por sucursal, entre fechas, por monto. ",
        "* Ranking de clientes por compras, total de la cadena y por sucursal, entre fechas, por cantidad vendida. "
    };

	public Consultas(int nro) {
        this.id = nro - 1;
        System.out.println("\n" + nro + ". Consulta " + this.id + " : ");    
        System.out.println(consultasTexto[this.id - 1]);    
	}
    
    public void showResultado(){
        //Poner un SWITCH con cada consulta if this.id = 0 (Muestra la primer consulta)  
        switch(this.id){
            default:
                System.out.println("\nAca iria el preguntas/esultado de cada consulta");
            break;
        }  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}