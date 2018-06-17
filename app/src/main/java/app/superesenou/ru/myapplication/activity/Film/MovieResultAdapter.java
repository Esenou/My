package app.superesenou.ru.myapplication.activity.Film;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResultAdapter {
    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("result")
    @Expose
    private ArrayList<MoviesAdapter> result;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<MoviesAdapter> getResult() {
        return result;
    }

    public void setResult(ArrayList<MoviesAdapter> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MovieResultAdapter{" +
                "count=" + count +
                ", result=" + result +
                '}';
    }
}
