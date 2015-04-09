package demo.error.handler;

import demo.error.exception.BadParameterException;
import demo.error.model.ErrorMessage;
import org.glassfish.jersey.server.ParamException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * A QueryParameter exception mapper that grabs QueryParameter exceptions and wraps them in a nice message.
 *
 * Created by atomala on 4/4/2015.
 */
@Provider
public class QueryParamErrorHandler
        implements ExceptionMapper<ParamException.QueryParamException>
{

    @Override
    public Response toResponse(final ParamException.QueryParamException e) {
        Response.Status status = Response.Status.BAD_REQUEST;

        final Throwable cause = e.getCause();

        if (cause instanceof BadParameterException) {
            return Response.status(status).entity(new ErrorMessage(status.getStatusCode(), cause.getMessage())).build();
        }
        return null;
    }
}