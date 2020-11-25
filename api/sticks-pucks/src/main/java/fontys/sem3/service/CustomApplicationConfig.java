package fontys.sem3.service;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomApplicationConfig extends ResourceConfig
{
	public CustomApplicationConfig()
	{
		packages("fontys.sem3.service.resources"); // find all resource endpoint classes in this package
		// log exchanged http messages
		register(AuthenticationFilter.class);
		register(CORSFilter.class);
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
				Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, LoggingFeature.DEFAULT_MAX_ENTITY_SIZE));
	}
}
