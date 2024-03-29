package uk.co.uclan.wvitz.iss.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import uk.co.uclan.wvitz.iss.DT.Image;
import uk.co.uclan.wvitz.iss.R;


public class ObservationImageAdapter extends RecyclerView.Adapter<ObservationImageAdapter.MyViewHolder> {

    private List<byte[]> imageList;
    private final String TAG = "ObservationImageAdapter";


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public View viewL;

        public MyViewHolder(View view) {
            super(view);
            this.viewL = view;
            imageView = view.findViewById(R.id.iv_observation);
        }
    }


    public ObservationImageAdapter(List<byte[]> imageList) {
        this.imageList = imageList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_observation_image, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        byte[] image = imageList.get(position);

        Log.i(TAG, "Adding image Array size " + imageList.size() );

        Glide.with(holder.viewL).load(image).into(holder.imageView);

    }



    @Override
    public int getItemCount() {
        return imageList.size();
    }
}