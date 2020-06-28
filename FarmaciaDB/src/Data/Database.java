package Data;

import com.mongodb.client.MongoClients;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoCollection;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Farmacia.*;

public class Database {
    public int installs = 0;
    public String database; 

    public Database(String dbName) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        this.database = dbName;
    }

    public void install() {
        System.out.println("\n1. Instalacion en MongoDB");        

        Boolean installed = false;        
        installed = installClientes(this.database);
        installed = installEmpleados(this.database);

        if(installed){
            System.out.print("\nInstaladas " + this.installs + " Colecciones en DB [" + this.database + "]\n");    
        }
    }

    public boolean installClientes(String dbName){
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase mongoDB = mongoClient.getDatabase(dbName);        

        try {
            File file = new File("./_json/Clientes.json");
            MongoCollection<Document> mongoCollection = mongoDB.getCollection("Clientes");

            Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
            List<Clientes> clientes = new Gson().fromJson(reader, new TypeToken<List<Clientes>>() {}.getType());
            

            List<Document> documents = new ArrayList<Document>();
            int count = 0;
            for (Clientes c:clientes) {
                count++;
                Document doc = Document.parse(new Gson().toJson(c));
                documents.add(doc);
            }
            System.out.println("\nInsertados " + count + " Clientes Nuevos");
            mongoCollection.insertMany(documents);
            reader.close();
            this.installs++;
            return true;
            
        }catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }   
    
    }

    public boolean installEmpleados(String dbName){
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase mongoDB = mongoClient.getDatabase(dbName);        

        try {
            File file = new File("./_json/Empleados.json");
            MongoCollection<Document> mongoCollection = mongoDB.getCollection("Empleados");

            Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
            List<Empleados> empleados = new Gson().fromJson(reader, new TypeToken<List<Empleados>>() {}.getType());
            

            List<Document> documents = new ArrayList<Document>();
            int count = 0;
            for (Empleados e:empleados) {
                count++;
                Document doc = Document.parse(new Gson().toJson(e));
                documents.add(doc);
            }
            System.out.println("\nInsertados " + count + " Empleados Nuevos");
            mongoCollection.insertMany(documents);
            reader.close();
            this.installs++;
            return true;
            
        }catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }   
    
    }

}