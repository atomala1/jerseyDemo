package demo.error.handler;

import demo.error.model.ErrorMessage;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * An exception handler that grabs NotFoundExceptions and wraps them in a nice message.
 *
 * Created by atomala on 4/4/2015.
 */
@Provider
public class NotFoundExceptionErrorHandler
    implements ExceptionMapper<NotFoundException>
{

    @Override
    public Response toResponse(final NotFoundException e) {
        Response.Status status = Response.Status.NOT_FOUND;
        return Response.status(status).entity(new ErrorMessage(status.getStatusCode(), "The resource was not found.")).build();
    }
}
