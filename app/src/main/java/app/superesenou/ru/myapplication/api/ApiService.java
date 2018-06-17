package app.superesenou.ru.myapplication.api;


import app.superesenou.ru.myapplication.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
 
    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    //@GET("/lessons/retrofit-json/json_data.json")
    @GET("ajax/kinoteatrs_load")
    Call<Result> getMyJSON();
}