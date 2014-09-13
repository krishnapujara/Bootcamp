package ee.bootcamp.assignment.validators;

import ee.bootcamp.assignment.BookingDetail;

import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;

public class ShowTimeValidator implements TheatreValidator{

    private static final List<String> validShowTimes = new ArrayList<String>(Arrays.asList("11 AM","5 PM", "8 PM"));

    @Override
    public boolean validate(BookingDetail details) {
        return validShowTimes.contains(details.getShowTime());
    }
}
