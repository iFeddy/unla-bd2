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

    public void showResultado(String dbName) {
        //Poner un SWITCH con cada consulta if this.id = 0 (Muestra la primer consulta)
        Database db = new Database(dbName);
        switch (this.id - 1) {
            case 0:
                db.doConsultas(0);
                break;
            case 1:
                db.doConsultas(1);
                break;
            case 2:
                db.doConsultas(2);
                break;
            case 3:
                db.doConsultas(3);
                break;
            case 4:
                db.doConsultas(4);
                break;
            case 5:
                db.doConsultas(5);
                break;
            case 6:
                db.doConsultas(6);
                break;
            case 7:
                db.doConsultas(7);
                break;
            default:
                System.out.println("\nError Consulta no Encontrada");
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