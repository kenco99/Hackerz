package yoyo.collacoken.org.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import android.support.v7.widget.RecyclerView;

public class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.MainRvViewHolder> {



    //this context we will use to inflate the layout
    private Context mCtx;
    //we are storing all the MainRvs in a list
    private List<MainRv> MainRvList;

    //getting the context and MainRv list with constructor
    public MainRvAdapter(Context mCtx, List<MainRv> MainRvList) {
        this.mCtx = mCtx;
        this.MainRvList = MainRvList;
    }

    @Override
    public MainRvAdapter.MainRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.main_screen, null);
        return new MainRvAdapter.MainRvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainRvAdapter.MainRvViewHolder holder, int position) {
        //getting the MainRv of the specified position
        MainRv MainRv = MainRvList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(MainRv.getTitle());
        holder.textViewPrice.setText(String.valueOf(MainRv.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(MainRv.getImage()));

    }


    @Override
    public int getItemCount() {
        return MainRvList.size();
    }


    class MainRvViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewPrice;
        ImageView imageView;

        public MainRvViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
    
}
