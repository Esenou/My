package app.superesenou.ru.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.google.gson.Gson;

import java.util.ArrayList;

import app.superesenou.ru.myapplication.R;
import app.superesenou.ru.myapplication.activity.Film.M_Api;
import app.superesenou.ru.myapplication.activity.Film.M_DetailActivity;
import app.superesenou.ru.myapplication.activity.Film.MovieResultAdapter;
import app.superesenou.ru.myapplication.activity.Film.MoviesAdapter;
import app.superesenou.ru.myapplication.activity.Film.ViewElementMovie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Movi_Main_Activity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String BASE_UEL="https://kinoafisha.ua/";
    ListView listView;
    View parentView;
    ArrayList<MoviesAdapter> contactList;
    ViewElementMovie adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        listView=(ListView)findViewById(R.id.listview1);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_UEL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        M_Api redditAPI =retrofit.create(M_Api.class);

        Call<MovieResultAdapter> call =redditAPI.getData();

        call.enqueue(new Callback<MovieResultAdapter>() {
            @Override
            public void onResponse(Call<MovieResultAdapter> call, Response<MovieResultAdapter> response) {

                final ArrayList<MoviesAdapter> list =response.body().getResult();

                contactList = response.body().getResult();

                /**
                 * Binding that List to Adapter
                 */
                adapter = new ViewElementMovie(Movi_Main_Activity.this, contactList);

                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        MoviesAdapter movies = list.get(i);
                        Intent intent= new Intent(Movi_Main_Activity.this,M_DetailActivity.class);
                        intent.putExtra("Kinoteatr",new Gson().toJson(movies));
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onFailure(Call<MovieResultAdapter> call, Throwable t) {
                Log.e(TAG,"onFailure"+t.getMessage());
                Toast.makeText(Movi_Main_Activity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return true;
    }
}
