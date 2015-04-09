package demo.error.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A very boring error message to be sent back to the user.  Immutable.
 *
 * Created by atomala on 4/4/2015.
 */
public class ErrorMessage {

    private final String message;

    private final int status;

    public ErrorMessage(final int status, final String message) {
        this.message = message;
        this.status = status;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public int getStatus() {
        return status;
    }
}
