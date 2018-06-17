package app.superesenou.ru.myapplication.activity.Film;

import retrofit2.Call;
import retrofit2.http.GET;

public interface M_Api {
    @GET("ajax/kinoafisha_load")
    Call<MovieResultAdapter> getData();
}
