package uk.co.uclan.wvitz.iss;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uk.co.uclan.wvitz.iss.DT.Astronaut;
import uk.co.uclan.wvitz.iss.DT.PassTime;

public class PassTimesAdapter extends RecyclerView.Adapter<PassTimesAdapter.MyViewHolder> {

    private List<PassTime> passList;
    private Activity context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView duration, risetime;

        public MyViewHolder(View view) {
            super(view);
            duration = view.findViewById(R.id.duration);
            risetime = view.findViewById(R.id.risetime);
        }
    }


    public PassTimesAdapter(List<PassTime> passList) {
        this.passList = passList;
    }

    public PassTimesAdapter(Activity context) {
        passList = new ArrayList<>();
        this.context = context;
    }

    public void setItems(List<PassTime> items) {
        passList.clear();
        passList.addAll(items);
        this.notifyItemRangeInserted(0, passList.size() - 1);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pass_time_card, parent, false);
        Log.d("Main", "onCreateViewHolder: Created itemView");
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PassTime passTime = passList.get(position);
        holder.risetime.setText(passTime.getRisetime());
        holder.duration.setText(passTime.getDuration() + " min");
    }

    @Override
    public int getItemCount() {
        return passList.size();
    }
}