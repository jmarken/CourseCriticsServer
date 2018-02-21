package common;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CourseDTO {
    private String name;
    private String school;
    private double avgQuality;
    private double avgRelevance;
    private double avgDifficulty;
    private double avgTeaching;
    private String programs;
    private double avgLecturesReq;
    private double avgBookReq;
    private double avgGroupWork;
    private double avgTime;

    public CourseDTO() {
    }

    public CourseDTO(String name, String school) {
        this.name = name;
        this.school = school;
    }

    public CourseDTO(String name, String school, double avgQuality, double avgRelevance, double avgDifficulty, double avgTeaching, String program, double avgLecturesReq, double avgBookReq, double avgGroupWork, double avgTime) {
        this.name = name;
        this.school = school;
        this.avgQuality = avgQuality;
        this.avgRelevance = avgRelevance;
        this.avgDifficulty = avgDifficulty;
        this.avgTeaching = avgTeaching;
        this.programs = program;
        this.avgLecturesReq = avgLecturesReq;
        this.avgBookReq = avgBookReq;
        this.avgGroupWork = avgGroupWork;
        this.avgTime = avgTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getAvgQuality() {
        return avgQuality;
    }

    public void setAvgQuality(double avgQuality) {
        this.avgQuality = avgQuality;
    }

    public double getAvgRelevance() {
        return avgRelevance;
    }

    public void setAvgRelevance(double avgRelevance) {
        this.avgRelevance = avgRelevance;
    }

    public double getAvgDifficulty() {
        return avgDifficulty;
    }

    public void setAvgDifficulty(double avgDifficulty) {
        this.avgDifficulty = avgDifficulty;
    }

    public double getAvgTeaching() {
        return avgTeaching;
    }

    public void setAvgTeaching(double avgTeaching) {
        this.avgTeaching = avgTeaching;
    }

    public String getPrograms() {
        return programs;
    }

    public void setPrograms(String programs) {
        this.programs = programs;
    }

    public double getAvgLecturesReq() {
        return avgLecturesReq;
    }

    public void setAvgLecturesReq(double avgLecturesReq) {
        this.avgLecturesReq = avgLecturesReq;
    }

    public double getAvgBookReq() {
        return avgBookReq;
    }

    public void setAvgBookReq(double avgBookReq) {
        this.avgBookReq = avgBookReq;
    }

    public double getAvgGroupWork() {
        return avgGroupWork;
    }

    public void setAvgGroupWork(double avgGroupWork) {
        this.avgGroupWork = avgGroupWork;
    }

    public double getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(double avgTime) {
        this.avgTime = avgTime;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", avgQuality=" + avgQuality +
                ", avgRelevance=" + avgRelevance +
                ", avgDifficulty=" + avgDifficulty +
                ", avgTeaching=" + avgTeaching +
                ", programs='" + programs + '\'' +
                ", avgLecturesReq=" + avgLecturesReq + "%" +
                ", avgBookReq=" + avgBookReq + "%" +
                ", avgGroupWork=" + avgGroupWork + "%" +
                ", avgTime=" + avgTime +
                '}';
    }
}
