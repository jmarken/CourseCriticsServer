package model.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="review ")
public class Review implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name="course_name")
    private Course course;

    @Id
    @ManyToOne
    @JoinColumn(name="user_username")
    private User user;

    @Column
    private int quality;

    @Column
    private int relevance;

    @Column
    private int difficulty;

    @Column
    private int teaching;

    @Column
    private String comment;

    public Review() {
    }

    public Review(Course course, User user, int quality, int relevance, int difficulty, int teaching, String comment) {
        this.course = course;
        this.user = user;
        this.quality = quality;
        this.relevance = relevance;
        this.difficulty = difficulty;
        this.teaching = teaching;
        this.comment = comment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getTeaching() {
        return teaching;
    }

    public void setTeaching(int teaching) {
        this.teaching = teaching;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
