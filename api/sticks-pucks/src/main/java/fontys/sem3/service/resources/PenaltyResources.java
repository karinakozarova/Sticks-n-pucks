package fontys.sem3.service.resources;

import fontys.sem3.service.model.Penalty;

import fontys.sem3.service.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/penalty")
public class PenaltyResources {

    @Context
    private UriInfo uriInfo;
    // this has to be static because the service is stateless:
    private static final DataStore dataStore = new DataStore();

    @GET //GET at http://localhost:XXXX/penalty
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPenalties() {
        List<Penalty> penalties = dataStore.getAllPenalties();
        GenericEntity<List<Penalty>> entity = new GenericEntity<>(penalties) {  };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/team
    @Path("{name}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPenalitesPath(@PathParam("name") String name) {
        Penalty penalty = dataStore.getPenalty(name);
        if (penalty == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid penalty name.").build();
        } else {
            return Response.ok(penalty).build();
        }
    }
}

