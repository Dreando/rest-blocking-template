package org.dreando.jpacascadingplayground.event.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class FrontendEvents implements Serializable {

    private final int eventsNumber;
    private final List<FrontendEvent> events;
}
