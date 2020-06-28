import java.util.Scanner;

import Data.Database;
import Data.Consultas;

public class Main{
    /**
     * App simple que conecta con MongoDB
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        int opcion = 0;
        int subOpcion = 0;
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("Trabajo Práctico Farmacia (Base de Datos 2)");
        System.out.println("___________________________________________\n");
        System.out.print("Ingresar Nombre de Base de Datos: ");
        String dbName = input.nextLine();

        do{
            opcion = menu(dbName);

            if (opcion == 1) {
                Database db = new Database(dbName);
                db.install();                
            } else if (isBetween(opcion, 2, 9)) {
                Consultas query = new Consultas(opcion);
                query.showResultado();
            } else {
                opcion = 0;
            }
            if(opcion != 0){
                subOpcion = subMenu(dbName);
                if(subOpcion == 2){
                    opcion = 0;
                } 
            }
        }while(opcion >= 1 && opcion <= 9);        
    }

    public static int menu(String dbName) {
        int selection;
        clearScreen();
        Scanner input = new Scanner(System.in);

        System.out.println("Trabajo Práctico Farmacia (Base de Datos 2)\n");
        System.out.println("Seleccionar una Opción:");
        System.out.println("_______________________");
        System.out.println("\nBase de Datos Seleccionada: [" + dbName + "]\n");
        System.out.println("1. Carga de Datos en " + dbName + "");
        System.out.println("2. Realizar Consulta Punto 1");
        System.out.println("3. Realizar Consulta Punto 2");
        System.out.println("4. Realizar Consulta Punto 3");
        System.out.println("5. Realizar Consulta Punto 4");
        System.out.println("6. Realizar Consulta Punto 5");
        System.out.println("7. Realizar Consulta Punto 6");
        System.out.println("8. Realizar Consulta Punto 7");
        System.out.println("9. Realizar Consulta Punto 8");
        System.out.println("0. Salir\n");

        selection = input.nextInt();

        return selection;    
    }

    public static int subMenu(String dbName) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("\nSeleccionar una Opción:");
        System.out.println("1. Menu      2. Salir");

        selection = input.nextInt();

        return selection;    
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
      }
}