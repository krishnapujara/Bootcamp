package ee.bootcamp.assignment.validators;

import ee.bootcamp.assignment.BookingDetail;
import junit.framework.Assert;
import org.junit.Test;

public class OverbookingValidatorSpecs {

    @Test
    public void itShouldCheckUserCannotBookMoreThanTenTickets(){
        //given
        int numberOfTickets = 11;
        BookingDetail details = new BookingDetail(null,null,numberOfTickets);
        TheatreValidator overBookValidator = new OverBookValidator();
        //when
        boolean isValid = overBookValidator.validate(details);
        //then
        Assert.assertFalse(isValid);

    }

    @Test
    public void itShouldCheckUserCanBookLessThanElevenTickets(){
        //given
        int numberOfTickets = 9;
        BookingDetail details = new BookingDetail(null,null,numberOfTickets);
        TheatreValidator overBookValidator = new OverBookValidator();
        //when
        boolean isValid = overBookValidator.validate(details);
        //then
        Assert.assertTrue(isValid);

    }

}
