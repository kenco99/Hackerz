package yoyo.collacoken.org.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class  Products extends AppCompatActivity
{
    List<Product> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products2);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "FLAT 50% OFF ON ALL MOBILE PHONES",
                        "*terms & conditions apply",
                        4.3,
                        "100",
                        R.drawable.amazon));

        productList.add(
                new Product(
                        1,
                        "UPTO 60% OFF ON ALL SHOES ",
                        "*terms & conditions apply",
                        4.3,
                        "80",
                        R.drawable.nike));

        productList.add(
                new Product(
                        2,
                        "FLAT 30% OFF ON MOVIE TICKETS",
                        "*terms & conditions apply",
                        4.3,
                        "45",
                        R.drawable.bookmyshow));
        productList.add(
                new Product(
                        3,
                        "FLAT 20% OFF ON RIDES ABOVE Rs.150",
                        "*terms & conditions apply",
                        4.3,
                        "40",
                        R.drawable.uber));
        productList.add(
                new Product(
                        4,
                        "15% OFF ON ALL OYO WIZARD",
                        "*terms & conditions apply",
                        4.3,
                        "30",
                        R.drawable.oyo));




        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

}