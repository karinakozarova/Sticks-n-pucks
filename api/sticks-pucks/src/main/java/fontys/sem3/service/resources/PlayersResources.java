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
    private static final DataStore dataStore = new DataStore();

    @GET //GET at http://localhost:XXXX/account/player
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlayers() {
        List<Player> players = dataStore.getPlayers();
        GenericEntity<List<Player>> entity = new GenericEntity<>(players) {
        };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/account/player/3
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerPath(@PathParam("id") int id) {
        Player account = dataStore.getPlayer(id);
        if (account == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(Constants.VALID_ID_MESSAGE).build();
        } else {
            return Response.ok(account).build();
        }
    }

    @POST //POST at http://localhost:XXXX/account/player/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlayerAccount(Player player) {
        if (!dataStore.add(player)) {
            String entity = "Player with id " + player.getAccountId() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
            String url = uriInfo.getAbsolutePath() + "/" + player.getAccountId(); // url of the created account
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }

    @PUT //PUT at http://localhost:XXXX/account/player
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updatePlayerAccount(Player account) {
        if (dataStore.update(account)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(Constants.VALID_ID_MESSAGE).build();
        }
    }

    @PUT //PUT at http://localhost:XXXX/account/player/id
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Path("{id}")
    public Response updateUser(@PathParam("id") int id, @FormParam("name") String name) {
        Player account = dataStore.getPlayer(id);
        if (account == null) {
            return Response.status(Response.Status.NOT_FOUND).entity(Constants.VALID_ID_MESSAGE).build();
        }

        // set the things here
        return Response.noContent().build();
    }
}