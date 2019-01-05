package org.dreando.jpacascadingplayground.event.entities;

import lombok.*;
import org.dreando.jpacascadingplayground.common.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "events")
@SequenceGenerator(name = BaseEntity.SEQ_GEN_ID, sequenceName = "events_seq")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Event extends BaseEntity {

    @NonNull
    private String name;

    @NonNull
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Tag> tags;
}
