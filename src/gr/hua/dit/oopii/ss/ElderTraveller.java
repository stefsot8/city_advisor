package gr.hua.dit.oopii.ss;

import java.util.ArrayList;

public class ElderTraveller extends Traveller{
	
	private static double p = 0.1;

	public ElderTraveller(int age, String town, String country, ArrayList<Integer> tastes_vector,
			ArrayList<Double> location_vector, double p) {
		super(age, town, country, tastes_vector, location_vector);
		ElderTraveller.p = p;
	}

	public static double getP() {
		return p;
	}

	public void setP(double p) {
		ElderTraveller.p = p;
	}

	@Override
	public double calculate_similarity(Object City) {
		return p * similarity_terms_vector_jaccard(getTastes_vector(),gr.hua.dit.oopii.ss.City.getTerms_vector()) + (1-p) * similarity_geodesic_vector(gr.hua.dit.oopii.ss.DistanceCalculator.distance(Traveller.location_vector.get(0), Traveller.location_vector.get(1), gr.hua.dit.oopii.ss.City.getGeodesic_vector().get(0), gr.hua.dit.oopii.ss.City.getGeodesic_vector().get(1)));
	}
	
	public static double similarity_terms_vector_jaccard (ArrayList<Integer> tastes_vector,ArrayList<Integer> terms_vector) {
		int i;
		int sum_intersection= 0, sum_union = 0;
		for (i=0;i==tastes_vector.size();i++) {
			if (tastes_vector.get(i)>=1 && terms_vector.get(i)>=1) {
				sum_intersection++;
			}
			if (tastes_vector.get(i)>=1 || terms_vector.get(i)>=1) {
				sum_union++;
			}
		}
		if (sum_union == 0) {
			return 0;
		}else {
			return sum_intersection/sum_union;
		}
	}
}
