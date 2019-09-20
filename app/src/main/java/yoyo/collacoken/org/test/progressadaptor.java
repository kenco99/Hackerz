package yoyo.collacoken.org.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

public class progressadaptor extends RecyclerView.Adapter<progressadaptor.progressViewHolder> {
    private Context pCtx;
    List<progresscardmodel> progresscardmodelList;

    public progressadaptor(Context pCtx, List<progresscardmodel> progresscardmodelList) {
        this.pCtx = pCtx;
        this.progresscardmodelList = progresscardmodelList;
    }

    @NonNull
    @Override
    public progressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(pCtx);
        View view = inflater.inflate(R.layout.progresscards, null);
        return new progressadaptor.progressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull progressViewHolder holder, int position) {
        progresscardmodel progresscardmodel = progresscardmodelList.get(position);
        holder.points.setText(String.valueOf(progresscardmodel.getPoints()));
        holder.days.setText(String.valueOf(progresscardmodel.getDays()));
        holder.img.setImageDrawable(pCtx.getResources().getDrawable(progresscardmodel.getImg()));
    }

    @Override
    public int getItemCount() {return progresscardmodelList.size();}

    public class progressViewHolder extends RecyclerView.ViewHolder{
        TextView points;
        TextView days;
        ImageView img;
        public progressViewHolder(@NonNull View itemView) {
            super(itemView);
            points = (TextView) itemView.findViewById(R.id.ID_progresscard_points);
            days = (TextView) itemView.findViewById(R.id.ID_progresscard_days);
            img = (ImageView) itemView.findViewById(R.id.ID_progresscard_image);
        }
    }
}

