package com.example.advance_registration_form_ch1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextEmail, editTextPass, editTextRePass;
    private Button btnPickImage, btnRegister;
    private Spinner countriesSpinner;
    private RadioGroup rgGender;
    private CheckBox agreementCheck;
    private RelativeLayout parent;
    DAO_Users dao = new DAO_Users();
    private ImageView profile;
    int SELECT_IMAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnPickImage.setOnClickListener(view -> {
//            Work: make upload or take image menu
            Toast.makeText(MainActivity.this, "Yet To Talk About", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent();
//            intent.setType("image/*");
//            intent.setAction(Intent.ACTION_GET_CONTENT);
//            startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE);
        });

//        btnRegister.setOnClickListener(this::onClick);
    }

//    MAKE SET IMAGE IN THE IMAGE VIEW SECTOR

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Uri uri = data.getData();
            profile.setImageURI(uri);
        }
    }
    private void initRegister() {
//    Log.d(TAG, "initRegister: Started");
        if (agreementCheck.isChecked()) {
            Toast.makeText(this, "You need to agree licence agreement", Toast.LENGTH_SHORT).show();
        } else {
            showSnackbar();
        }
    }

//    private Boolean validateData(){
//        if(editTextName.getText().toString().equals("")){
//
//        }
//    }

    private void showSnackbar() {
//   textwarnName.setvisibility(View.GONE)
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String Country = countriesSpinner.getSelectedItem().toString();
        String gender = "";
        switch (rgGender.getCheckedRadioButtonId()) {
            case R.id.rbmale:
                gender = "Male";
                break;
            case R.id.rbfemale:
                gender = "Female";
                break;
            case R.id.rbother:
                gender = "Other";
                break;
            default:
                gender = "Unknown";
                break;
        }

        String snacktext = "Name: " + name + "\n" + "Email" + email + "\n" + "Gender" + gender + "\n" + "Country" + Country + "\n";
        Snackbar.make(parent, "User Registered", Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editTextName.setText("");
                        editTextEmail.setText("");
                        editTextPass.setText("");
                        editTextRePass.setText("");
                    }
                }).show();
    }

    private void initViews() {
//        Log.d(TAG, "initViews: initView: Started");
        editTextName = findViewById(R.id.edtName);
        editTextEmail = findViewById(R.id.edtEmail);
        editTextPass = findViewById(R.id.edtPass);
        editTextRePass = findViewById(R.id.edtRepass);

        btnPickImage = findViewById(R.id.pickimage);
        btnRegister = findViewById(R.id.Register);

        countriesSpinner = findViewById(R.id.spinnercountries);
        rgGender = findViewById(R.id.Radiobtn);
        agreementCheck = findViewById(R.id.agreementcheck);
        parent = findViewById(R.id.parent);
    }

    private void onClick(View view) {
        initRegister();
//            public void onClick(View) {
//
//            }

        User user = new User(editTextName.getText().toString(), editTextEmail.getText().toString(), editTextPass.getText().toString(), editTextRePass.getText().toString());
        dao.add(user).addOnSuccessListener(suc ->
        {
            Toast.makeText(MainActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(er ->
        {
            Toast.makeText(MainActivity.this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
        });
      /*  HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("name",editTextName.getText().toString());
        hashMap.put("email",editTextEmail.getText().toString());
        hashMap.put("password",editTextPass.getText().toString());
        hashMap.put("Re-Enter Password",editTextRePass.getText().toString());
        dao.update("-NC13e7fvr3IuXsigPLn",hashMap).addOnSuccessListener(suc ->
        {
          Toast.makeText(MainActivity.this, "Record Updated", Toast.LENGTH_SHORT).show();
       }).addOnFailureListener(er ->
        {
            Toast.makeText(MainActivity.this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
        });*/

        /*
        dao.remove("-NC13e7fvr3IuXsigPLn").addOnSuccessListener(suc ->
        {
            Toast.makeText(MainActivity.this, "Record Removed", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(er ->
        {
            Toast.makeText(MainActivity.this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
        });*/

    }

    public void setProfile(ImageView profile) {
        this.profile = profile;
    }
}