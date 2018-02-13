package common;

public enum ErrorMessages {
    EXAMPLE_ERROR_MESSAGE("This is the example text"),
    SAVE_SCHOOL_FAILED("There was an error saving the school."),
    SAVE_COURSE_FAILED("There was an error saving the course."),
    SAVE_USER_FAILED("There was an error saving the user."),
    SAVE_REVIEW_FAILED("There was an error saving the review.")
    ;


    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}