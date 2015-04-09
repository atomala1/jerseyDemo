package demo.error.exception;

/**
 * An very not filled out exception used for checking if a bad parameter was passed in.
 *
 * Created by atomala on 4/4/2015.
 */
public class BadParameterException
    extends RuntimeException
{
    public BadParameterException (final String s) {
        super(s);
    }
}
