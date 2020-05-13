package Data;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

public class Database {
    
    public Database(String dbName, String dbColl) {
           //Cliente
           MongoClient mongoClient = MongoClients.create();
           //Elegir la DB
           MongoDatabase mongoDB = mongoClient.getDatabase(dbName);
           //Elegir la Coleccion
           MongoCollection<Document> mongoCollection = mongoDB.getCollection(dbColl);
           //Leer los Resultados
           MongoCursor<Document> mongoCursor = mongoCollection.find().iterator();
           int resultado = 0;
           while(mongoCursor.hasNext()){
               System.out.println("[CLASE DATABASE] Resultado # ("+ resultado +"): " + mongoCursor.next());
               resultado++;
           }
    }

}