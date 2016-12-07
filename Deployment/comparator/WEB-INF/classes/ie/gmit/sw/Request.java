package ie.gmit.sw;

/**
 * Created by Ross Byrne on 05/12/16.
 * Object to hold the request sent from the clients browser
 */
public class Request {

    private String algorithm;
    private String textS;
    private String textT;
    private String taskNumber;

    // Getters and Setters

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getTextS() {
        return textS;
    }

    public void setTextS(String textS) {
        this.textS = textS;
    }

    public String getTextT() {
        return textT;
    }

    public void setTextT(String textT) {
        this.textT = textT;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

} // class
