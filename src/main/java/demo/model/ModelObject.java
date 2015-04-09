package demo.model;

/**
 * A ModelObject that represents a business object.  It only contains a string.  Immutable.
 *
 * Created by atomala on 4/4/2015.
 */
public class ModelObject {

    private final String privateData;

    public ModelObject(final String privateData) {
        this.privateData = privateData;
    }

    @Override
    public String toString() {
        return privateData;
    }
}
