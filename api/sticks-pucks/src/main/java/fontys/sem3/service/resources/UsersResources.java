package fontys.sem3.service.resources;


import fontys.sem3.service.model.Account;
import fontys.sem3.service.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/account")
public class UsersResources {

    @Context
    private UriInfo uriInfo;
    // this has to be static because the service is stateless:
    private static final FakeDataStore fakeDataStore = new FakeDataStore();

    @GET //GET at http://localhost:XXXX/account/3
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserPath(@PathParam("id") int id) {
        Account account = fakeDataStore.getUser(id);
        if (account == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            return Response.ok(account).build();
        }
    }

    @GET //GET at http://localhost:XXXX/account
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<Account> users = fakeDataStore.getUsers();
        GenericEntity<List<Account>> entity = new GenericEntity<>(users) {  };
        return Response.ok(entity).build();
    }

    @DELETE //DELETE at http://localhost:XXXX/account/3
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int stNr) {
        fakeDataStore.deleteUser(stNr);
        // Idempotent method. Always return the same response (even if the resource has already been deleted before).
        return Response.noContent().build();
    }

    // TODO: test that
    @POST //POST at http://localhost:XXXX/account/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(Account account) {
        if (!fakeDataStore.add(account)){
            String entity =  "Account with id " + account.getId() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
            String url = uriInfo.getAbsolutePath() + "/" + account.getId(); // url of the created account
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }

    // TODO: test that
    @PUT //PUT at http://localhost:XXXX/account/
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAccount(Account account) {
        if (fakeDataStore.update(account)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }

    // TODO: test that
    @PUT //PUT at http://localhost:XXXX/account/{id}
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Path("{id}")
    public Response updateUser(@PathParam("id") int id,  @FormParam("name") String name) {
        Account account = fakeDataStore.getUser(id);
        if (account == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }

        account.setName(name);
        return Response.noContent().build();
    }
}

