package ee.bootcamp.assignment.validators;

import ee.bootcamp.assignment.BookingDetail;

import java.util.Calendar;
import java.util.Date;

public class ShowDateValidator implements TheatreValidator{

    @Override
    public boolean validate(BookingDetail details) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 2);
        Date dayAfterTommorow = calendar.getTime();
        return !(details.getShowDate().before(today) || details.getShowDate().after(dayAfterTommorow));
    }
}
