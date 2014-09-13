package ee.bootcamp.assignment;

import java.util.Date;

public class BookingDetail {

    private Date showDate;
    private String showTime;
    private int numberOfTickets;

    public BookingDetail(Date showDate, String showTime, int numberOfTickets){
        this.showDate = showDate;
        this.showTime = showTime;
        this.numberOfTickets = numberOfTickets;
    }

    public Date getShowDate() {
        return showDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
