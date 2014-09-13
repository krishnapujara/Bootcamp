package ee.bootcamp.assignment.functionalSpecs;

import ee.bootcamp.assignment.*;
import ee.bootcamp.assignment.parser.Parser;
import ee.bootcamp.assignment.parser.SMSParser;
import ee.bootcamp.assignment.repository.MrFamousTheatre;
import ee.bootcamp.assignment.repository.Theatre;
import ee.bootcamp.assignment.response.Confirmation;
import ee.bootcamp.assignment.response.Response;
import ee.bootcamp.assignment.service.Booking;
import ee.bootcamp.assignment.service.ShortMessageService;
import ee.bootcamp.assignment.validators.OverBookValidator;
import ee.bootcamp.assignment.validators.ShowDateValidator;
import ee.bootcamp.assignment.validators.ShowTimeValidator;
import ee.bootcamp.assignment.validators.TheatreValidator;
import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

public class MovieTicketBookingSpec {

    ShortMessageService shortMessageService;

    @Test
    public void itShouldBookTicket(){
        //given
        List<TheatreValidator> validators = new ArrayList<TheatreValidator>();
        validators.add(new ShowDateValidator());
        validators.add(new ShowTimeValidator());
        validators.add(new OverBookValidator());
        Theatre theatre = new MrFamousTheatre(validators);
        Parser parser = new SMSParser();
        Booking shortMessageService = new ShortMessageService(theatre,parser);

        String showDate = "09/05/2014";
        String showTime = "11 AM";
        String numberOfTickets = "2";
        String sms = "Date: " + showDate + "Time: " + showTime + "Tickets: " + numberOfTickets;

        //when
        Response rejection = shortMessageService.book(sms);

        //then
        Assert.assertEquals("Booking request is invalid. Please re-try with valid request.",rejection.getMessage());
    }

}
