package com.gamemaster.gmapp;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The GameTemplate class represents a game template entity in the application. It is annotated with @Entity to indicate that it is a JPA entity and @Table to specify the corresponding database table name.
 */
@Entity
@Table(name = "game_template")
public class GameTemplate {

    public GameTemplate() {
        //No args constructor, apparently this is necessary for Springboot's Jackson to work properly when deserializing JSON into Java objects.
    };

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
