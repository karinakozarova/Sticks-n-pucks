package fontys.sem3.service.resources;

import javax.annotation.security.RolesAllowed;

import fontys.sem3.service.model.Account;
import fontys.sem3.service.repository.*;

import fontys.sem3.service.model.UserRoles;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/account")
public class UsersResources {
    private static final String DEFAULT_ERROR_MESSAGE = Constants.VALID_ID_MESSAGE;

    @Context
    private UriInfo uriInfo;
    // this has to be static because the service is stateless:
    private static final DataStore dataStore = new DataStore();

    @GET //GET at http://localhost:XXXX/account/3
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserPath(@PathParam("id") int id) {
        Account account = dataStore.getUser(id);
        if (account == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(DEFAULT_ERROR_MESSAGE).build();
        } else {
            return Response.ok(account).build();
        }
    }

    @GET //GET at http://localhost:XXXX/account
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({ "MANAGER", "PLAYER" })
    public Response getAllUsers() {
        List<Account> users = dataStore.getUsers();
        GenericEntity<List<Account>> entity = new GenericEntity<>(users) {  };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/account
    @Path("testManager")
    @RolesAllowed({ "MANAGER" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response testm() {
        List<Account> users = dataStore.getUsers();
        GenericEntity<List<Account>> entity = new GenericEntity<>(users) {  };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/account
    @Path("testFan")
    @RolesAllowed({ "FAN" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response testf() {
        List<Account> users = dataStore.getUsers();
        GenericEntity<List<Account>> entity = new GenericEntity<>(users) {  };
        return Response.ok(entity).build();
    }

    @DELETE //DELETE at http://localhost:XXXX/account/3
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int stNr) {
        dataStore.deleteUser(stNr);
        // Idempotent method. Always return the same response (even if the resource has already been deleted before).
        return Response.noContent().build();
    }

    @POST //POST at http://localhost:XXXX/account/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(Account account) {
        if (!dataStore.add(account)){
            String entity =  "Account with id " + account.getId() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
            String url = uriInfo.getAbsolutePath() + "/" + account.getId(); // url of the created account
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }

    @POST
    @Path("{name}/{email}")
    public Response updateUser(@PathParam("name") String name, @PathParam("email") String email) {
       // Account account = new Account(name, email);
       // dataStore.add(account);
        return Response.noContent().build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Path("{id}/{name}")
    public Response updateUser(@PathParam("id") int id,  @PathParam("name") String name) {
       // Account account = dataStore.getUser(id);
//        if (account == null){
//            return Response.status(Response.Status.NOT_FOUND).entity(DEFAULT_ERROR_MESSAGE).build();
//        }

        // account.setName(name);
        return Response.noContent().build();
    }
}

