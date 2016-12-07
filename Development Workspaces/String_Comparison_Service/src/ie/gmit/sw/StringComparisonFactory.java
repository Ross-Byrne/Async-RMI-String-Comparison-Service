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

} // class
