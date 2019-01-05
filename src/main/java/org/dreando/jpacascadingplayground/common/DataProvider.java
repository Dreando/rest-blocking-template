package org.dreando.jpacascadingplayground.common;

import com.google.common.collect.Sets;
import org.dreando.jpacascadingplayground.event.EventService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile(Profiles.DEV_PROFILE)
public class DataProvider {

    private final EventService eventService;

    public DataProvider(EventService eventService) {
        this.eventService = eventService;
    }

    @PostConstruct
    public void init() {
        eventService.create("Flood", Sets.newHashSet("natural-disaster"));
        eventService.create("Fire", Sets.newHashSet("natural-disaster", "human-based"));
    }
}
