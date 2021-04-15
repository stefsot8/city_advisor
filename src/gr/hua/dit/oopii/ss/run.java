package gr.hua.dit.oopii.ss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class run {

	public static void main(String[] args) throws IOException {
		
		String appid ="801e280b0ae3b2ffa3753f4f13538b13";
		ArrayList<Integer> random_tastes = new ArrayList<>(Arrays.asList(9,1,1,5,8,9,3,4,9,9));
			
		City london = new City ("London", "uk",City.getTerms_vector(), City.getGeodesic_vector());
		Traveller george = new MiddleTraveller (30,"Athens","gr",Traveller.getTastes_vector(),Traveller.getLocation_vector(),MiddleTraveller.getP());		
		london.setLat(london.getCityname(),london.getCitycountry(),appid);
		london.setLon(london.getCityname(),london.getCitycountry(),appid);
		MiddleTraveller.setLat(george.getTown(), george.getCountry(), appid);
		MiddleTraveller.setLon(george.getTown(), george.getCountry(), appid);
		System.out.println(london.getGeodesic_vector());
		System.out.println(george.getLocation_vector());
		System.out.println(george.similarity_geodesic_vector(DistanceCalculator.distance(george.location_vector.get(0), george.location_vector.get(1), london.getGeodesic_vector().get(0), london.getGeodesic_vector().get(1))));
		String text = OpenData.RetrieveData(london.getCityname(),london.getCitycountry(), appid);
		london.getTerms_vector().add(0,CountWords.countCriterionfCity(text, "sea"));
		london.getTerms_vector().add(1,CountWords.countCriterionfCity(text, "mountain"));
		london.getTerms_vector().add(2,CountWords.countCriterionfCity(text, "cafe"));
		london.getTerms_vector().add(3,CountWords.countCriterionfCity(text, "restaurant"));
		london.getTerms_vector().add(4,CountWords.countCriterionfCity(text, "museum"));
		london.getTerms_vector().add(5,CountWords.countCriterionfCity(text, "park"));
		london.getTerms_vector().add(6,CountWords.countCriterionfCity(text, "stadium"));
		london.getTerms_vector().add(7,CountWords.countCriterionfCity(text, "mall"));
		london.getTerms_vector().add(8,CountWords.countCriterionfCity(text, "zoo"));
		london.getTerms_vector().add(9,CountWords.countCriterionfCity(text, "history"));
		System.out.println(london.getTerms_vector());
		Traveller.getTastes_vector().addAll(random_tastes);
		System.out.println(Traveller.getTastes_vector());
		
		System.out.println(george.calculate_similarity(london));

	}

}
