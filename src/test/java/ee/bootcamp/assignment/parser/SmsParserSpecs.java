package ee.bootcamp.assignment.parser;

import ee.bootcamp.assignment.BookingDetail;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SmsParserSpecs {


    @Test
    public void itShouldParseSmsIntoTicketDetails(){
        //given
        String showDate = "09/05/2014";
        String showTime = "11 AM";
        String numberOfTickets = "2";
        String sms = "Date: " + showDate + "Time: " + showTime + "Tickets: " + numberOfTickets;
        Parser smsParser = new SMSParser();
        //when
        BookingDetail details = smsParser.parse(sms);
        //then
        Assert.assertEquals(new Date("09/05/2014").getTime(), details.getShowDate().getTime());
        Assert.assertEquals(showTime, details.getShowTime());
        Assert.assertEquals(2,details.getNumberOfTickets());
    }
}
