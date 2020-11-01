package fontys.sem3.service.resources;

import fontys.sem3.service.model.Team;
import fontys.sem3.service.model.Player;
import fontys.sem3.service.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/team")
public class TeamResources {

    @Context
    private UriInfo uriInfo;
    // this has to be static because the service is stateless:
    private static final DataStore dataStore = new DataStore();

    @GET //GET at http://localhost:XXXX/team
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTeams() {
        List<Team> teams = dataStore.getTeams();
        GenericEntity<List<Team>> entity = new GenericEntity<>(teams) {  };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/team
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getManagerPath(@PathParam("id") int id) {
        Team team = dataStore.getTeam(id);
        if (team == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            return Response.ok(team).build();
        }
    }


    @GET //GET at http://localhost:XXXX/team
    @Path("{id}/captain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCaptainPath(@PathParam("id") int id) {
        Team team = dataStore.getTeam(id);
        if (team == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            Player captain = team.getCaptain();
            return Response.ok(captain).build();
        }
    }

    @DELETE //DELETE at http://localhost:XXXX/team/3/captain
    @Path("{id}/captain")
    public Response deleteCaptain(@PathParam("id") int id) {
        Team team = dataStore.getTeam(id);
        dataStore.deleteCaptain(team);
        return Response.noContent().build();
    }

    @DELETE //DELETE at http://localhost:XXXX/team/3/captain
    @Path("{id}/assistants")
    public Response deleteAsssistants(@PathParam("id") int id) {
        Team team = dataStore.getTeam(id);
        dataStore.deleteAssistants(team);
        return Response.noContent().build();
    }

    @DELETE //DELETE at http://localhost:XXXX/team/3/captain
    @Path("{id}/leadplayers")
    public Response deleteLeadPlayers(@PathParam("id") int id) {
        Team team = dataStore.getTeam(id);
        dataStore.deleteLeadPlayers(team);
        return Response.noContent().build();
    }

    @GET //GET at http://localhost:XXXX/team
    @Path("{id}/asistants")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAsistantsPath(@PathParam("id") int id) {
        Team team = dataStore.getTeam(id);
        if (team == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            List<Player> assistants = team.getAssistants();
            return Response.ok(assistants).build();
        }
    }

    @GET //GET at http://localhost:XXXX/leadplayers
    @Path("{id}/leadplayers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeadPlayersPath(@PathParam("id") int id) {
        Team team = dataStore.getTeam(id);
        if (team == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid id.").build();
        } else {
            List<Player> leadplayers = team.getLeadPlayers();
            return Response.ok(leadplayers).build();
        }
    }

    @GET //GET at http://localhost:XXXX/team
    @Path("{id}/roster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayersPath(@PathParam("id") int id) {
        Team team = dataStore.getTeam(id);
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
        if (!dataStore.add(team)){
            String entity =  "Team with id " + team.getId() + " already exists.";
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
        if (dataStore.update(team)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Please provide a valid id.").build();
        }
    }
}

