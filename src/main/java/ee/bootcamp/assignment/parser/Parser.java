package ee.bootcamp.assignment.parser;

import ee.bootcamp.assignment.BookingDetail;

import java.util.Map;

public interface Parser {
    BookingDetail parse(Object userInput);
}
