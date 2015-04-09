package demo.controller;

import demo.model.BeanParamObject;
import demo.model.ModelObject;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * The generic controller for this project.  It only has two endpoints to demonstrate the inconsistent behavior.
 * <p>
 * Created by atomala on 4/4/2015.
 */
@Component
@Path("/")
public class DemoController {

    /**
     * This is the endpoint using a QueryParam object.  When you pass in "badMessage" to this endpoint,
     * the ModelObjectParamConverter will throw a BadParameterException.  That will be caught in the QueryParamErrorHandler
     * and will return a nice message to the user saying it wasn't able to handle your message.
     *
     * If you pass in any other string, it will just display 'hello query param object + string'
     *
     * Good message curl command:
     * curl -v http://localhost:8080/query?object_string=hello
     *
     * Bad Message curl command:
     * curl -v http://localhost:8080/query?object_string=badMessage
     */
    @GET
    @Path("/query")
    @Produces("application/json")
    public String queryParamEndpoint(@QueryParam("object_string") final ModelObject modelObject) {
        return "hello query param object " + modelObject.toString();
    }

    /**
     * This is the endpoint using a BeanParam object.  When you pass in "badMessage" to this endpoint,
     * the ModelObjectParamConverter will throw a BadParameterException.  This message SHOULD
     * be caught in the QueryParamErrorHandler and SHOULD return a nice message to the user saying
     * it wasn't able to handle your message.  This is where I think the bug exists.  It will throw a
     * MultiException instead which doesn't allow you to grab the BadParameterException and wrap it with a nice
     * message to the user.
     *
     * If you pass in any other string, it will just display 'hello bean param object + string'
     *
     * Good message curl command:
     * curl -v http://localhost:8080/bean?object_string=hello
     *
     * Bad Message curl command:
     * curl -v http://localhost:8080/bean?object_string=badMessage
     */
    @GET
    @Path("/bean")
    @Produces("application/json")
    public String test(@BeanParam final BeanParamObject beanParamObject) {
        return "hello bean param object " + beanParamObject.getModelObject().toString();
    }
}
