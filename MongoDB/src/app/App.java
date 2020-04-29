package app;

import java.util.*;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

public class App {
    /**
     * App simple que conecta con MongoDB
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        //Cliente
        MongoClient mongoClient = MongoClients.create();
        //Elegir la DB
        MongoDatabase mongoDB = mongoClient.getDatabase("bd2");
        //Elegir la Coleccion
        MongoCollection<Document> mongoCollection = mongoDB.getCollection("main");
        //Leer los Resultados
        MongoCursor<Document> mongoCursor = mongoCollection.find().iterator();
        int resultado = 0;
        while(mongoCursor.hasNext()){
            System.out.println("Resultado ("+ resultado +"): " + mongoCursor.next());
            resultado++;
        }
    }    
}