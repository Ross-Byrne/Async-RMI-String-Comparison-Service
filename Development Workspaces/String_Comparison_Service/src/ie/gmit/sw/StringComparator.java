package ie.gmit.sw;

/**
 * Created by Ross Byrne on 07/12/16.
 * Interface for objects that preform some type of string comparison
 */
public interface StringComparator {

    // method for preforming a comparison on two strings. returns result as string
    public String preformComparison(String stringOne, String stringTwo);

} // interface
