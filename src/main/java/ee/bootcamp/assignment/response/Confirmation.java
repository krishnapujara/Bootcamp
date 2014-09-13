package ee.bootcamp.assignment.response;

import java.util.List;

public class Confirmation implements Response {

    private String message;
    private List<Integer> seatNumbers;

    public Confirmation(String message, List<Integer> seatNumbers){
        this.message = message;
        this.seatNumbers = seatNumbers;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }
}
