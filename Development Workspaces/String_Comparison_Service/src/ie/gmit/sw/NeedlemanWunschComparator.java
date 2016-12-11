package ie.gmit.sw;

import com.ibm.compbio.seqalign.NeedlemanWunsch;

/**
 * Created by Ross Byrne on 11/12/16.
 * Implementation of StringComparator.
 * Compares Strings using Needleman-Wunsch alogrithm.
 */
public class NeedlemanWunschComparator implements StringComparator {

    public String preformComparison(String stringOne, String stringTwo) {

        String result = "";

        // create instance of Needleman-Wunsch object
        NeedlemanWunsch d = new NeedlemanWunsch(stringOne, stringTwo);

        // get alignment result
        result = d.getAlignmentScore()+"";

        return result;

    } // preformComparison()

} // class
