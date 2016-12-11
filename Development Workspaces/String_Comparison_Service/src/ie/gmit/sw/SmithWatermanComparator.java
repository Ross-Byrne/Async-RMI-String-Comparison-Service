package ie.gmit.sw;

import com.ibm.compbio.seqalign.NeedlemanWunsch;
import com.ibm.compbio.seqalign.SmithWaterman;

/**
 * Created by Ross Byrne on 11/12/16.
 * Implementation of StringComparator.
 * Compares Strings using Smith Waterman alogrithm.
 */
public class SmithWatermanComparator implements StringComparator {

    public String preformComparison(String stringOne, String stringTwo) {

        String result = "";

        // create instance of Smith Waterman object
        SmithWaterman s = new SmithWaterman(stringOne, stringTwo);

        // get alignment result
        result = s.getAlignmentScore()+"";

        return result;

    } // preformComparison()

} // class
