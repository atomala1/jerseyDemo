package demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * The default Jersey config file for this project.  Set Jersey to read from all packages.
 *
 * Created by atomala on 4/4/2015.
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        super();
        packages("demo");
        setApplicationName("Demo Application");
    }
}
