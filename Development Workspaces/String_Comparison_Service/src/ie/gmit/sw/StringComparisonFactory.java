package ie.gmit.sw;

/**
 * Created by Ross Byrne on 06/12/16.
 * Singleton factory for various different string comparison algorithms.
 */
public class StringComparisonFactory {

    private static StringComparisonFactory stringFactory = new StringComparisonFactory();

    // private constructor so no one can create other instances of factory
    private StringComparisonFactory(){

    } // contructor

    // method to get singleton factory
    public static StringComparisonFactory getInstance(){

        // return factory instance
        return stringFactory;

    } // getInstance()

    // returns the specified string comparison algorithm
    public StringComparator getComparisonAlgorithm(String algo){

        System.out.println("Creating: " + algo + " algorithm object.");

        StringComparator s = null;

        // select the string comparison algorithm
        switch (algo){
            case "Damerau-Levenshtein Distance":

                s = new LevenshteinComparator();
                break;
            case "Euclidean Distance":

                s = new LevenshteinComparator();
                break;
            case "Hamming Distance":

                s = new LevenshteinComparator();
                break;
            case "Hirschberg's Algorithm":

                s = new LevenshteinComparator();
                break;
            case "Jaro–Winkler Distance":

                s = new LevenshteinComparator();
                break;
            case "Levenshtein Distance":

                s = new LevenshteinComparator();
                break;
            case "Needleman-Wunsch":

                s = new LevenshteinComparator();
                break;
            case "Smith Waterman":

                s = new LevenshteinComparator();
                break;
            default:

            s = new LevenshteinComparator();

        } // switch()

        // return it
        return s;

    } // getComparisonAlgorithm()

} // class
