package Farmacia;

public class Domicilio {
    String calle;
    int numero; 
    String localidad;
    String provincia; 
    
    public Domicilio(String dcalle, int dnumero, String dlocalidad, String dprovincia) {
        calle = dcalle;
        numero = dnumero;
        localidad = dlocalidad;
        provincia = dprovincia;
    }
}