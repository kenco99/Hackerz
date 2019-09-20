package yoyo.collacoken.org.test;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class progress extends AppCompatActivity
 {

    RecyclerView recyclerView;
    progressadaptor adaptor;
    List<progresscardmodel> progresscardmodelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        progresscardmodelList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.ID_progress_progresstaskList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progresscardmodelList.add(
                new progresscardmodel(
                        500,
                        3,
                        R.drawable.dirtybeach
                ));
        progresscardmodelList.add(
                new progresscardmodel(
                        200,
                        6,
                        R.drawable.dirtybeach1
                ));
        progresscardmodelList.add(
                new progresscardmodel(
                        900,
                        1,
                        R.drawable.dirtybeach2
                ));
        progresscardmodelList.add(
                new progresscardmodel(
                        300,
                        2,
                        R.drawable.dirtybeach3
                ));
        adaptor= new progressadaptor(this, progresscardmodelList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adaptor);
    }
}
