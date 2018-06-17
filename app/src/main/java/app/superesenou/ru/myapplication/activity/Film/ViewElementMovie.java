package app.superesenou.ru.myapplication.activity.Film;

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

public class ViewElementMovie extends ArrayAdapter<MoviesAdapter> {
    List<MoviesAdapter> contactList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public ViewElementMovie(Context context, List<MoviesAdapter> objects) {
        super(context,0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public MoviesAdapter getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewElementMovie.ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view_m, parent, false);
            vh = ViewElementMovie.ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewElementMovie.ViewHolder) convertView.getTag();
        }

        MoviesAdapter item = getItem(position);

        vh.textViewName.setText(item.getName());
        vh.textViewEmail.setText("Vote:"+item.getVote());
        Picasso.get().load("https://kinoafisha.ua/"+item.getImage()).into(vh.imageView);
        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewName;
        public final TextView       textViewEmail;

        private ViewHolder(RelativeLayout rootView,ImageView imageView, TextView textViewName, TextView textViewEmail) {
            this.rootView = rootView;
            this.imageView=imageView;
            this.textViewName = textViewName;
            this.textViewEmail = textViewEmail;
        }

        public static ViewElementMovie.ViewHolder create(RelativeLayout rootView) {


            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName1);
            TextView textViewEmail = (TextView) rootView.findViewById(R.id.textViewEmail1);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView1);
            return new ViewElementMovie.ViewHolder(rootView,imageView, textViewName, textViewEmail);
        }

    }
}
