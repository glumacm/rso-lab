package si.fri.rso.uberapp.users.api;

import com.kumuluz.ee.discovery.annotations.RegisterService;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@RegisterService
@ApplicationPath("/v1")
public class UserApplication extends Application {
}
