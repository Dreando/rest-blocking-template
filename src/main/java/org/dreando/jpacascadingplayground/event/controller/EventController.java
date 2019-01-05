package org.dreando.jpacascadingplayground.event.controller;

import org.dreando.jpacascadingplayground.event.EventService;
import org.dreando.jpacascadingplayground.event.controller.response.FrontendEvent;
import org.dreando.jpacascadingplayground.event.controller.response.FrontendEvents;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EventController.EVENTS_ENDPOINT)
public class EventController {

    static final String EVENTS_ENDPOINT = "/event";

    private final EventConverter converter;
    private final EventService eventService;

    public EventController(EventConverter converter, EventService eventService) {
        this.converter = converter;
        this.eventService = eventService;
    }

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public FrontendEvent getEvent(@PathVariable String eventId) {
        return converter.convert(eventService.getEvent(converter.decode(eventId)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public FrontendEvents getEvents() {
        return converter.convert(eventService.getEvents());
    }
}
