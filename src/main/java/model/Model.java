package model;

import common.*;
import model.Entity.*;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class Model{
    @Inject
    private Factory factory = new Factory();
    private SessionFactory sessionFactory = factory.getFactory();
    DBOperations dbo = new DBOperations(factory, sessionFactory);


    //FOR TESTING
    public static void main(String[] args) {
        Model model = new Model();


        //ExampleData ed = new ExampleData();
        //ed.enterStuff();

    }

    public void createUser(UserDTO registerUser) throws Error.SaveUserException{
        try{
            User newUser = new User(registerUser.getUsername(), registerUser.getPassword());
            dbo.saveUser(newUser);
        }catch(Error.SaveUserException sue){
            throw sue;
        }
    }

    public Boolean login(UserDTO userDTO){
        User dbUser = dbo.getUser(userDTO.getUsername());
        if(dbUser == null){
            return false;
        }else{
            return dbUser.getPassword().equals(userDTO.getPassword());
        }
    }

    public void createCourse (CourseDTO courseDTO) throws Error.SaveCourseException, Error.SaveSchoolException {
        School school = new School(courseDTO.getSchool());
        try {
            dbo.saveSchool(school);
        }catch (Error.SaveSchoolException sse){
            throw sse;
        }

        school = dbo.getSchool(courseDTO.getSchool());
        Course course = new Course(courseDTO.getName(), school);
        System.out.println(school);
        System.out.println(course);
        try{
            dbo.saveCourse(course);
        }catch (Error.SaveCourseException sce){
            throw sce;
        }
    }

    public List<CourseDTO> getCourses(){
        List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();
        for(Course c : dbo.getAllCourses()){

            courseDTOList.add(getAverages(c));
        }
        return courseDTOList;
    }

    private CourseDTO getAverages(Course c){
        int additions = 0;
        double avgQuality = 0;
        double avgRelevance = 0;
        double avgDifficulty = 0;
        double avgTeaching = 0;
        String programs = "";
        double avgLecturesReq = 0;
        double avgBookReq = 0;
        double avgGroupWork = 0;
        double avgTimeSpent = 0;

        for(Review r : c.getReviews()){
            avgQuality = avgQuality + r.getQuality();
            avgRelevance = avgRelevance + r.getRelevance();
            avgDifficulty = avgDifficulty + r.getDifficulty();
            avgTeaching = avgTeaching + r.getTeaching();
            if(programs.equals("")){
                programs = r.getProgram();
            }
            if(!programs.contains(r.getProgram())){
                programs = programs + ", " + r.getProgram();
            }
            if(r.getLectures_required()){
                avgLecturesReq++;
            }
            if(r.getBook_required()){
                avgBookReq++;
            }
            if(r.getGroup_work()){
                avgGroupWork++;
            }
            avgTimeSpent = avgTimeSpent + r.getTime_spent();

            additions++;
        }
        avgQuality = avgQuality/additions;
        avgRelevance = avgRelevance/additions;
        avgDifficulty = avgDifficulty/additions;
        avgTeaching = avgTeaching/additions;
        avgLecturesReq = (avgLecturesReq/additions)*100;
        avgBookReq = (avgBookReq/additions)*100;
        avgGroupWork = (avgGroupWork/additions)*100;
        avgTimeSpent = avgTimeSpent/additions;

        CourseDTO tempDTO = new CourseDTO(c.getName(),
                c.getSchool().getName(),
                roundToOneDecimal(avgQuality, 1),
                roundToOneDecimal(avgRelevance, 1),
                roundToOneDecimal(avgDifficulty, 1),
                roundToOneDecimal(avgTeaching, 1),
                programs,
                roundToOneDecimal(avgLecturesReq, 1),
                roundToOneDecimal(avgBookReq, 1),
                roundToOneDecimal(avgGroupWork, 1),
                roundToOneDecimal(avgTimeSpent, 1)
        );
        return tempDTO;
    }

    private static double roundToOneDecimal(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public CourseDTO getCourse(String name){
        Course course = dbo.getCourse(name);
        if(course == null){
            return null;
        }
        else {
            return getAverages(course);
        }
    }

    public List<ReviewDTO> getCourseReviews(String courseName){
        List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();
        for(Review review : dbo.getCourseReviews(courseName)){
            ReviewDTO reviewDTO = new ReviewDTO(review.getCourse().getName(),
                                                review.getCourse().getSchool().getName(),
                                                review.getUser().getUsername(),
                                                review.getQuality(),
                                                review.getRelevance(),
                                                review.getDifficulty(),
                                                review.getTeaching(),
                                                review.getComment(),
                                                review.getProgram(),
                                                review.getLectures_required(),
                                                review.getBook_required(),
                                                review.getGroup_work(),
                                                review.getTime_spent());
            reviewDTOList.add(reviewDTO);
        }
        return reviewDTOList;
    }

    public List<SchoolDTO> getSchools(){
        List<SchoolDTO> schoolDTOList = new ArrayList<SchoolDTO>();
        for(School school : dbo.getAllScools()){
            SchoolDTO schoolDTO = new SchoolDTO(school.getName());
            schoolDTOList.add(schoolDTO);
        }
        return schoolDTOList;
    }

    public List<ReviewDTO> getUsersReviews(String userName){
        List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();
        List<Review> reviewList = dbo.getUsersReviews(userName);
        if(reviewList == null){
            return null;
        }
        for(Review review : reviewList){
            ReviewDTO reviewDTO = new ReviewDTO(review.getCourse().getName(),
                                                review.getCourse().getSchool().getName(),
                                                review.getUser().getUsername(),
                                                review.getQuality(),
                                                review.getRelevance(),
                                                review.getDifficulty(),
                                                review.getTeaching(),
                                                review.getComment(),
                                                review.getProgram(),
                                                review.getLectures_required(),
                                                review.getBook_required(),
                                                review.getGroup_work(),
                                                review.getTime_spent());
            reviewDTOList.add(reviewDTO);
        }
        return reviewDTOList;
    }

    public void updateUser(UserDTO userDTO) throws Error.SaveUserException{
        User user = dbo.getUser(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        try{
            dbo.updateUser(user);
        } catch (Error.SaveUserException sue){
            throw sue;
        }
    }

    public void createReview(ReviewDTO reviewDTO) throws Error.SaveReviewException, Error.SaveCourseException, Error.SaveSchoolException {
        User user = dbo.getUser(reviewDTO.getUser());
        if(user == null){
            throw new Error.SaveReviewException(ErrorMessages.SAVE_REVIEW_FAILED.getErrorMessage());
        }
        Course course = dbo.getCourse(reviewDTO.getCourse());
        if(course == null){
            try{
                School school = dbo.getSchool(reviewDTO.getSchool());
                if(school == null){
                    school = new School(reviewDTO.getSchool());
                    try{
                        dbo.saveSchool(school);
                    }catch (Error.SaveSchoolException sse){
                        throw sse;
                    }
                }
                course = new Course(reviewDTO.getCourse(), school);
                dbo.saveCourse(course);
            }catch (Error.SaveCourseException sce){
                throw sce;
            }
        }
        Review review = new Review(course,
                                    user,
                                    reviewDTO.getQuality(),
                                    reviewDTO.getRelevance(),
                                    reviewDTO.getDifficulty(),
                                    reviewDTO.getTeaching(),
                                    reviewDTO.getComment(),
                                    reviewDTO.getProgram(),
                                    reviewDTO.getLecturesRequired(),
                                    reviewDTO.getBookRequired(),
                                    reviewDTO.getGroupWork(),
                                    reviewDTO.getTimeSpent());
        try {
            dbo.saveReview(review);
        }catch (Error.SaveReviewException sre){
            throw sre;
        }
    }
}
