package view.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReviewDTO {
    private String course;
    private String school;
    private String quality;
    private String relevance;
    private String difficulty;
    private String teaching;
    private String comment;
    private String program;
    private String lecturesRequired;
    private String bookRequired;
    private String groupWork;
    private String timeSpent;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTeaching() {
        return teaching;
    }

    public void setTeaching(String teaching) {
        this.teaching = teaching;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getLecturesRequired() {
        return lecturesRequired;
    }

    public void setLecturesRequired(String lecturesRequired) {
        this.lecturesRequired = lecturesRequired;
    }

    public String getBookRequired() {
        return bookRequired;
    }

    public void setBookRequired(String bookRequired) {
        this.bookRequired = bookRequired;
    }

    public String getGroupWork() {
        return groupWork;
    }

    public void setGroupWork(String groupWork) {
        this.groupWork = groupWork;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }
}
