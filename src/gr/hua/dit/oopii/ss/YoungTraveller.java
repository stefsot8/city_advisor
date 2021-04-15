package gr.hua.dit.oopii.ss;

import java.util.ArrayList;

public class YoungTraveller extends Traveller {

	private static double p = 0.9;

	public YoungTraveller(int age, String town, String country, ArrayList<Integer> tastes_vector,
			ArrayList<Double> location_vector, double p) {
		super(age, town, country, tastes_vector, location_vector);
		YoungTraveller.p = p;
	}

	public static double getP() {
		return p;
	}

	public void setP(double p) {
		YoungTraveller.p = p;
	}

	@Override
	public double calculate_similarity(Object City) {
		return p * similarity_terms_vector_euclidian(getTastes_vector(),gr.hua.dit.oopii.ss.City.getTerms_vector()) + (1-p) * similarity_geodesic_vector(gr.hua.dit.oopii.ss.DistanceCalculator.distance(Traveller.location_vector.get(0), Traveller.location_vector.get(1), gr.hua.dit.oopii.ss.City.getGeodesic_vector().get(0), gr.hua.dit.oopii.ss.City.getGeodesic_vector().get(1)));
	}
	
	public double similarity_terms_vector_euclidian (ArrayList<Integer> tastes_vector,ArrayList<Integer> terms_vector) {
		int i=0;
		double sum=0;
		for (i=0;i == terms_vector.size();i++) {
			double math = Math.pow(tastes_vector.get(i) - terms_vector.get(i),2);
			sum = sum + math;
		}
		
		return 1/(1+Math.sqrt(sum));
	}

}
