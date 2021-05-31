package com.library.Book.Library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "events")
@NoArgsConstructor
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    private String name;
    private Date date;
    private String details;

    public Event(String name, Date date, String details) {
        this.name = name;
        this.date = date;
        this.details = details;
    }
}
