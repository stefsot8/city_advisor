package gr.hua.dit.oopii.ss;

import java.util.ArrayList;

public class MiddleTraveller extends Traveller{
	
	private static double p = 0.5;

	public MiddleTraveller(int age, String town, String country, ArrayList<Integer> tastes_vector,
			ArrayList<Double> location_vector, double p) {
		super(age, town, country, tastes_vector, location_vector);
		MiddleTraveller.p = p;
	}

	public static double getP() {
		return p;
	}

	public void setP(double p) {
		MiddleTraveller.p = p;
	}

	@Override
	public double calculate_similarity(Object City) {
		return p * similarity_terms_vector_cosine(getTastes_vector(),gr.hua.dit.oopii.ss.City.getTerms_vector()) + (1-p) * similarity_geodesic_vector(gr.hua.dit.oopii.ss.DistanceCalculator.distance(Traveller.location_vector.get(0), Traveller.location_vector.get(1), gr.hua.dit.oopii.ss.City.getGeodesic_vector().get(0), gr.hua.dit.oopii.ss.City.getGeodesic_vector().get(1)));
	}
	
	public double similarity_terms_vector_cosine (ArrayList<Integer> tastes_vector,ArrayList<Integer> terms_vector) {
		int i;
		double sum,sum1,sum2 = 0;
		double numerator = 0,denominator1 = 0,denominator2 = 0;
		for (i=0;i==terms_vector.size();i++) {
			sum = terms_vector.get(i) * tastes_vector.get(i);
			numerator = numerator + sum;
			sum1 = Math.pow(terms_vector.get(i), 2);
			denominator1 = denominator1 + sum1;
			sum2 = Math.pow(tastes_vector.get(i), 2);
			denominator2 = denominator2 + sum2;		
		}
		if (denominator1 == 0 || denominator2 == 0) {
			return 0;
		} else {
			return numerator/(Math.sqrt(denominator1) * Math.sqrt(denominator2));
		}
	}
}
