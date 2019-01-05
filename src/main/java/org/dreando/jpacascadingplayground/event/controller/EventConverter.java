package org.dreando.jpacascadingplayground.event.controller;

import org.dreando.jpacascadingplayground.common.IdConverter;
import org.dreando.jpacascadingplayground.event.controller.response.FrontendEvent;
import org.dreando.jpacascadingplayground.event.controller.response.FrontendEvents;
import org.dreando.jpacascadingplayground.event.entities.Event;
import org.dreando.jpacascadingplayground.event.entities.Tag;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class EventConverter extends IdConverter {

    FrontendEvent convert(@NonNull Event event) {
        return FrontendEvent.builder()
                .id(encode(event.getId()))
                .name(event.getName())
                .tagsNumber(event.getTags().size())
                .tags(stringifyTags(event))
                .build();
    }

    FrontendEvents convert(@NonNull List<Event> events) {
        return new FrontendEvents(
                events.size(),
                events.stream().map(this::convert).collect(toList())
        );
    }

    private List<String> stringifyTags(@NonNull Event event) {
        return event.getTags()
                .stream()
                .map(Tag::getName)
                .collect(toList());
    }
}
