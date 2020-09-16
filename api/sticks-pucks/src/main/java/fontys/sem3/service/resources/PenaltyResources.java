package fontys.sem3.service.resources;

import fontys.sem3.service.model.Team;
import fontys.sem3.service.model.Account;
import fontys.sem3.service.model.Manager;
import fontys.sem3.service.model.Player;
import fontys.sem3.service.model.Penalty;

import fontys.sem3.service.repository.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/penalty")
public class PenaltyResources {

    @Context
    private UriInfo uriInfo;
    // this has to be static because the service is stateless:
    private static final FakeDataStore fakeDataStore = new FakeDataStore();

    @GET //GET at http://localhost:XXXX/penalty
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPenalties() {
        List<Penalty> penalties = fakeDataStore.getAllPenalties();
        GenericEntity<List<Penalty>> entity = new GenericEntity<>(penalties) {  };
        return Response.ok(entity).build();
    }
}

