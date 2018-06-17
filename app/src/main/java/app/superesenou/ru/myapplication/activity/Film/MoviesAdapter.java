package app.superesenou.ru.myapplication.activity.Film;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoviesAdapter {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("vote")
    @Expose
    private String vote;

    @SerializedName("count_vote")
    @Expose
    private String count_vote;

    @SerializedName("countries")
    @Expose
    private String countries;

    @SerializedName("premier_ua")
    @Expose
    private String premier_ua;

    @SerializedName("actors")
    @Expose
    private String actors;

    @SerializedName("rejisser")
    @Expose
    private String rejisser;


    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRejisser() {
        return rejisser;
    }

    public void setRejisser(String rejisser) {
        this.rejisser = rejisser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getCount_vote() {
        return count_vote;
    }

    public void setCount_vote(String count_vote) {
        this.count_vote = count_vote;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getPremier_ua() {
        return premier_ua;
    }

    public void setPremier_ua(String premier_ua) {
        this.premier_ua = premier_ua;
    }

    public void setName(String name) {
        this.name = name;

    }
    @Override
    public String toString() {
        return "MoviesAdapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", vote='" + vote + '\'' +
                ", count_vote='" + count_vote + '\'' +
                ", countries='" + countries + '\'' +
                ", premier_ua='" + premier_ua + '\'' +
                ", actors='" + actors + '\'' +
                ", rejisser='" + rejisser + '\'' +
                '}';
    }
}
