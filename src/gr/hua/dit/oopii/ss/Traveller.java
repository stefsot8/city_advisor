package gr.hua.dit.oopii.ss;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Traveller {
	
	private int age;
	private String town;
	private String country;
	protected static ArrayList<Integer> tastes_vector = new ArrayList<Integer>(10);
	protected static ArrayList<Double> location_vector = new ArrayList<Double>(2);

	public Traveller(int age, String town, String country, ArrayList<Integer> tastes_vector,
			ArrayList<Double> location_vector) {
		super();
		this.age = age;
		this.town = town;
		this.country = country;
		Traveller.tastes_vector = tastes_vector;
		Traveller.location_vector = location_vector;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static ArrayList<Integer> getTastes_vector() {
		return tastes_vector;
	}

	public void setTastes_vector(ArrayList<Integer> tastes_vector) {
		Traveller.tastes_vector = tastes_vector;
	}

	public static ArrayList<Double> getLocation_vector() {
		return location_vector;
	}

	public void setLocation_vector(ArrayList<Double> location_vector) {
		Traveller.location_vector = location_vector;
	}
	
	public abstract double calculate_similarity (Object City);
	
	public static double similarity_geodesic_vector (double distance) {
		double maxdist = 15325;
		return log2(2/(2-(distance/maxdist)));
	}
	
	public static double log2(double x) {
	    return (Math.log(x) / Math.log(2));
	}
	
	public static void setLat (String city,String country,String appid) throws IOException {
		location_vector.add(0, OpenData.RetrieveLat(city, country, appid));
	}
	
	public static void setLon (String city,String country,String appid) throws IOException {
		location_vector.add(1, OpenData.RetrieveLon(city, country, appid));
	}
	
	public void compare_cities (ArrayList<String> Cities) {
		//to be continued...
	}
}	
