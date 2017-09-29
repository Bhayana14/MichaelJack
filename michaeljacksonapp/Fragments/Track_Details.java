package demo.frap.michaeljacksonapp.Fragments;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.w3c.dom.Text;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import demo.frap.michaeljacksonapp.Interfaces.AddFragmentCallback;
import demo.frap.michaeljacksonapp.R;

/**
 * Created by Ramandeep on 9/27/17.
 */

public class Track_Details extends Fragment {

    View rootView;
    private AddFragmentCallback mListener;
    ImageView artistPic;
    TextView artsitName,trackname,dates,price,genre;
    String month;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.track_detail_fragment, container, false);
            artistPic=(ImageView)rootView.findViewById(R.id.artist_pic);
            artsitName=(TextView)rootView.findViewById(R.id.artist_name);
            trackname=(TextView)rootView.findViewById(R.id.trackName);
            dates=(TextView)rootView.findViewById(R.id.date);
            price=(TextView)rootView.findViewById(R.id.price);
            genre=(TextView)rootView.findViewById(R.id.genrename);


            Bundle arguments = getArguments();
             artsitName.setText(arguments.getString("artistname"));
            trackname.setText(arguments.getString("trackname"));
            price.setText(arguments.getString("price")+" $");
            Picasso.with(getActivity()).load(arguments.getString("artistpic")).into(artistPic);

            genre.setText(arguments.getString("genre"));

            String date = arguments.getString("date");
            String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = null;

            try {
                d = sdf.parse(arguments.getString("date"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Log.e("Date",output.format(d));
            Calendar c = Calendar.getInstance();
            c.setTime(d);
         switch(c.get(Calendar.MONTH))
            {
                case 1:
                    month="Jan";
                    break;
                case 2:
                    month="Feb";
                    break;
                case 3:
                    month="Mar";
                    break;
                case 4:
                    month="Apr";
                    break;
                case 5:
                    month="May";
                    break;
                case 6:
                    month="June";
                    break;
                case 7:
                    month="July";
                    break;
                case 8:
                    month="Aug";
                    break;
                case 9:
                    month="Sep";
                    break;
                case 10:
                    month="Oct";
                    break;
                case 11:
                    month="Nov";
                    break;
                case 12:
                    month="Dec";
                    break;


            }
            dates.setText(c.get(Calendar.DAY_OF_MONTH)+" " +month+","+c.get(Calendar.YEAR));





        }
        return rootView;
    }






    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AddFragmentCallback) {
            mListener = (AddFragmentCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();



    }


}

