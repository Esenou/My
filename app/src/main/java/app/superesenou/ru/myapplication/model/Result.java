package app.superesenou.ru.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result  {

    @SerializedName("result")
    @Expose
    protected ContactList result;

    public ContactList getResult() {
        return result;
    }

    public void setResult(ContactList result) {
        this.result = result;
    }

    @SerializedName("count")
    @Expose
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
