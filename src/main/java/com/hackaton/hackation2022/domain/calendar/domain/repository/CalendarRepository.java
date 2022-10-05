package com.hackaton.hackation2022.domain.calendar.domain.repository;

import com.hackaton.hackation2022.domain.calendar.domain.Calendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<Calendar, Long> {
}
