package fontys.sem3.service.resources;

import fontys.sem3.service.model.Game;
import fontys.sem3.service.model.Team;
import fontys.sem3.service.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/games")
public class GameResources {

    @Context
    private UriInfo uriInfo;
    // this has to be static because the service is stateless:
    private static final DataStore dataStore = new DataStore();

    @GET //GET at http://localhost:XXXX/team
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGames() {
        List<Game> games = dataStore.getGames();
        GenericEntity<List<Game>> entity = new GenericEntity<>(games) {
        };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/team
    @Path("/team/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeamGames(@PathParam("name") String teamName) {
        List<Game> games = dataStore.getGames(teamName);
        if (games == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid team name.").build();
        } else {
            return Response.ok(games).build();
        }
    }

}

