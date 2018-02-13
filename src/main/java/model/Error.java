package model;

public class Error extends Exception{
    public static class SaveSchoolException extends Exception{
        public SaveSchoolException(String message){
            super(message);
        }
    }

    public static class SaveCourseException extends Exception{
        public SaveCourseException(String message){
            super(message);
        }
    }

    public static class SaveUserException extends Exception{
        public SaveUserException(String message){
            super(message);
        }
    }

    public static class SaveReviewException extends Exception{
        public SaveReviewException(String message){
            super(message);
        }
    }
}
