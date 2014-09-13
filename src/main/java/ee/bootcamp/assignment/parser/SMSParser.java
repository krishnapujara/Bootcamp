package ee.bootcamp.assignment.parser;

import ee.bootcamp.assignment.BookingDetail;

import java.util.Date;

public class SMSParser implements Parser {

    @Override
    public BookingDetail parse(Object userInput){
        BookingDetail details = null;
        if(userInput != null){
            String sms = (String)userInput;
            int showDateStartIndex = ("Date: ").length();
            int showDateEndIndex = sms.indexOf("Time: ");
            int showTimeStartIndex = showDateEndIndex + ("Time: ").length();
            int showTimeEndIndex = sms.indexOf("Tickets: ");
            int ticketsStartIndex = showTimeEndIndex + ("Tickets: ").length();
            int ticketsEndIndex = sms.length();
            Date showDate = new Date(sms.substring(showDateStartIndex,showDateEndIndex));
            String showTime = sms.substring(showTimeStartIndex,showTimeEndIndex);
            int numberOfTickets = Integer.parseInt(sms.substring(ticketsStartIndex,ticketsEndIndex));
            details = new BookingDetail(showDate,showTime,numberOfTickets);
        }
        return details;
    }


}
