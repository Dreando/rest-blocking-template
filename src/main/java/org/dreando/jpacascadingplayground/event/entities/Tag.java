package org.dreando.jpacascadingplayground.event.entities;

import lombok.*;
import org.dreando.jpacascadingplayground.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
@SequenceGenerator(name = BaseEntity.SEQ_GEN_ID, sequenceName = "tags_seq")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Tag extends BaseEntity {

    @NonNull
    @Column(unique = true)
    private String name;
}
