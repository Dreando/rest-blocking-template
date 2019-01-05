package org.dreando.jpacascadingplayground;

import org.assertj.core.util.Sets;
import org.dreando.jpacascadingplayground.event.entities.Event;
import org.dreando.jpacascadingplayground.event.EventService;
import org.dreando.jpacascadingplayground.event.entities.Tag;
import org.dreando.jpacascadingplayground.event.repository.TagRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TagsCascadingTest extends BaseDatabaseTest {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private EventService eventService;

    @Test
    public void test() {

        eventService.create("event1", Sets.newLinkedHashSet("tag1", "tag2"));

        List<Tag> all1 = tagRepository.findAll();

        assertThat(all1).hasSize(2);

        //

        eventService.create("event2", Sets.newLinkedHashSet("tag2", "tag3"));

        List<Tag> all2 = tagRepository.findAll();

        assertThat(all2).hasSize(3);

        //

        eventService.create("event3", Sets.newLinkedHashSet("tag1", "tag2", "tag3"));

        List<Tag> all3 = tagRepository.findAll();

        assertThat(all3).hasSize(3);

        //

        eventService.create("event4", Sets.newLinkedHashSet("tag1", "tag2", "tag3", "tag4"));

        List<Tag> all4 = tagRepository.findAll();

        assertThat(all4).hasSize(4);
        List<Event> events = eventService.getEvents();
        assertThat(events).hasSize(4);
    }
}
