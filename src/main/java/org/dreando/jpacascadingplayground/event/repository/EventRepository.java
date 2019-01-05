package org.dreando.jpacascadingplayground.event.repository;

import org.dreando.jpacascadingplayground.event.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
