package com.library.Book.Library.repository;

import com.library.Book.Library.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByOrderByDateDesc();

    List<Event> findAllByNameContainingOrderByDateDesc(String name);

    List<Event> findByDate(Date date);

}
