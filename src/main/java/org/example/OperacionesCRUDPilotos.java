package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;



import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class OperacionesCRUDPilotos {
    private static final String uri ="mongodb://jorge2:Pass1234@52.203.11.237:27017/f1-2006";


    public static void crearPiloto(Piloto p){
        try(MongoClient mongoClient = MongoClients.create(uri)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> coleccionPilotos = database.getCollection("drivers", Piloto.class);

            coleccionPilotos.insertOne(p);

        }
        catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static Piloto leerPiloto(int id){
        try(MongoClient mongoClient = MongoClients.create(uri)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> coleccionPilotos = database.getCollection("drivers", Piloto.class);
            coleccionPilotos.find().forEach(System.out::println);
            Piloto piloto = coleccionPilotos.find(eq("driverid",id)).first();
            System.out.println(piloto.driverid);
            return piloto;

        }
        catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return null;
    }


}
