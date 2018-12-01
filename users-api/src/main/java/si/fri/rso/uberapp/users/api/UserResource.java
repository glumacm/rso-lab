package si.fri.rso.uberapp.users.api;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("users")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserService userBean;

    @GET
    public Response getAllUsers(){
        List<User> users = userBean.getUsers();
        return Response.ok(users).build();
    }

    @GET
    @Path("{userId}")
    public Response getUser(@PathParam("userId") String userId){
        User user = userBean.getUser(userId);
        return user != null
                ? Response.ok(user).build()
                : Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @GET
    @Path("users")
    public Response getUsers(){
        return getAllUsers();
    }

}
