package ie.gmit.sw;

/**
 * Created by Ross Byrne on 11/12/16.
 * Implementation of StringCamparator.
 * Compares strings using Hamming Distance Algorithm
 */
public class HammingDistanceComparator implements StringComparator{

    public String preformComparison(String stringOne, String stringTwo) {

        String result = "";

        // create instance of Hamming distance object
        HammingDistance h = new HammingDistance();

        // compute comparison and cast to string
        result = h.distance(stringOne, stringTwo)+"";

        return result;

    } // preformComparison()


} // class
