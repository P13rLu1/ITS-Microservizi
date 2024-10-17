package it.apuliadigital.esercizio06mongoexample;

//import it.apuliadigital.esercizio06mongoexample.document.GroceryItem;
//import it.apuliadigital.esercizio06mongoexample.repository.GroceryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Esercizio06MongoExampleApplication {

//	@Autowired
//	private GroceryRepository groceryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Esercizio06MongoExampleApplication.class, args);
	}


//	@Override
//	public void run(String... args) {
//		createGroceryItems();
//	}
//
//	private void createGroceryItems() {
//		System.out.println("Creating grocery items...");
//
//		System.out.println("Data creation started...");
//		groceryRepository.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
//		groceryRepository.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
//		groceryRepository.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
//		groceryRepository.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
//		groceryRepository.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
//		System.out.println("Data creation complete...");
//	}
}
