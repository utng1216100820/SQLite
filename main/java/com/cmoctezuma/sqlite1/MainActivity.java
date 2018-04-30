package com.own.sqlite1;

import android.database.DatabaseUtils;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;


import com.own.sqlite1.model.Anime;
import com.own.sqlite1.model.Customer;
import com.own.sqlite1.model.Supplier;
import com.own.sqlite1.model.MethodPayment;
import com.own.sqlite1.model.OrderDetail;
import com.own.sqlite1.model.OrderHeader;
import com.own.sqlite1.model.Product;
import com.own.sqlite1.sqlite.DBHelper;
import com.own.sqlite1.sqlite.DBOperations;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DBOperations data;
    public class DataTaskTest extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... params) {
            //inserciones
            String currentDate= Calendar.getInstance().getTime().toString();
            try{
                data.getDb().beginTransaction();
                //InsertCustomer
                String customer1=data.insertCustomer(new Customer(null,"Veronica","Del Topo","402558"));
                String customer2=data.insertCustomer(new Customer(null,"Carlos","Villagran","458852"));
                //Method
                //Suppliers
                String supplier1 = data.insertSupplier(new Supplier(null,"Nada","Como","holis"));
                data.deleteSupplier(supplier1);
                String methodPayment1=data.insertMethodPayment(new MethodPayment(null,"Efectivo"));
                String methodPayment2=data.insertMethodPayment(new MethodPayment(null,"Cerdito"));
                //Products
                String product1=data.insertProdut(new Product(null,"Leche",4,120));
                String product2=data.insertProdut(new Product(null,"Galletas",5,45));
                String product3=data.insertProdut(new Product(null,"Queso",45,149.5f));
                String product4=data.insertProdut(new Product(null,"Papitas",12,189.5f));
                //Orders Header
                String order1=data.insertOrderHeader(new OrderHeader(null,customer1,methodPayment1,currentDate));
                String order2=data.insertOrderHeader(new OrderHeader(null,customer2,methodPayment2,currentDate));

                //Ordert dETAIL
                data.insertOrderDetail(new OrderDetail(order1,1,product1,5,2));
                data.insertOrderDetail(new OrderDetail(order1,2,product1,15,5));
                data.insertOrderDetail(new OrderDetail(order2,1,product1,35,26));
                data.insertOrderDetail(new OrderDetail(order2,2,product1,45,12));
                //ELIMINAR PEDIDO
                data.deleteOrderHeader(order1);
                //Actualizacioon
                data.updateCustomer(new Customer(customer2,"Jasmin ","Santana","418100256"));

                //Insert anime
                String anime1 = data.insertAnime(new Anime(null, "DBZ", "Toriyama", "Shonen", "2018", "150"));
                //Delete anime
                data.deleteAnime(anime1);

                data.getDb().setTransactionSuccessful();

            }finally {
                data.getDb().endTransaction();
            }
            //Querys
            Log.d("Customers","Customers");
            DatabaseUtils.dumpCursor(data.getCustomers());
            Log.d("Method of Payment","Method of Payments");
            DatabaseUtils.dumpCursor(data.getMethodsPayment());
            Log.d("Products","Products");
            DatabaseUtils.dumpCursor(data.getProducts());
            Log.d("Order Headers","Order HeaderS");
            DatabaseUtils.dumpCursor(data.getOrderDetails());
            Log.d("Order Details","Order Details");
            DatabaseUtils.dumpCursor(data.getOrderDetails());
            Log.d("Suppliers","Suppliers");
            DatabaseUtils.dumpCursor(data.getSuppliers());
            //Songs
            Log.d("Animes", "Animes");
            DatabaseUtils.dumpCursor(data.getAnimes());

            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getApplicationContext().deleteDatabase(DBHelper.DATABASE_NAME);
        data=DBOperations.getDBOperations(getApplicationContext());
        new DataTaskTest().execute();

    }
}
