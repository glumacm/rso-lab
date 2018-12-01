package si.fri.rso.uberapp.users.api;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("users")
@ApplicationScoped
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

    @GET
    @Path("info")
    public Response info() {

        JsonObject json = Json.createObjectBuilder()
                .add("clani", Json.createArrayBuilder().add("mg5331"))
                .add("opis_projekta", "Aplikacija za namen iskanja in ponujanja prevozov. Ponudnik storitev ponudi svoj prevoz na neki začetki točki in sopotniki se pridružijo temu prevozu, če jih prevoznih sprejme. ")
                .add("mikrostoritve", Json.createArrayBuilder().add("http://35.204.91.158:8081/v1/orders"))
                .add("github", Json.createArrayBuilder().add("https://github.com/RSO-vaje-prevozi-2018-2019/uberapp"))
                .add("travis", Json.createArrayBuilder().add("https://travis-ci.com/RSO-vaje-prevozi-2018-2019/uberapp"))
                .add("dockerhub", Json.createArrayBuilder().add("https://hub.docker.com/r/glumac/uberapp/"))
                .build();


        return Response.ok(json.toString()).build();
    }

}
