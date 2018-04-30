package com.own.sqlite1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Carolina 10/04/2018.
 */

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void serieAct(View view) {
        startActivity(new Intent(this, SerieActivity.class));
    }

    public void productAct(View view) {
        startActivity(new Intent(this, ProductActivity.class));
    }

    public void customerAct(View view) {
        startActivity(new Intent(this, CustomerActivity.class));
    }

    public void methodAct(View view) {
        startActivity(new Intent(this, MethodActivity.class));
    }
    public void supplierAct(View view) {
        startActivity(new Intent(this, SupplierActivity.class));
    }

   // public void orderAct(View view) {
     //   startActivity(new Intent(this, OrderActivity.class));
 //   }

 //   public void orderDetAct(View view) {startActivity(new Intent(this, OrderDetailActivity.class));
  //  }
}//End
