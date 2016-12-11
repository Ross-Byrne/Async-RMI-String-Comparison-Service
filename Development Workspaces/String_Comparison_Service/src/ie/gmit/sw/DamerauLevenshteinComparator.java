package ie.gmit.sw;

/**
 * Created by Ross Byrne on 11/12/16.
 * Implementation of StringCamparator.
 * Compares strings using Damerau-Levenshtein Algorithm.
 */
public class DamerauLevenshteinComparator implements StringComparator {

    public String preformComparison(String stringOne, String stringTwo) {

        String result = "";

        // create instance of Damerau-Levenshtein object
        DamerauLevenshtein d = new DamerauLevenshtein();

        // compute comparison and cast to string
        result = d.distance(stringOne, stringTwo)+"";

        return result;

    } // preformComparison()

} // class
