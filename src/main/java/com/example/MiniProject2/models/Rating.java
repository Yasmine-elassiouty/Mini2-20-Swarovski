package com.example.MiniProject2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "ratings")
public class Rating {

    @Id
    private String id;
    private Long entityId;
    private String entityType;
    private Integer score;
    private String comment;
    private LocalDateTime ratingDate;

    public Rating() { }


    public Rating(Long entityId, String entityType, Integer score, String comment) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
    }
    
    // extra constructor
    public Rating(long entityId, String entityType, int score, String comment, LocalDateTime ratingDate) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }

    public Rating(String id,
                  Long entityId,
                  String entityType,
                  Integer score,
                  String comment,
                  LocalDateTime ratingDate) {
        this.id = id;
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }

    public Rating(Long entityId,
                  String entityType,
                  Integer score,
                  String comment,
                  LocalDateTime ratingDate) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }


    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDateTime ratingDate) {
        this.ratingDate = ratingDate;
    }

    /**
     * Pre-persist hook: if no ratingDate was provided,
     * set it to now just before saving.
     */
    @PrePersist
    public void setTimestamp() {
        if (this.ratingDate == null) {
            this.ratingDate = LocalDateTime.now();
        }
    }

    // equals and hashCode (all fields)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(id, rating.id) &&
                Objects.equals(entityId, rating.entityId) &&
                Objects.equals(entityType, rating.entityType) &&
                Objects.equals(score, rating.score) &&
                Objects.equals(comment, rating.comment) &&
                Objects.equals(ratingDate, rating.ratingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entityId, entityType, score, comment, ratingDate);
    }

    // toString

    @Override
    public String toString() {
        return "Rating{" +
                "id='" + id + '\'' +
                ", entityId=" + entityId +
                ", entityType='" + entityType + '\'' +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", ratingDate=" + ratingDate +
                '}';
    }
}
