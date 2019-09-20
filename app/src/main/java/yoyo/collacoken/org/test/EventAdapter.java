package yoyo.collacoken.org.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Belal on 10/18/2017.
 */


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;
    //we are storing all the Events in a list
    private List<Event> EventList;

    //getting the context and Event list with constructor
    public EventAdapter(Context mCtx, List<Event> EventList) {
        this.mCtx = mCtx;
        this.EventList = EventList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.event_list, null);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        //getting the Event of the specified position
        Event Event = EventList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(Event.getTitle());
        holder.textViewPrice.setText(String.valueOf(Event.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(Event.getImage()));

    }


    @Override
    public int getItemCount() {
        return EventList.size();
    }


    class EventViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewPrice;
        ImageView imageView;

        public EventViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
