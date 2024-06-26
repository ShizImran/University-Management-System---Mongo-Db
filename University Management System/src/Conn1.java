import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Conn1 {

    static MongoClient mongoClient;
    private static MongoDatabase database;

    static {
        // Initialize MongoDB connection when the class is loaded
        try {
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase("UniversityManagementSystem"); // Replace with your actual database name
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed");
        }
    }
}
