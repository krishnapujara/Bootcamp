package ee.bootcamp.assignment.validators;

import ee.bootcamp.assignment.BookingDetail;
import junit.framework.Assert;
import org.junit.Test;

public class ShowTimeValidatorSpecs {

    @Test
    public void itShouldValidateShowTimeIsCorrect(){
        //given
        String showTime = "11 AM";
        BookingDetail details = new BookingDetail(null,showTime,0);
        TheatreValidator showTimeValidator = new ShowTimeValidator();
        //when
        boolean isValid = showTimeValidator.validate(details);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void itShouldValidateShowTimeIsInCorrect(){
        //given
        String showTime = "10 AM";
        BookingDetail details = new BookingDetail(null,showTime,0);
        TheatreValidator showTimeValidator = new ShowTimeValidator();
        //when
        boolean isValid = showTimeValidator.validate(details);
        //then
        Assert.assertFalse(isValid);
    }

}
