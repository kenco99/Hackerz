package yoyo.collacoken.org.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Event> eventList;
    RecyclerView recyclerView;

    Toolbar toolbar;
    ImageView imageView;
    public static FragmentManager fragmentManager;
Context context;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    SpaceNavigationView spaceNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.MrecyclerView);
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


        toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        context=MainActivity.this;

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        drawerLayout=findViewById(R.id.drawyerLayout);
        navigationView=findViewById(R.id.navigationDrawer);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.camera:
                        item.setChecked(true);
                        Intent intent = new Intent(context,signup_activity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.location:
                        item.setChecked(true);
                        intent = new Intent(context,signup_activity.class);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.plane:
                        item.setChecked(true);
                         intent = new Intent(context,wallet.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        return true;

                }
                return false;
            }
        });

        spaceNavigationView=findViewById(R.id.ID_space);
        spaceNavigationView.setActiveCentreButtonBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_home_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_date_range_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_monetization_on_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_assignment_turned_in_black_24dp));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick()
            {
                Intent intent = new Intent(context,camera.class);
                startActivity(intent);
            }


            @Override
            public void onItemClick(int itemIndex, String itemName) {

                if (itemIndex==0)
                {


                }
                else  if (itemIndex==1)
                {

                        Intent intent = new Intent(context,Events.class);
                        startActivity(intent);

                }
                else  if (itemIndex==2)
                {

                        Intent intent = new Intent(context,Products.class);
                        startActivity(intent);

                }

                else  if (itemIndex==3)
                {
                    Intent intent = new Intent(context,leaderboard.class);
                    startActivity(intent);
                }

           }


            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap=(Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    public void displayMessage(String Message)
    {
        Toast.makeText(this,Message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
