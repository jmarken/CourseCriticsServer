package model.Entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    @Id
    @Column(name="name")
    private String name;

    @OneToOne
    @JoinColumn(name="school_name")
    private School school;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="course")
    private List<Review> reviews;

    public Course() {
    }

    public Course(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", school=" + school +
                ", reviews=" + reviews +
                '}';
    }

    public void addReview(Review review){
        if(reviews == null){
            reviews = new ArrayList<Review>();
        }
        reviews.add(review);
        review.setCourse(this);
    }

}
