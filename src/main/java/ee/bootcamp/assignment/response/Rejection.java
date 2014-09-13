package ee.bootcamp.assignment.response;

public class Rejection implements Response {

    private String message;

    public Rejection(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
