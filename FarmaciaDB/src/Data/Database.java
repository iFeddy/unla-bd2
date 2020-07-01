package Data;

import com.mongodb.client.MongoClients;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Farmacia.*;

public class Database {
    public int installs = 0;
    public String database;

    private Scanner input;
    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    private String[] formaPagos= {
        "-",
        "Efectivo",
        "Tarjeta de Credito",
        "MercadoPago"
    };

    private String[] tipoVenta= {
        "Obra Social",
        "Privado"
    };

    private String[] tipoSucursal= {
        "Farmacia",
        "Perfumeria"
    };
    
    public Database(String dbName) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        this.database = dbName;
    }

    public void install() {
        System.out.println("\n1. Instalacion en MongoDB");

        Boolean installed = false;

        installed = installClientes(this.database);
        installed = installEmpleados(this.database);
        installed = installProductos(this.database);
        installed = installSucursales(this.database);
        installed = installVentas(this.database);

        if (installed) {
            System.out.print("\nInstaladas " + this.installs + " Colecciones en MongoDB [Base de Datos: " + this.database + "]\n");
        } else {
            System.out.print("\nYa existen las Colecciones en MongoDB [Base de Datos: " + this.database + "]\n");
        }
    }

    public boolean installClientes(String dbName) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase mongoDB = mongoClient.getDatabase(dbName);
        Boolean collectionExists = mongoClient.getDatabase(this.database).listCollectionNames().into(new ArrayList < String > ()).contains("Clientes");
        if (!(collectionExists)) {
            try {
                File file = new File("./_json/Clientes.json");
                MongoCollection < Document > mongoCollection = mongoDB.getCollection("Clientes");

                Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                List < Clientes > clientes = new Gson().fromJson(reader, new TypeToken < List < Clientes >> () {}.getType());

                List < Document > documents = new ArrayList < Document > ();
                int count = 0;
                for (Clientes c: clientes) {
                    count++;
                    Document doc = Document.parse(new Gson().toJson(c));
                    documents.add(doc);
                }
                System.out.println("\nInsertados " + count + " Clientes Nuevos");
                mongoCollection.insertMany(documents);
                reader.close();
                this.installs++;
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean installEmpleados(String dbName) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase mongoDB = mongoClient.getDatabase(dbName);
        Boolean collectionExists = mongoClient.getDatabase(this.database).listCollectionNames().into(new ArrayList < String > ()).contains("Empleados");
        if (!(collectionExists)) {
            try {
                File file = new File("./_json/Empleados.json");
                MongoCollection < Document > mongoCollection = mongoDB.getCollection("Empleados");

                Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                List < Empleados > empleados = new Gson().fromJson(reader, new TypeToken < List < Empleados >> () {}.getType());


                List < Document > documents = new ArrayList < Document > ();
                int count = 0;
                for (Empleados e: empleados) {
                    count++;
                    Document doc = Document.parse(new Gson().toJson(e));
                    documents.add(doc);
                }
                System.out.println("\nInsertados " + count + " Empleados Nuevos");
                mongoCollection.insertMany(documents);
                reader.close();
                this.installs++;
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean installProductos(String dbName) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase mongoDB = mongoClient.getDatabase(dbName);
        Boolean collectionExists = mongoClient.getDatabase(this.database).listCollectionNames().into(new ArrayList < String > ()).contains("Productos");
        if (!(collectionExists)) {
            try {
                File file = new File("./_json/Productos.json");
                MongoCollection < Document > mongoCollection = mongoDB.getCollection("Productos");

                Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                List < Productos > productos = new Gson().fromJson(reader, new TypeToken < List < Productos >> () {}.getType());


                List < Document > documents = new ArrayList < Document > ();
                int count = 0;
                for (Productos p: productos) {
                    count++;
                    Document doc = Document.parse(new Gson().toJson(p));
                    documents.add(doc);
                }
                System.out.println("\nInsertados " + count + " Productos Nuevos");
                mongoCollection.insertMany(documents);
                reader.close();
                this.installs++;
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean installSucursales(String dbName) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase mongoDB = mongoClient.getDatabase(dbName);

        Boolean collectionExists = mongoClient.getDatabase(this.database).listCollectionNames().into(new ArrayList < String > ()).contains("Sucursales");
        if (!(collectionExists)) {
            try {
                File file = new File("./_json/Sucursales.json");
                MongoCollection < Document > mongoCollection = mongoDB.getCollection("Sucursales");

                Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                List < Sucursales > sucursales = new Gson().fromJson(reader, new TypeToken < List < Sucursales >> () {}.getType());


                List < Document > documents = new ArrayList < Document > ();
                int count = 0;
                for (Sucursales s: sucursales) {
                    count++;
                    Document doc = Document.parse(new Gson().toJson(s));
                    documents.add(doc);
                }
                System.out.println("\nInsertadas " + count + " Sucursales Nuevos");
                mongoCollection.insertMany(documents);
                reader.close();
                this.installs++;
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean installVentas(String dbName) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase mongoDB = mongoClient.getDatabase(dbName);

        Boolean collectionExists = mongoClient.getDatabase(this.database).listCollectionNames().into(new ArrayList < String > ()).contains("Ventas");
        if (!(collectionExists)) {
            try {
                File file = new File("./_json/Ventas.json");
                MongoCollection < Document > mongoCollection = mongoDB.getCollection("Ventas");

                Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
                List < Ventas > ventas = new Gson().fromJson(reader, new TypeToken < List < Ventas >> () {}.getType());

                List < Document > documents = new ArrayList < Document > ();
                int count = 0;
                for (Ventas v: ventas) {
                    count++;
                    Document doc = Document.parse(new Gson().toJson(v));
                    documents.add(doc);
                }
                System.out.println("\nInsertadas " + count + " Ventas Nuevos");
                mongoCollection.insertMany(documents);
                reader.close();
                this.installs++;
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    //Ver si devuelve void o List
    public void doConsultas(int consulta) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase mongoDB = mongoClient.getDatabase(this.database);
        this.input = new Scanner(System.in);
        if (consulta == 0) {

            System.out.print("\nFecha Inicial (Min: 2015-01-01): ");
            String inputFechaInicial = input.nextLine();
            System.out.print("Fecha Final (Max: 2020-06-29): ");
            String inputFechaFinal = input.nextLine();

            Date fechaInicial = null;
            try {

                fechaInicial = dateFormat.parse(inputFechaInicial);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date fechaFinal = null;
            try {

                fechaFinal = dateFormat.parse(inputFechaFinal);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //Buscar en la DB las distintas sucursales
            MongoCollection < Document > mongoCollection = mongoDB.getCollection("Ventas");
            MongoCursor < Integer > mongoCursor = mongoCollection.distinct("sucursal", Integer.class).iterator();

            while (mongoCursor.hasNext()) {
                int sucursalNro = mongoCursor.next();
                float total = 0;
                Bson bsonFilter = Filters.eq("sucursal", sucursalNro);
                MongoCursor < Document > mongoCursorSucursal = mongoCollection.find(bsonFilter).iterator();
                //Busca en la DB cada sucursal y suma totales
                System.out.println("Sucursal " + sucursalNro);
                System.out.println("--------------------------------------------------");
                System.out.println("Ticket Nro | Total | Forma de Pago | Cajero | Fecha");
                while (mongoCursorSucursal.hasNext()) {                    
                    Ventas ventas = new Gson().fromJson(mongoCursorSucursal.next().toJson(), new TypeToken < Ventas > () {}.getType());
                    Date fechaVenta = null;
                    try{
                        fechaVenta = dateFormat.parse(ventas.getFecha());
                    }catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (!fechaInicial.after(fechaVenta) && !fechaFinal.before(fechaVenta)) {
                        System.out.println(ventas.getTicket() + "|"+ ventas.getTotal() +"|"+ formaPagos[ventas.getFormapago()] +"|"+ ventas.getCajero() + "|" + ventas.getFecha());
                        total = total + ventas.getTotal();
                    }                    
                }
                System.out.println("Total: $" + decimalFormat.format(total) + "\n");
            }           
        }
    
        if (consulta == 1) {

            System.out.print("\nFecha Inicial (Min: 2015-01-01): ");
            String inputFechaInicial = input.nextLine();
            System.out.print("Fecha Final (Max: 2020-06-29): ");
            String inputFechaFinal = input.nextLine();

            Date fechaInicial = null;
            try {

                fechaInicial = dateFormat.parse(inputFechaInicial);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date fechaFinal = null;
            try {

                fechaFinal = dateFormat.parse(inputFechaFinal);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            MongoCollection < Document > mongoCollection = mongoDB.getCollection("Ventas");
            MongoCursor < Integer > mongoCursor = mongoCollection.distinct("sucursal", Integer.class).iterator();

            System.out.println("\n\nDetalles Cadena Completa");
            System.out.println("--------------------------------------------------\n");
            System.out.println("Sucursal | Ventas | Total");
            System.out.println("-------------------------");
            float total = 0;
            float obraSocial = 0;
            float privado = 0;

            while (mongoCursor.hasNext()) {
                int sucursalNro = mongoCursor.next();
                int cantidadVentas = 0;
                float subTotal = 0;

                Bson bsonFilter = Filters.eq("sucursal", sucursalNro);
                MongoCursor < Document > mongoCursorSucursal = mongoCollection.find(bsonFilter).iterator();
                //Busca en la DB cada sucursal y suma totales               
                
                while (mongoCursorSucursal.hasNext()) {                    
                    Ventas ventas = new Gson().fromJson(mongoCursorSucursal.next().toJson(), new TypeToken < Ventas > () {}.getType());
                    Date fechaVenta = null;
                    try{
                        fechaVenta = dateFormat.parse(ventas.getFecha());
                    }catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (!fechaInicial.after(fechaVenta) && !fechaFinal.before(fechaVenta)) {
                        subTotal = subTotal + ventas.getTotal();
                        cantidadVentas = cantidadVentas + 1;
                        if(ventas.getTipoos() == 0){
                            obraSocial = obraSocial + ventas.getTotal();
                        }else{
                            privado = privado + ventas.getTotal();
                        }
                    }                    
                }
                System.out.println(sucursalNro + "\t | " + cantidadVentas + "\t | $" + decimalFormat.format(subTotal));
                total = total + subTotal;                
            }  
            System.out.println("\nTotal Ventas por Obras Sociales: $" + decimalFormat.format(obraSocial) + "\n");
            System.out.println("\nTotal Ventas por Privados: $" + decimalFormat.format(privado) + "\n");
            System.out.println("\nTotal Ventas de Cadena: $" + decimalFormat.format(total) + "\n");    
        }

        if (consulta == 2)  {

            System.out.print("\nFecha Inicial (Min: 2015-01-01): ");
            String inputFechaInicial = input.nextLine();
            System.out.print("Fecha Final (Max: 2020-06-29): ");
            String inputFechaFinal = input.nextLine();

            Date fechaInicial = null;
            try {

                fechaInicial = dateFormat.parse(inputFechaInicial);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date fechaFinal = null;
            try {

                fechaFinal = dateFormat.parse(inputFechaFinal);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            MongoCollection < Document > mongoCollection = mongoDB.getCollection("Ventas");
            MongoCursor < Integer > mongoCursor = mongoCollection.distinct("sucursal", Integer.class).iterator();

            System.out.println("\n\nDetalles Cadena Completa");
            System.out.println("--------------------------------------------------\n");
            System.out.println("Sucursal | Ventas | Total");
            System.out.println("-------------------------");
            float total = 0;

            float tarjeta = 0;
            float efectivo = 0;
            float mercadopago = 0;

            while (mongoCursor.hasNext()) {
                int sucursalNro = mongoCursor.next();
                int cantidadVentas = 0;
                float subTotal = 0;

                Bson bsonFilter = Filters.eq("sucursal", sucursalNro);
                MongoCursor < Document > mongoCursorSucursal = mongoCollection.find(bsonFilter).iterator();
                //Busca en la DB cada sucursal y suma totales               
                
                while (mongoCursorSucursal.hasNext()) {                    
                    Ventas ventas = new Gson().fromJson(mongoCursorSucursal.next().toJson(), new TypeToken < Ventas > () {}.getType());
                    Date fechaVenta = null;
                    try{
                        fechaVenta = dateFormat.parse(ventas.getFecha());
                    }catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (!fechaInicial.after(fechaVenta) && !fechaFinal.before(fechaVenta)) {
                        subTotal = subTotal + ventas.getTotal();
                        cantidadVentas = cantidadVentas + 1;
                        if(ventas.getFormapago() == 1){
                            efectivo = efectivo + ventas.getTotal();
                        }else if(ventas.getFormapago() == 2){
                            tarjeta = tarjeta + ventas.getTotal();
                        }
                        else{
                            mercadopago = mercadopago + ventas.getTotal();
                        }
                    }                    
                }
                System.out.println(sucursalNro + "\t | " + cantidadVentas + "\t | $" + decimalFormat.format(subTotal));
                total = total + subTotal;                
            }  

            System.out.println("\nTotal Ventas en Efectivo: $" + decimalFormat.format(efectivo) + "");
            System.out.println("\nTotal Ventas con Tarjetas: $" + decimalFormat.format(tarjeta) + "");
            System.out.println("\nTotal Ventas con MercadoPago: $" + decimalFormat.format(mercadopago) + "\n"); 
            System.out.println("\nTotal Ventas Cadena: $" + decimalFormat.format(total) + "\n");    
        }       
        

        if (consulta == 3)  {

            System.out.print("\nFecha Inicial (Min: 2015-01-01): ");
            String inputFechaInicial = input.nextLine();
            System.out.print("Fecha Final (Max: 2020-06-29): ");
            String inputFechaFinal = input.nextLine();

            Date fechaInicial = null;
            try {

                fechaInicial = dateFormat.parse(inputFechaInicial);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date fechaFinal = null;
            try {

                fechaFinal = dateFormat.parse(inputFechaFinal);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            MongoCollection < Document > mongoCollection = mongoDB.getCollection("Ventas");
            MongoCollection < Document > mongoCollectionSucursales = mongoDB.getCollection("Sucursales");

            MongoCursor < Integer > mongoCursor = mongoCollection.distinct("sucursal", Integer.class).iterator();

            System.out.println("\n\nDetalles Farmacia/Perfumerias");
            System.out.println("--------------------------------------------------\n");
            System.out.println("Sucursal | Tipo | Ventas | Total");
            System.out.println("---------------------------------");
            float total = 0;

            float farmacia = 0;
            float perfumeria = 0;

            while (mongoCursor.hasNext()) {
                int sucursalNro = mongoCursor.next();
                int cantidadVentas = 0;
                float subTotal = 0;

                Bson bsonFilter = Filters.eq("sucursal", sucursalNro);
                MongoCursor < Document > mongoCursorSucursal = mongoCollection.find(bsonFilter).iterator();
                //Busca en la DB cada sucursal y suma totales               
                
                while (mongoCursorSucursal.hasNext()) {                    
                    Ventas ventas = new Gson().fromJson(mongoCursorSucursal.next().toJson(), new TypeToken < Ventas > () {}.getType());
                    Date fechaVenta = null;
                    try{
                        fechaVenta = dateFormat.parse(ventas.getFecha());
                    }catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (!fechaInicial.after(fechaVenta) && !fechaFinal.before(fechaVenta)) {
                        subTotal = subTotal + ventas.getTotal();
                        cantidadVentas = cantidadVentas + 1;                       
                    }                    
                }

                MongoCursor <Document> mongoCursorSucursales = mongoCollectionSucursales.find(bsonFilter).iterator();
                Sucursales sucursales = new Gson().fromJson(mongoCursorSucursales.next().toJson(), new TypeToken <Sucursales> () {}.getType());
                if(sucursales.getTipo() == 1){
                    perfumeria = perfumeria + subTotal;
                }else{
                    farmacia = farmacia + subTotal;
                }

                System.out.println(sucursalNro + "\t | " + tipoSucursal[sucursales.getTipo()] + " \t | " + cantidadVentas + "\t | $" + decimalFormat.format(subTotal));
                total = total + subTotal; 

            }  

            System.out.println("\nTotal Ventas en Farmacias: $" + decimalFormat.format(farmacia) + "");
            System.out.println("\nTotal Ventas en Perfumerias: $" + decimalFormat.format(perfumeria) + "");

            System.out.println("\nTotal Ventas Cadena: $" + decimalFormat.format(total) + "\n");    
        } 

        if(consulta == 4){
            System.out.print("\nFecha Inicial (Min: 2015-01-01): ");
            String inputFechaInicial = input.nextLine();
            System.out.print("Fecha Final (Max: 2020-06-29): ");
            String inputFechaFinal = input.nextLine();

            Date fechaInicial = null;
            try {

                fechaInicial = dateFormat.parse(inputFechaInicial);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date fechaFinal = null;
            try {

                fechaFinal = dateFormat.parse(inputFechaFinal);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            MongoCollection < Document > mongoCollection = mongoDB.getCollection("Ventas");
            MongoCollection < Document > mongoCollectionSucursales = mongoDB.getCollection("Sucursales");

            MongoCursor < Integer > mongoCursor = mongoCollection.distinct("sucursal", Integer.class).iterator();

            System.out.println("\n\nDetalles Farmacia/Perfumerias");
            System.out.println("--------------------------------------------------\n");
            System.out.println("Sucursal | Tipo | Ventas | Total");
            System.out.println("---------------------------------");
            float total = 0;

            float farmacia = 0;
            float perfumeria = 0;

            while (mongoCursor.hasNext()) {
                int sucursalNro = mongoCursor.next();
                int cantidadVentas = 0;
                float subTotal = 0;

                Bson bsonFilter = Filters.eq("sucursal", sucursalNro);
                MongoCursor <Document> mongoCursorSucursal = mongoCollection.find(bsonFilter).sort(new BasicDBObject("inventario.precio",-1)).limit(5).iterator();
                //Busca en la DB cada sucursal y suma totales               
                
                while (mongoCursorSucursal.hasNext()) {                    
                    Ventas ventas = new Gson().fromJson(mongoCursorSucursal.next().toJson(), new TypeToken <Ventas> () {}.getType());
                    Date fechaVenta = null;
                    try{
                        fechaVenta = dateFormat.parse(ventas.getFecha());
                    }catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (!fechaInicial.after(fechaVenta) && !fechaFinal.before(fechaVenta)) {
                        subTotal = subTotal + ventas.getTotal();
                        cantidadVentas = cantidadVentas + 1;                       
                    }                    
                }

                MongoCursor <Document> mongoCursorSucursales = mongoCollectionSucursales.find(bsonFilter).iterator();
                Sucursales sucursales = new Gson().fromJson(mongoCursorSucursales.next().toJson(), new TypeToken <Sucursales> () {}.getType());
                if(sucursales.getTipo() == 1){
                    perfumeria = perfumeria + subTotal;
                }else{
                    farmacia = farmacia + subTotal;
                }

                System.out.println(sucursalNro + "\t | " + tipoSucursal[sucursales.getTipo()] + " \t | " + cantidadVentas + "\t | $" + decimalFormat.format(subTotal));
                total = total + subTotal; 

            }  

            System.out.println("\nTotal Ventas en Farmacias: $" + decimalFormat.format(farmacia) + "");
            System.out.println("\nTotal Ventas en Perfumerias: $" + decimalFormat.format(perfumeria) + "");

            System.out.println("\nTotal Ventas Cadena: $" + decimalFormat.format(total) + "\n");               
        }
    }
}