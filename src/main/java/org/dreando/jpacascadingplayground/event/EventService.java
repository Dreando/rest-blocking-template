package org.dreando.jpacascadingplayground.event;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.dreando.jpacascadingplayground.event.entities.Event;
import org.dreando.jpacascadingplayground.event.entities.Tag;
import org.dreando.jpacascadingplayground.event.exception.EventNotFoundException;
import org.dreando.jpacascadingplayground.event.repository.EventRepository;
import org.dreando.jpacascadingplayground.event.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final TagRepository tagRepository;

    public EventService(EventRepository eventRepository, TagRepository tagRepository) {
        this.eventRepository = eventRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional
    public Event create(String eventName, Set<String> eventTags) {
        Set<Tag> persistedTags = tagRepository.findExisting(eventTags);

        Set<Tag> notPersistedTags = eventTags.stream()
                .map(Tag::new)
                .filter(tag -> !persistedTags.contains(tag))
                .collect(Collectors.toSet());

        return eventRepository.save(new Event(eventName, Sets.union(persistedTags, notPersistedTags)));
    }

    public List<Event> getEvents() {
        return Lists.newArrayList(eventRepository.findAll());
    }

    public Event getEvent(long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
    }
}
