package yoyo.collacoken.org.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import android.support.v7.widget.RecyclerView;

public class leaderboardadaptor extends RecyclerView.Adapter<leaderboardadaptor.LeaderboardViewHolder> {


    private Context nCtx;
    private List<leaderboardcardmodel> leaderboardcardmodelList;

    public leaderboardadaptor(Context nCtx, List<leaderboardcardmodel> leaderboardcardmodelList) {
        this.nCtx = nCtx;
        this.leaderboardcardmodelList = leaderboardcardmodelList;
    }
    @Override
    public LeaderboardViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(nCtx);
        View view = inflater.inflate(R.layout.leaderboardcard, null);
        return new LeaderboardViewHolder(view);

    }

    @Override
    public void onBindViewHolder( LeaderboardViewHolder holder, int position) {
        leaderboardcardmodel leaderboardmodel = leaderboardcardmodelList.get(position);
        holder.imgRank.setImageDrawable(nCtx.getResources().getDrawable(leaderboardmodel.getRankNo()) );
        holder.imgProfile.setImageDrawable(nCtx.getResources().getDrawable(leaderboardmodel.getUserProfile()) );
        holder.userName.setText(leaderboardmodel.getUserName());
        holder.points.setText(String.valueOf(leaderboardmodel.getScorePoints()));
    }

    @Override
    public int getItemCount()
    {
        return leaderboardcardmodelList.size();
    }

    public class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRank;
        ImageView imgProfile;
        TextView userName;
        TextView points;
        public LeaderboardViewHolder( View itemView) {
            super(itemView);
            imgRank = (ImageView) itemView.findViewById(R.id.ID_leaderboard_rankno);
            imgProfile = (ImageView) itemView.findViewById(R.id.ID_leaderboard_profilepic);
            userName = (TextView) itemView.findViewById(R.id.ID_leaderboard_username);
            points = (TextView) itemView.findViewById(R.id.ID_leaderboard_points);
        }
    }
}

