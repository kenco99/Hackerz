package yoyo.collacoken.org.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class leaderboard extends AppCompatActivity {

    RecyclerView recyclerView;
    leaderboardadaptor adaptor;
    List<leaderboardcardmodel> leaderboardcardmodelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        leaderboardcardmodelList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.ID_leaderboard_leaderboardlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        leaderboardcardmodelList.add(
                new leaderboardcardmodel(
                        R.drawable.a1,
                        R.drawable.profilepic,
                        200,
                        "CleanFreakz"
                ));
        leaderboardcardmodelList.add(
                new leaderboardcardmodel(
                        R.drawable.a2,
                        R.drawable.profilepic,
                        180,
                        "Cleanerz"
                ));
        leaderboardcardmodelList.add(
                new leaderboardcardmodel(
                        R.drawable.a3,
                        R.drawable.profilepic,
                        170,
                        "SwacchBharatGuy"
                ));
        leaderboardcardmodelList.add(
                new leaderboardcardmodel(
                        R.drawable.a4,
                        R.drawable.profilepic,
                        150,
                        "DirtDestroyer"
                ));
        leaderboardcardmodelList.add(
                new leaderboardcardmodel(
                        R.drawable.a5,
                        R.drawable.profilepic,
                        50,
                        "SomeRandomGuy"
                ));
        leaderboardcardmodelList.add(
                new leaderboardcardmodel(
                        R.drawable.a6,
                        R.drawable.profilepic,
                        45,
                        "SomeRandomGuy2"
                ));



        adaptor= new leaderboardadaptor(this, leaderboardcardmodelList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adaptor);
    }
}
