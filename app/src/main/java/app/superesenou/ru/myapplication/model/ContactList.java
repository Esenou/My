package app.superesenou.ru.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ContactList {
 
    @SerializedName("unmain")
    @Expose
    private ArrayList<Contact> unmain = new ArrayList<>();
 
    /**
     * @return The contacts
     */
    public ArrayList<Contact> getUnmain() {
        return unmain;
    }

    public void setUnmain(ArrayList<Contact> unmain) {
        this.unmain = unmain;
    }
}