package ee.bootcamp.assignment.repository;

import ee.bootcamp.assignment.*;
import ee.bootcamp.assignment.response.Confirmation;
import ee.bootcamp.assignment.response.Rejection;
import ee.bootcamp.assignment.response.Response;
import ee.bootcamp.assignment.validators.TheatreValidator;

import java.util.List;
import java.util.ArrayList;

public class MrFamousTheatre implements Theatre {

    private static final int SCREEN_CAPACITY = 50;
    private List<TheatreValidator> validators = new ArrayList<TheatreValidator>();
    private static int availableSeats = 50;

    public MrFamousTheatre(List<TheatreValidator> validators){
        this.validators = validators;
    }

    @Override
    public Response makeReservation(BookingDetail details) {
        if(!this.checkSeatAvailability(details.getNumberOfTickets())){
            return new Rejection("The show you want to make reservation for is house full.");
        }
        if(!this.validateBookingRequest(details)){
            return new Rejection("Booking request is invalid. Please re-try with valid request.");
        }
        List<Integer> allocatedSeatNumbers = allocateSeats(details);
        return new Confirmation("You have successfully booked the ticket for " + DateUtils.format(details.getShowDate()) + UserInput.COMMA
                + UserInput.SPACE + details.getShowTime() + " show.",allocatedSeatNumbers);
    }

    private List<Integer> allocateSeats(BookingDetail details) {
        List<Integer> allocatedSeatNumbers = new ArrayList<Integer>();
        for(int i=1; i <= details.getNumberOfTickets(); ++i){
            allocatedSeatNumbers.add(availableSeats);
            --availableSeats;
        }
        return allocatedSeatNumbers;
    }

    private boolean checkSeatAvailability(int numberOfTickets) {
        return numberOfTickets <= availableSeats;
    }

    private boolean validateBookingRequest(BookingDetail details) {
        for(TheatreValidator validator : validators){
            if(!validator.validate(details)){
                return false;
            }
        }
        return true;
    }
}
