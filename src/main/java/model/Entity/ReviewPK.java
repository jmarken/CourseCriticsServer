package model.Entity;

import java.io.Serializable;

public class ReviewPK implements Serializable{
    protected Course course;

    protected User user;

    public ReviewPK(){

    }

    public ReviewPK(Course course, User user) {
        this.course = course;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewPK reviewPK = (ReviewPK) o;

        if (!course.equals(reviewPK.course)) return false;
        return user.equals(reviewPK.user);
    }

    @Override
    public int hashCode() {
        int result = course.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
