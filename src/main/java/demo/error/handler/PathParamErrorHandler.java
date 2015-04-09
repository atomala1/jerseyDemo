package demo.error.handler;

import demo.error.exception.BadParameterException;
import demo.error.model.ErrorMessage;
import org.glassfish.jersey.server.ParamException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * A PathParameter exception mapper that grabs PathParam exceptions and wraps them in a nice message.
 *
 * Created by atomala on 4/4/2015.
 */
@Provider
public class PathParamErrorHandler
        implements ExceptionMapper<ParamException.PathParamException>
{

    @Override
    public Response toResponse(final ParamException.PathParamException e) {
        Response.Status status = Response.Status.BAD_REQUEST;

        final Throwable cause = e.getCause();

        if (cause instanceof BadParameterException) {
            return Response.status(status).entity(new ErrorMessage(status.getStatusCode(), cause.getMessage())).build();
        }
        return null;
    }
}