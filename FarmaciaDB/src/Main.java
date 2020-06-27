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

        Database db = new Database("bd2", "main");
        int opcion = 0;
        int subOpcion = 0;
        do{
            opcion = menu();

            if (opcion == 1) {
                System.out.println("\n1. Instalacion en MongoDB");
            } else if (isBetween(opcion, 2, 9)) {
                Consultas query = new Consultas(opcion);
                query.showResultado();
            } else {
                opcion = 0;
            }
            if(opcion != 0){
                subOpcion = subMenu();
                if(subOpcion == 2){
                    opcion = 0;
                } 
            }
        }while(opcion >= 1 && opcion <= 9);        
    }    

    public static int menu() {
        int selection;
        clearScreen();
        Scanner input = new Scanner(System.in);

        System.out.println("Trabajo Práctico Farmacia (Base de Datos 2)\n");
        System.out.println("Seleccionar una Opción:");
        System.out.println("_______________________\n");
        System.out.println("1. Instalar Datos en MongoDB");
        System.out.println("2. Consulta 1");
        System.out.println("3. Consulta 2");
        System.out.println("4. Consulta 3");
        System.out.println("5. Consulta 4");
        System.out.println("6. Consulta 5");
        System.out.println("7. Consulta 6");
        System.out.println("8. Consulta 7");
        System.out.println("9. Consulta 8");
        System.out.println("0. Salir\n");

        selection = input.nextInt();
        return selection;    
    }

    public static int subMenu() {
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