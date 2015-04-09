package demo.converter;

import demo.error.exception.BadParameterException;
import demo.model.ModelObject;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * A parameter converter to convert from a string to a ModelObject object.
 * If "badMessage" is passed in, it will throw a BadParameterException.
 *
 * Created by atomala on 4/4/2015.
 */
@Provider
public class ModelObjectParamConverter
        implements ParamConverter<ModelObject>, ParamConverterProvider {

    @Override
    public ModelObject fromString(final String s) {
        if ("badMessage".equalsIgnoreCase(s)) {
            throw new BadParameterException("This parameter was not found");
        }
        return new ModelObject(s);
    }

    @Override
    public String toString(ModelObject modelObject) {
        return modelObject.toString();
    }

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> aClass, Type type, Annotation[] annotations) {
        return aClass.getName().equals(ModelObject.class.getName()) ? (ParamConverter<T>) this : null;
    }
}
