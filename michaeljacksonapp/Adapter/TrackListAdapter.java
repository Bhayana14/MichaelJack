package demo.frap.michaeljacksonapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.frap.michaeljacksonapp.Model.TrackListModel;
import demo.frap.michaeljacksonapp.R;

/**
 * Created by Ramandeep on 9/27/17.
 */

public class TrackListAdapter extends BaseAdapter {
    List<TrackListModel> data;
    TrackListModel model;
    Context context;
    int i=0;
    MediaPlayer mediaplayer;

    public TrackListAdapter(List<TrackListModel> data)
    {
        this.data = data;
    }

    @Override
    public int getCount()
    {
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //View view = convertView;
        final TrackListAdapter.ViewHolder holder;
        model = (TrackListModel)getItem(position);



        if (convertView == null) {
            context=parent.getContext();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null);
            holder=new TrackListAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
            holder.play_stop.setTag(position);
            mediaplayer = new MediaPlayer();
            mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        } else {
            holder = (TrackListAdapter.ViewHolder) convertView.getTag();
        }

        /*holder.accessory_FTD.setText(data.get(position).accessory_FTD);
        holder.accessory_MTD.setText(data.get(position).accessory_MTD);
        holder.accessory_QTD.setText(data.get(position).accessory_QTD);
        holder.accessory_model.setText(data.get(position).accessor_Model);

*/
        try {


            holder.trackName.setText(model.getTrackName());
            holder.artistName.setText(model.getArtistName());
            Picasso.with(context).load(model.getArtistPic()).into(holder.artistPic);
            holder.play_stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(context,"Playing Media...",Toast.LENGTH_SHORT).show();



                            mediaplayer.reset();
                            mediaplayer.stop();
                            mediaplayer.release();







                        try {


                            mediaplayer = new MediaPlayer();
                            mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                            mediaplayer.setDataSource(model.getSong());
                            mediaplayer.prepare();


                        } catch (IllegalArgumentException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (SecurityException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        mediaplayer.start();










                }
            });



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }





        return convertView;
    }

    public class ViewHolder
    {


        TextView trackName;
        public TextView artistName;
        public com.mikhaellopez.circularimageview.CircularImageView artistPic;
        ImageView play_stop;



        public ViewHolder(View view)

        {

           trackName=(TextView)view.findViewById(R.id.track_name);
            artistName=(TextView)view.findViewById(R.id.artist_name);
            artistPic=(com.mikhaellopez.circularimageview.CircularImageView)view.findViewById(R.id.artist_pic);
            play_stop=(ImageView)view.findViewById(R.id.play_stop);





        }


    }
}
