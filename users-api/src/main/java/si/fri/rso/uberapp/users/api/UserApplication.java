package si.fri.rso.uberapp.users.api;

import com.kumuluz.ee.discovery.annotations.RegisterService;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@RegisterService
@ApplicationPath("/")
public class UserApplication extends Application {
}
