package ie.gmit.sw;

import java.util.function.ToIntFunction;

/**
 * Created by Ross Byrne on 07/12/16.
 * Implementation of StringCamparator.
 * Compares strings using Levenshtein Algorithm
 */
public class LevenshteinComparator implements StringComparator {

    public String preformComparison(String stringOne, String stringTwo) {

        String result = "";

        // create instance of Levenshtein object
        Levenshtein l = new Levenshtein();

        // compute comparison and cast to string
        result = l.distance(stringOne, stringTwo)+"";

        return result;

    } // preformComparison()

} // class
