package demo.frap.michaeljacksonapp.Fragments;


import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.frap.michaeljacksonapp.Adapter.TrackListAdapter;
import demo.frap.michaeljacksonapp.Interfaces.AddFragmentCallback;
import demo.frap.michaeljacksonapp.Model.TrackListModel;
import demo.frap.michaeljacksonapp.R;

/**
 * Created by Ramandeep on 9/27/17.
 */

public class Track_List extends Fragment {
    View rootView;
    private AddFragmentCallback mListener;
    String url="https://itunes.apple.com/search?term=Michael+jackson";
    public ArrayList<TrackListModel> track = new ArrayList<TrackListModel>();
    TrackListModel trackListModel;

    ListView track_list;




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.track_list_fragment, container, false);

            track_list=(ListView)rootView.findViewById(R.id.track_list);
            track_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {



//                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
//                    ft.replace(R.id.mFragmentContainer, trackDetail , "TrackDetail");
//                    ft.commit();

                    Track_Details trackDetail = new Track_Details();
                    Bundle arguments = new Bundle();
                    arguments.putString( "genre" , track.get(position).getPrimaryGenreName());
                    arguments.putString( "trackname" , track.get(position).getTrackName());
                    arguments.putString( "artistname" , track.get(position).getArtistName());
                    arguments.putString( "artistpic" , track.get(position).getArtistPic());
                    arguments.putString( "date" , track.get(position).getReleaseDate());
                    arguments.putString("price",track.get(position).getTrackPrice());
                    trackDetail.setArguments(arguments);

                    mListener.replaceFragment(trackDetail, true, "TrackDetail", "TrackDetail");
                }

            });
            displayData();





        }
        return rootView;
    }

    private void displayData() {

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray obj = response.getJSONArray("results");

                            if ((obj != null && !(obj.equals("null"))) && !(obj.equals("")))
                            {

                                for (int i=0;i<obj.length();i++)
                                {
                                    TrackListModel trackListModel = new TrackListModel();
                                    try {
                                        JSONObject jsonObject= obj.getJSONObject(i);
                                        trackListModel.setArtistName(jsonObject.getString("artistName"));
                                        trackListModel.setTrackName(jsonObject.getString("trackName"));
                                        trackListModel.setArtistPic(jsonObject.getString("artworkUrl100"));
                                        trackListModel.setSong(jsonObject.getString("previewUrl"));
                                        trackListModel.setTrackPrice(jsonObject.getString("trackPrice"));
                                        trackListModel.setPrimaryGenreName(jsonObject.getString("primaryGenreName"));
                                        trackListModel.setReleaseDate(jsonObject.getString("releaseDate"));

                                    } catch (JSONException e)
                                    {
                                        e.printStackTrace();
                                    }

                                    track.add(trackListModel);


                                }

                                track_list.setAdapter(new TrackListAdapter(track));



                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );


        queue.add(getRequest);


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
