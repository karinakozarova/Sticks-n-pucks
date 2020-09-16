package fontys.sem3.service.resources;


import fontys.sem3.service.model.Account;
import fontys.sem3.service.model.Manager;
import fontys.sem3.service.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/account/manager")
public class ManagersResources {

    @Context
    private UriInfo uriInfo;
    // this has to be static because the service is stateless:
    private static final FakeDataStore fakeDataStore = new FakeDataStore();

    @GET //GET at http://localhost:XXXX/account/manager
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllManagers() {
        List<Manager> managers = fakeDataStore.getManagers();
        GenericEntity<List<Manager>> entity = new GenericEntity<>(managers) {  };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/account/manager/3
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getManagerPath(@PathParam("id") int id) {
        Manager account = fakeDataStore.getManager(id);
        if (account == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            return Response.ok(account).build();
        }
    }

    @DELETE //DELETE at http://localhost:XXXX/account/manager/3
    @Path("{id}")
    public Response deleteUser(@PathParam("id") int id) {
        fakeDataStore.deleteManager(id);
        return Response.noContent().build();
    }

    // TODO: test that
    @POST //POST at http://localhost:XXXX/account/manager/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(Manager account) {
        if (!fakeDataStore.add(account)){
            String entity =  "Account with id " + account.getAccount_id() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
            String url = uriInfo.getAbsolutePath() + "/" + account.getAccount_id(); // url of the created account
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }

    // TODO: test that
    @PUT //PUT at http://localhost:XXXX/account/manager
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAccount(Manager account) {
        if (fakeDataStore.update(account)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }

    // TODO: test that
    // TODO: fix the parameters here
    @PUT //PUT at http://localhost:XXXX/account/manager/{id}
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Path("{id}")
    public Response updateUser(@PathParam("id") int id,  @FormParam("name") String name) {
        Manager account = fakeDataStore.getManager(id);
        if (account == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }

        // TODO: set the fields here like for example: account.setName(name);
        return Response.noContent().build();
    }
}

