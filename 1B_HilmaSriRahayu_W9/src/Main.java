package tekpro9;

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

class Status {
	public int code;
	public String description;
}

class ServicePackage {
	public String service;
	public int value;
}

class City {
	public String origin;
	public String destination;
}

class product {
	public Status status;
	public ServicePackage servicePackage;
	public City city;
	public int weight;
	public int quantity;
	public int priceItem;
	public String productName;
}

public class Main {
	public static void main(String[] args) {
		//read file from data.json as Object
		BufferedReader bufferedReader;
		try {													
			bufferedReader = new BufferedReader(new FileReader("barang.json")); 
		} catch (FileNotFoundException e) {						
			// Error
			e.printStackTrace();
			return;
		}
		
		//parse json into Product array class
        Gson gson = new Gson();
        product[] json = gson.fromJson(bufferedReader, product[].class);
        
		ArrayList<product> produk = new ArrayList<product>();
		
		for(int i = 0; i < json.length ; i++) {
			produk.add(json[i]);
		}

      System.out.println("ProductName | Quantity | Weight | Destination | Service | value | Total");
    
      for( int i = 0; i < produk.size();i++) {
    	System.out.println(produk.get(i).productName + " | " + produk.get(i).quantity + " | " + 
    			produk.get(i).weight + " | " + produk.get(i).city.destination + " | " + 
    			produk.get(i).servicePackage.service + " | " + produk.get(i).servicePackage.value + " | " +
    			(produk.get(i).priceItem*produk.get(i).quantity + produk.get(i).servicePackage.value));
      }
	}
}

