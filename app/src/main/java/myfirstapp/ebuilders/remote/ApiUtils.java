package myfirstapp.ebuilders.remote;

/**
 * Created by acer on 12/22/2017.
 */

public class ApiUtils {
    private ApiUtils() {}
    public static final String BASE_URL= "http://localhost:61356/Help/Api";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
