package yoyo.collacoken.org.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class Events extends AppCompatActivity
{

    List<Event> eventList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        recyclerView = (RecyclerView) findViewById(R.id.ElRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the Eventlist
        eventList = new ArrayList<>();


        //adding some items to our list
        eventList.add(
                new Event(
                        1,
                        "Beach Clean Up",
                        "Miramar beach " +
                                "4:30PM-6:00PM",
                        R.drawable.beachcleanup
                ));
        eventList.add(
                new Event(
                        1,
                        "Street Clean Up",
                        "Alberta Street "+"10:00AM-2:00PM",
                        R.drawable.ospclean
                ));
        eventList.add(
                new Event(
                        1,
                        "Neighbourhood clean up",
                        "Moonshadow Lands "+"10:30aM-1:00PM",
                        R.drawable.ncleanup
                ));


        //creating recyclerview adapter
        EventAdapter adapter1 = new EventAdapter(this, eventList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter1);
    }
}
