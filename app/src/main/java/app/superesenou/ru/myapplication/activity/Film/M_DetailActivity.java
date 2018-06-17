package app.superesenou.ru.myapplication.activity.Film;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import app.superesenou.ru.myapplication.R;

public class M_DetailActivity extends AppCompatActivity {


    private TextView kino_id;
    private TextView kino_name;
    private TextView kino_url;
    private TextView kino_vote;
    private TextView kino_vote_count;
    private TextView kino_phone;
    private TextView kino_address;
    private TextView kino_rejiser;
    private TextView kino_actors;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setUpUIViews();

        Bundle bundle =getIntent().getExtras();
        if (bundle!=null){
            GetExtras(bundle);
        }


    }

    public void GetExtras(Bundle bundle){

        String json =bundle.getString("Kinoteatr");
        MoviesAdapter unmain = new Gson().fromJson(json,MoviesAdapter.class);



        kino_id.setText("");
        kino_name.setText(unmain.getName());
        kino_url.setText("https://kinoafisha.ua/"+unmain.getUrl());
        kino_vote.setText(unmain.getVote());
        kino_vote_count.setText(unmain.getCount_vote());
        kino_phone.setText(unmain.getCountries());
        kino_address.setText(unmain.getPremier_ua());

        Picasso.get().load("https://kinoafisha.ua/"+unmain.getImage()).into(imageView);

        kino_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(kino_url.getText().toString()));
                startActivity(browserIntent);
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

    private void setUpUIViews(){
        kino_id=(TextView)findViewById(R.id.kino_id);
        kino_name=(TextView)findViewById(R.id.kino_name);
        kino_url=(TextView)findViewById(R.id.kino_url);
        kino_vote=(TextView)findViewById(R.id.kino_vote);
        kino_vote_count=(TextView)findViewById(R.id.kino_vote_count);
        kino_phone=(TextView)findViewById(R.id.kino_phone);
        kino_address=(TextView)findViewById(R.id.kino_address);
        kino_actors=(TextView)findViewById(R.id.kino_actors);
        kino_rejiser=(TextView)findViewById(R.id.kino_rejiser);
        imageView=(ImageView)findViewById(R.id.imageView);
    }

}
