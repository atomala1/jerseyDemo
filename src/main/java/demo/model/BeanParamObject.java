package demo.model;

import javax.ws.rs.QueryParam;

/**
 * A BeanParameter object that only has one query param for right now.
 *
 * Created by atomala on 4/4/2015.
 */
public class BeanParamObject {

    final ModelObject modelObject;

    /**
     * Notice that this has the same parameters as the /query endpoint
     */
    public BeanParamObject(@QueryParam("object_string") final ModelObject modelObject) {
        this.modelObject = modelObject;
    }

    public ModelObject getModelObject() {
        return modelObject;
    }
}
