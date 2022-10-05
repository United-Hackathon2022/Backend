package com.hackaton.hackation2022.domain.calendar.domain;

import com.hackaton.hackation2022.domain.calendar.domain.type.CalendarStatus;
import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_calendar")
public class Calendar extends BaseTimeIdEntity {

    @NotNull
    private LocalDate date;

    @NotNull
    @Length(max = 15)
    private CalendarStatus calendarStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Calendar(LocalDate date, CalendarStatus calendarStatus, User user) {
        this.date = date;
        this.calendarStatus = calendarStatus;
        this.user = user;
    }
}
