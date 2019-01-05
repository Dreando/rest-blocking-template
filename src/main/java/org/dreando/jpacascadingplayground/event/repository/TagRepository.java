package org.dreando.jpacascadingplayground.event.repository;

import org.dreando.jpacascadingplayground.event.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("select t from Tag t where name in :names")
    Set<Tag> findExisting(Set<String> names);
}
