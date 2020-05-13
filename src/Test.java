import java.util.ArrayList;

import com.dealership.auto.Automobile;
import com.dealership.data.Database;
import com.dealership.dealer.Dealer;
import com.dealership.global.Address;
import com.dealership.user.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		private String make;
		private String model;
		private String purchaseDate;
		private String year;
		private double price;
		private int mileage;
		private String description;
		private ArrayList<String> pictures;
		private String vin;
		private String transmission;
		private String bodyType;
		private String engine;
		private boolean newVehicle;
		

		Automobile auto = new Automobile("honda", "civic", "1995", "IYU783478JKJGDFDSJ378");
		auto.setPrice(34500);
		auto.setMileage(150345);
		auto.setDescription("Big TOO Car");
		auto.setTransmission("automatic");
		auto.setEngine("electric");
		auto.setBodyType("box");
		auto.setNewVehicle(true);
		auto.addPicture("https://images.craigslist.org/00g0g_2m34AubmipY_600x450.jpg");
		ArrayList<String> newList = Database.checkNull(auto.getPictures());

		Dealer dealer = new Dealer("Patrick", "Kramer", "pjk1413@gmail.com", "password", "PKEnterprise");
		dealer.save();
		
		Dealer newDealer = Dealer.load(dealer.getEmail());
		newDealer.addInventory(auto.getVin());
		
		System.out.println(newDealer.getInventory().get(0));
		Dealer.update(newDealer);
		newDealer.removeInventory(auto.getVin());
		Dealer.update(newDealer);
		Dealer.delete(dealer.getEmail());
		*/
		
		User user = new User("Patrick", "Kramer", "pjk1413@gmail.com", "password");
		Address address = new Address();
		address.setStreet("6201 Pernod Ave");
		address.setCity("St. Louis");
		address.setState("Missouri");
		address.setZipcode("63139");
		
		user.setAddress(address);
		user.save();
		
		
		
		
		
		
		
		
		
		
		
	}

}
