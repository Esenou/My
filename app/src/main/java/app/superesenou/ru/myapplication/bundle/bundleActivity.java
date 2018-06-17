package app.superesenou.ru.myapplication.bundle;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import app.superesenou.ru.myapplication.R;
import app.superesenou.ru.myapplication.activity.MainActivity;
import app.superesenou.ru.myapplication.activity.Movi_Main_Activity;
import app.superesenou.ru.myapplication.model.Contact;

public class bundleActivity extends AppCompatActivity {
    private TextView kino_id;
    private TextView kino_name;
    private TextView kino_url;
    private TextView kino_vote;
    private TextView kino_vote_count;
    private TextView kino_phone;
    private TextView kino_address;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_main);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setUpUIViews();

        Bundle bundle =getIntent().getExtras();
        if (bundle!=null){
            String json =bundle.getString("Kinoteatr");
            Contact unmain = new Gson().fromJson(json,Contact .class);
            kino_id.setText("");
            kino_name.setText(unmain.getName());
            kino_url.setText("https://kinoafisha.ua/"+unmain.getUrl());
            kino_vote.setText(unmain.getVote());
            kino_vote_count.setText(unmain.getCount_vote());
            kino_phone.setText(unmain.getPhone());
            kino_address.setText(unmain.getAddress());
            Picasso.get().load("https://kinoafisha.ua/"+unmain.getImage()).into(imageView);
        }
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
      /*  switch (item.getItemId()){
            case R.id.movies:
                startActivity(new Intent(DetailActivity.this, Movi_Main_Activity.class));
                break;
        }*/
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
        imageView=(ImageView)findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       /* getMenuInflater().inflate(R.menu.mainmenu,menu);*/
        return true;
    }


    public void onClick(View view) {
        if(view.getId()==R.id.button){
        Intent intent= new Intent(bundleActivity.this,Movi_Main_Activity.class);
        startActivity(intent);}
    }
}

