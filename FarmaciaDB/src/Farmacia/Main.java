package Farmacia;

import Data.Database;

public class Main{
    /**
     * App simple que conecta con MongoDB
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hola desde Farmacia");
        Database db = new Database("bd2", "main");
    }    
}