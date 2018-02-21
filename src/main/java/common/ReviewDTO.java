package common;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReviewDTO {
    private String course;
    private String school;
    private String user;
    private int quality;
    private int relevance;
    private int difficulty;
    private int teaching;
    private String comment;
    private String program;
    private Boolean lecturesRequired;
    private Boolean bookRequired;
    private Boolean groupWork;
    private int timeSpent;


    public ReviewDTO() {
    }

    public ReviewDTO(String course, String school, String user, int quality, int relevance, int difficulty, int teaching, String comment) {
        this.course = course;
        this.school = school;
        this.user = user;
        this.quality = quality;
        this.relevance = relevance;
        this.difficulty = difficulty;
        this.teaching = teaching;
        this.comment = comment;
    }

    public ReviewDTO(String course, String school, String user, int quality, int relevance, int difficulty, int teaching, String comment, String program, Boolean lecturesRequired, Boolean bookRequired, Boolean groupWork, int timeSpent) {
        this.course = course;
        this.school = school;
        this.user = user;
        this.quality = quality;
        this.relevance = relevance;
        this.difficulty = difficulty;
        this.teaching = teaching;
        this.comment = comment;
        this.program = program;
        this.lecturesRequired = lecturesRequired;
        this.bookRequired = bookRequired;
        this.groupWork = groupWork;
        this.timeSpent = timeSpent;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Boolean getLecturesRequired() {
        return lecturesRequired;
    }

    public void setLecturesRequired(Boolean lecturesRequired) {
        this.lecturesRequired = lecturesRequired;
    }

    public Boolean getBookRequired() {
        return bookRequired;
    }

    public void setBookRequired(Boolean bookRequired) {
        this.bookRequired = bookRequired;
    }

    public Boolean getGroupWork() {
        return groupWork;
    }

    public void setGroupWork(Boolean groupWork) {
        this.groupWork = groupWork;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "course='" + course + '\'' +
                ", school='" + school + '\'' +
                ", user='" + user + '\'' +
                ", quality=" + quality +
                ", relevance=" + relevance +
                ", difficulty=" + difficulty +
                ", teaching=" + teaching +
                ", comment='" + comment + '\'' +
                '}';
    }
}
