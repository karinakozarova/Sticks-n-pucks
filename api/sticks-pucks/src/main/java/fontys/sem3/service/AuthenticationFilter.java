package fontys.sem3.service;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import fontys.sem3.service.model.UserRoles;

import com.sun.jersey.core.util.Base64;

public class AuthenticationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String auth = requestContext.getHeaderString("authorization");
		// String auth = requestContext.getSecurityContext().BASIC_AUTH;
		//String auth = "Basic dGVzdDp0ZXN0";
		if(auth != null && !auth.isEmpty()) {
			String[] parts = auth.split(" ");
			String namepwd = new String(Base64.decode(parts[1].getBytes()));
			String[] cred = namepwd.split(":");
			// fetch email / password & role from db

			if ("test".equals(cred[0]) && "test".equals(cred[1])) {
				// let the request through
 				Method method = resourceInfo.getResourceMethod();
				String userRole = UserRoles.MANAGER.name();

				if (method.isAnnotationPresent(RolesAllowed.class)) {
					RolesAllowed annotation = method.getAnnotation(RolesAllowed.class);
					String[] roles = annotation.value();
					if (roles[0].equals(userRole)) {
						return;
					} else if (roles[1].equals(userRole)) {
						return;
					} else {
						requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).entity("Access to object denied").build());
					}
				}
			}
		} else {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build());
		}
	}

}
