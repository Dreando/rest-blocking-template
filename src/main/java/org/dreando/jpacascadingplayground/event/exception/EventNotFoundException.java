package org.dreando.jpacascadingplayground.event.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EventNotFoundException extends ResponseStatusException {

    public EventNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("Event of id %d was not found", id));
    }
}
