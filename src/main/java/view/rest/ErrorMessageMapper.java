package view.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ErrorMessageMapper implements ExceptionMapper<Exception> {
    public Response toResponse(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).
                entity(errorMessage).
                build();
    }
}
