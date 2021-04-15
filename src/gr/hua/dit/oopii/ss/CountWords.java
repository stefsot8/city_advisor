package gr.hua.dit.oopii.ss;

import java.util.ArrayList;

public class CountWords {

	/**
	 * Counts distinct words in the input String.
	 * 
	 * @param str The input String.
	 * @return An integer, the number of distinct words.
	 */

	public static int countDistinctWords(String str) {
		String s[] = str.split(" ");
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 1; i < s.length; i++) {
			if (!(list.contains(s[i]))) {
				list.add(s[i]);
			}
		}
		return list.size();
	}

	/**
	 * Counts all words in the input String.
	 * 
	 * @param str The input String.
	 * @return An integer, the number of all words.
	 */
	public static int countTotalWords(String str) {
		String s[] = str.split(" ");
		return s.length;
	}

	/**
	 * Counts the number of times a criterion occurs in the city wikipedia article.
	 * 
	 * @param cityArticle The String of the retrieved wikipedia article.
	 * @param criterion   The String of the criterion we are looking for.
	 * @return An integer, the number of times the criterion-string occurs in the
	 *         wikipedia article.
	 */
	public static int countCriterionfCity(String cityArticle, String criterion) {
		cityArticle = cityArticle.toLowerCase();
		int index = cityArticle.indexOf(criterion);
		int count = 0;
		while (index != -1) {
			count++;
			cityArticle = cityArticle.substring(index + 1);
			index = cityArticle.indexOf(criterion);
		}
		if(count >=10) { //θεωρω οτι αμα ειναι μεγαλυτερο του 10 φτανει το μεγιστο αρα παιρνει 10
		return 10;
		}else return count;
	}

}