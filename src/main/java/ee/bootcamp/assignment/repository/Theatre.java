package ee.bootcamp.assignment.repository;

import ee.bootcamp.assignment.BookingDetail;
import ee.bootcamp.assignment.response.Response;

public interface Theatre {

    Response makeReservation(BookingDetail details);
}
