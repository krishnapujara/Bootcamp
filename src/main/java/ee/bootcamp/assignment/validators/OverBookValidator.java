package ee.bootcamp.assignment.validators;

import ee.bootcamp.assignment.BookingDetail;

public class OverBookValidator implements TheatreValidator{

    private static final int TICKET_BOOKING_LIMIT = 10;

    @Override
    public boolean validate(BookingDetail details) {
        return details.getNumberOfTickets() <= TICKET_BOOKING_LIMIT;
    }
}
