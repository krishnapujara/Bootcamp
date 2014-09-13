package ee.bootcamp.assignment.validators;

import ee.bootcamp.assignment.BookingDetail;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;

public class DateValidatorSpecs {
    @Test
    public void itShouldValidateShowDateCannotBeBeforeTodaysDate(){
        //given
        Date showDate = new Date("09/03/2014");
        BookingDetail details = new BookingDetail(showDate,null,0);
        TheatreValidator showDateValidator = new ShowDateValidator();
        //when
        boolean isValid = showDateValidator.validate(details);
        //then
        Assert.assertFalse(isValid);
    }

    @Test
    public void itShouldValidateShowDateCannotBeAfterDayAfterTomorrowsDate(){
        //given
        Date showDate = new Date("10/07/2014");
        BookingDetail details = new BookingDetail(showDate,null,0);
        TheatreValidator showDateValidator = new ShowDateValidator();
        //when
        boolean isValid = showDateValidator.validate(details);
        //then
        Assert.assertFalse(isValid);
    }

    @Test
    public void itShouldValidateShowDateWithinValidDateRange(){
        //given
        Date showDate = new Date("09/07/2014");
        BookingDetail details = new BookingDetail(showDate,null,0);
        TheatreValidator showDateValidator = new ShowDateValidator();
        //when
        boolean isValid = showDateValidator.validate(details);
        //then
        Assert.assertTrue(isValid);
    }


}
