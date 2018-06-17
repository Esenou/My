package app.superesenou.ru.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import app.superesenou.ru.myapplication.R;
import app.superesenou.ru.myapplication.model.Contact;

/**
 * Project: RetrofitJson
 * Created: Vendetta
 * Date: 12.11.2016
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    List<Contact> contactList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public ContactAdapter(Context context, List<Contact> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public Contact getItem(int position) {

        return contactList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Contact item = getItem(position);

        vh.textViewName.setText(item.getName());

        Picasso.get().load("https://kinoafisha.ua/"+item.getImage()).into(vh.imageView);


        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewName;


        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewName = textViewName;

        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            return new ViewHolder(rootView, imageView, textViewName);
        }

    }

}
