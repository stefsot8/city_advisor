package gr.hua.dit.oopii.ss;

import java.io.IOException;
import java.util.ArrayList;

public class City {
	
	private String cityname;
	private String citycountry;
	private static ArrayList<Integer> terms_vector = new ArrayList<Integer>(10);
	private static ArrayList<Double> geodesic_vector = new ArrayList<Double>(2);

	public City(String cityname, String citycountry, ArrayList<Integer> terms_vector, ArrayList<Double> geodesic_vector) {
		super();
		this.cityname = cityname;
		this.citycountry = citycountry;
		City.terms_vector = terms_vector;
		City.geodesic_vector = geodesic_vector;
	}

	public static ArrayList<Integer> getTerms_vector() {
		return terms_vector;
	}

	public void setTerms_vector(ArrayList<Integer> terms_vector) {
		City.terms_vector = terms_vector;
	}

	public static ArrayList<Double> getGeodesic_vector() {
		return geodesic_vector;
	}

	public void setGeodesic_vector(ArrayList<Double> geodesic_vector) {
		City.geodesic_vector = geodesic_vector;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCitycountry() {
		return citycountry;
	}

	public void setCitycounty(String citycountry) {
		this.citycountry = citycountry;
	}	
	
	public static void setLat (String city,String country,String appid) throws IOException {
		geodesic_vector.add(0, OpenData.RetrieveLat(city, country, appid));
	}
	
	public static void setLon (String city,String country,String appid) throws IOException {
		geodesic_vector.add(1, OpenData.RetrieveLon(city, country, appid));
	}
}