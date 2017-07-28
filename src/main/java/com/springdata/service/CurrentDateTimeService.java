package com.springdata.service;

import java.time.ZonedDateTime;

/**
 * Created by kavita on 1/7/17.
 */
public class CurrentDateTimeService implements DateTimeService {

    @Override
    public ZonedDateTime getCurrentDateAndTime() {
        return ZonedDateTime.now();
    }
}
