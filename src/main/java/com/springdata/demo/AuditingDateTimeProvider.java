package com.springdata.demo;

import com.springdata.service.DateTimeService;
import org.springframework.data.auditing.DateTimeProvider;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by kavita on 1/7/17.
 */
public class AuditingDateTimeProvider implements DateTimeProvider {
    private final DateTimeService dateTimeService;

    public AuditingDateTimeProvider(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }


    @Override
    public Calendar getNow() {
        return GregorianCalendar.from(dateTimeService.getCurrentDateAndTime());
    }
}
