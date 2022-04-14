package Server;

import java.util.ArrayList;
import java.util.List;

import Model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @GET("users")
    Call<ArrayList<User>> getUsers();
}
