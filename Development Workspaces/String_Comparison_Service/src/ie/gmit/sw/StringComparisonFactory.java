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

        StringComparator s = null;

        // select the string comparison algorithm
        switch (algo){
            case "Damerau-Levenshtein Distance":

                System.out.println("Creating: " + algo + " algorithm object.");

                s = new DamerauLevenshteinComparator();
                break;
            case "Euclidean Distance":

                System.out.println("Creating: " + algo + " algorithm object.");

                s = new LevenshteinComparator();
                break;
            case "Hamming Distance":

                System.out.println("Creating: " + algo + " algorithm object.");

                s = new HammingDistanceComparator();
                break;
            case "Hirschberg's Algorithm":

                System.out.println("Creating: " + algo + " algorithm object.");

                s = new LevenshteinComparator();
                break;
            case "Jaro-Winkler Distance":

                System.out.println("Creating: " + algo + " algorithm object.");

                s = new JaroWinklerComparator();
                break;
            case "Levenshtein Distance":

                System.out.println("Creating: " + algo + " algorithm object.");

                s = new LevenshteinComparator();
                break;
            case "Needleman-Wunsch":

                System.out.println("Creating: " + algo + " algorithm object.");

                s = new NeedlemanWunschComparator();
                break;
            case "Smith Waterman":

                System.out.println("Creating: " + algo + " algorithm object.");

                s = new SmithWatermanComparator();
                break;
            default:

                System.out.println("Creating: " + algo + " algorithm object as default.");

                s = new LevenshteinComparator();
                break;

        } // switch()

        // return it
        return s;

    } // getComparisonAlgorithm()

} // class
