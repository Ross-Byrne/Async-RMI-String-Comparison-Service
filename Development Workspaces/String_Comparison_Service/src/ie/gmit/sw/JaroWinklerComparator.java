package ie.gmit.sw;

import com.ibm.compbio.seqalign.SmithWaterman;
import info.debatty.java.stringsimilarity.JaroWinkler;

/**
 * Created by Ross Byrne on 11/12/16.
 * Implementation of StringComparator.
 * Compares Strings using Jaro Winkler alogrithm.
 * Source code for algorithm taken from: https://github.com/tdebatty/java-string-similarity
 */
public class JaroWinklerComparator implements StringComparator {

    public String preformComparison(String stringOne, String stringTwo) {

        String result = "";

        // create instance of Jaro Winkler object
        JaroWinkler j = new JaroWinkler();

        // get distance result
        result = j.distance(stringOne, stringTwo)+"";

        return result;

    } // preformComparison()

} // class
