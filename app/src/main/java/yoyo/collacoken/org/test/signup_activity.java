package yoyo.collacoken.org.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class signup_activity extends AppCompatActivity {


    String ImageUri;
    Uri uri;
    EditText Username,Email,Password,cPassword;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);

        Username=findViewById(R.id.ID_User_Name);
        Email=findViewById(R.id.ID_Email);
        Password=findViewById(R.id.ID_Password);
        cPassword=findViewById(R.id.ID_Confirm_Password);

        imageView=findViewById(R.id.ID_UPLOADimageview);


    }
    public void UploadFB(View view) {




   Intent intent=new Intent(this,MainActivity.class);
   startActivity(intent);


    }
    void ImageUploadFb()
    {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Uploading");
        progressDialog.show();
        StorageReference storageReference= FirebaseStorage.getInstance().getReference().child("Image").child(uri.getLastPathSegment());
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {




                Task<Uri> task =taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        ImageUri=uri.toString();
                        UploadReceipeFB();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(signup_activity.this, "Some Error Occured", Toast.LENGTH_SHORT).show();
                    }
                });



                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(signup_activity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Imageput(View view) {


        Intent PhotoPicker=new Intent(Intent.ACTION_PICK);
        PhotoPicker.setType("image/*");
        startActivityForResult(PhotoPicker,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            uri=data.getData();
            imageView.setImageURI(uri);

        }
        else
            Toast.makeText(this, "Image not Selected", Toast.LENGTH_SHORT).show();
    }
    void UploadReceipeFB()
    {




        datasetter d=new datasetter(
                Username.getText().toString(),
                Email.getText().toString(),
                Password.getText().toString(),
                ImageUri,"0","0","0","0"
        );
        FirebaseDatabase.getInstance().getReference("User").child(d.getUserName()).setValue(d).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(signup_activity.this, "Uploaded Successfully", Toast.LENGTH_SHORT).show();

                                Intent intent=new Intent(signup_activity.this,MainActivity.class);
                    startActivity(intent);

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });




    }


}
