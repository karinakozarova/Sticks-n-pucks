package fontys.sem3.service.resources;

import fontys.sem3.service.model.Player;
import fontys.sem3.service.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/account/player")
public class PlayersResources {

    @Context
    private UriInfo uriInfo;
    // this has to be static because the service is stateless:
    private static final FakeDataStore fakeDataStore = new FakeDataStore();

    @GET //GET at http://localhost:XXXX/account/player
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlayers() {
        List<Player> players = fakeDataStore.getPlayers();
        GenericEntity<List<Player>> entity = new GenericEntity<>(players) {
        };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/account/player/3
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerPath(@PathParam("id") int id) {
        Player account = fakeDataStore.getPlayer(id);
        if (account == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            return Response.ok(account).build();
        }
    }

    // TODO: test that
    @POST //POST at http://localhost:XXXX/account/player/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(Player account) {
        if (!fakeDataStore.add(account)) {
            String entity = "Account with id " + account.getAccount_id() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
            String url = uriInfo.getAbsolutePath() + "/" + account.getAccount_id(); // url of the created account
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }

    // TODO: test that
    @PUT //PUT at http://localhost:XXXX/account/player
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAccount(Player account) {
        if (fakeDataStore.update(account)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }

    // TODO: test that
    @PUT //PUT at http://localhost:XXXX/account/player/id
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Path("{id}")
    public Response updateUser(@PathParam("id") int id, @FormParam("name") String name) {
        Player account = fakeDataStore.getPlayer(id);
        if (account == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }

        // TODO: set the things
        return Response.noContent().build();
    }
}