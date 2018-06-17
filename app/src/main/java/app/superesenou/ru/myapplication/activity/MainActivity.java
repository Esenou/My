package app.superesenou.ru.myapplication.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.google.gson.Gson;

import java.util.ArrayList;

import app.superesenou.ru.myapplication.R;
import app.superesenou.ru.myapplication.adapter.ContactAdapter;
import app.superesenou.ru.myapplication.api.ApiService;
import app.superesenou.ru.myapplication.api.RetroClient;
import app.superesenou.ru.myapplication.bundle.bundleActivity;
import app.superesenou.ru.myapplication.model.Contact;
import app.superesenou.ru.myapplication.model.Result;
import app.superesenou.ru.myapplication.utils.InternetConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private View     parentView;

    private ArrayList<Contact> contactList;
    private ContactAdapter adapter;
    private ArrayList<Contact> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactList = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact Kinoteatrs = list.get(i);
                Intent intent= new Intent(MainActivity.this,bundleActivity.class);
                intent.putExtra("Kinoteatr",new Gson().toJson(Kinoteatrs));
                startActivity(intent);

            }
        });


                /**
                 * Checking Internet Connection
                 */
                if (InternetConnection.checkConnection(getApplicationContext())) {
                    final ProgressDialog dialog;
                    /**
                     * Progress Dialog for User Interaction
                     */
                    dialog = new ProgressDialog(MainActivity.this);
                    dialog.setTitle(getString(R.string.string_getting_json_title));
                    dialog.setMessage(getString(R.string.string_getting_json_message));
                    dialog.show();

                    //Creating an object of our api interface
                    ApiService api = RetroClient.getApiService();

                    /**
                     * Calling JSON
                     */
                    Call<Result> call = api.getMyJSON();

                    /**
                     * Enqueue Callback will be call when get response...
                     */
                    call.enqueue(new Callback<Result>() {
                        @Override
                        public void onResponse(Call<Result> call, Response<Result> response) {
                            //Dismiss Dialog
                            dialog.dismiss();

                            if (response.isSuccessful()) {
                                /**
                                 * Got Successfully
                                 */
                                list =response.body().getResult().getUnmain();
                                contactList = response.body().getResult().getUnmain();

                                /**
                                 * Binding that List to Adapter
                                 */
                                adapter = new ContactAdapter(MainActivity.this, contactList);
                                listView.setAdapter(adapter);

                            } else {
                                Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Result> call, Throwable t) {
                            dialog.dismiss();
                        }
                    });

                } else {
                    Snackbar.make(parentView, R.string.string_internet_connection_not_available, Snackbar.LENGTH_LONG).show();
                }
            }


    }
