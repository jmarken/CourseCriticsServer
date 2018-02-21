package model.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="review")
public class Review implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

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

    @Column
    private String program;

    @Column
    private Boolean lectures_required;

    @Column
    private Boolean book_required;

    @Column
    private Boolean group_work;

    @Column
    private int time_spent;

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

    public Review(Course course, User user, int quality, int relevance, int difficulty, int teaching, String comment, String program, Boolean lectures_required, Boolean book_required, Boolean group_work, int time_spent) {
        this.course = course;
        this.user = user;
        this.quality = quality;
        this.relevance = relevance;
        this.difficulty = difficulty;
        this.teaching = teaching;
        this.comment = comment;
        this.program = program;
        this.lectures_required = lectures_required;
        this.book_required = book_required;
        this.group_work = group_work;
        this.time_spent = time_spent;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Boolean getLectures_required() {
        return lectures_required;
    }

    public void setLectures_required(Boolean lectures_required) {
        this.lectures_required = lectures_required;
    }

    public Boolean getBook_required() {
        return book_required;
    }

    public void setBook_required(Boolean book_required) {
        this.book_required = book_required;
    }

    public Boolean getGroup_work() {
        return group_work;
    }

    public void setGroup_work(Boolean group_work) {
        this.group_work = group_work;
    }

    public int getTime_spent() {
        return time_spent;
    }

    public void setTime_spent(int time_spent) {
        this.time_spent = time_spent;
    }
}
