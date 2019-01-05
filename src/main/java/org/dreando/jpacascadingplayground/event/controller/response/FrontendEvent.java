package org.dreando.jpacascadingplayground.event.controller.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
public class FrontendEvent implements Serializable {

    private final String name;
    private final int tagsNumber;
    private final List<String> tags;
    private final String id;
}
