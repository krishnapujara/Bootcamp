package ee.bootcamp.assignment.service;

import ee.bootcamp.assignment.BookingDetail;
import ee.bootcamp.assignment.parser.Parser;
import ee.bootcamp.assignment.repository.Theatre;
import ee.bootcamp.assignment.response.Confirmation;
import ee.bootcamp.assignment.response.Response;

import java.util.Map;

public class ShortMessageService implements Booking{

    Theatre theatre;
    private Parser parser;

    public ShortMessageService(Theatre theatre, Parser parser){
        this.theatre = theatre;
        this.parser = parser;
    }

    @Override
    public Response book(Object input) {
       BookingDetail details = parser.parse(input);
       return theatre.makeReservation(details);
    }
}
