package com.imrochamatheus.events_organizer.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_block")
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_time", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant start;

    @Column(name = "end_time", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant end;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public Block () {}

    public Block(Integer id, Instant start, Instant end, Activity activity) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.activity = activity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getStart() {
        return start;
    }

    public void setStart(Instant start) {
        this.start = start;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
        this.end = end;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;

        return Objects.equals(this.id, block.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}
