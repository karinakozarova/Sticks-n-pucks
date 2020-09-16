package fontys.sem3.service.resources;

import fontys.sem3.service.model.Game;
import fontys.sem3.service.model.Team;
import fontys.sem3.service.model.Player;
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
    private static final FakeDataStore fakeDataStore = new FakeDataStore();

    @GET //GET at http://localhost:XXXX/team
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGames() {
        List<Game> games = fakeDataStore.getGames();
        GenericEntity<List<Game>> entity = new GenericEntity<>(games) {
        };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/team
    @Path("/team/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeamGames(@PathParam("name") String teamName) {
        List<Game> games = fakeDataStore.getGames(teamName);
        if (games == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid team name.").build();
        } else {
            return Response.ok(games).build();
        }
    }


    @GET //GET at http://localhost:XXXX/team
    @Path("{id}/captain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCaptainPath(@PathParam("id") int id) {
        Team team = fakeDataStore.getTeam(id);
        if (team == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            Player captain = team.getCaptain();
            return Response.ok(captain).build();
        }
    }

    @GET //GET at http://localhost:XXXX/team
    @Path("{id}/asistants")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAsistantsPath(@PathParam("id") int id) {
        Team team = fakeDataStore.getTeam(id);
        if (team == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            List<Player> assistants = team.getAssistants();
            return Response.ok(assistants).build();
        }
    }

    @GET //GET at http://localhost:XXXX/team
    @Path("{id}/roster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayersPath(@PathParam("id") int id) {
        Team team = fakeDataStore.getTeam(id);
        if (team == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            List<Player> players = team.getPlayers();
            return Response.ok(players).build();
        }
    }

    // TODO: test that
    @POST //POST at http://localhost:XXXX/team/
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(Team team) {
        if (!fakeDataStore.add(team)) {
            String entity = "Team with id " + team.getId() + " already exists.";
            return Response.status(Response.Status.CONFLICT).entity(entity).build();
        } else {
            String url = uriInfo.getAbsolutePath() + "/" + team.getId();
            URI uri = URI.create(url);
            return Response.created(uri).build();
        }
    }

    // TODO: test that
    @PUT //PUT at http://localhost:XXXX/account/
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAccount(Team team) {
        if (fakeDataStore.update(team)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }
}

