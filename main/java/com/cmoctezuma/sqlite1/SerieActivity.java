package com.own.sqlite1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.own.sqlite1.adapter.SerieAdapter;
import com.own.sqlite1.model.Serie;
import com.own.sqlite1.sqlite.DBOperations;

import java.util.ArrayList;
import java.util.List;

public class SerieActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtActor;
    private EditText edtDurecion;
    private EditText edtCapitulos;
    private EditText edtProtagonista;
    private Button btnSaveSerie;
    private DBOperations operations;
    private Serie serie= new Serie();
    private RecyclerView rcvSerie;
    private List<Serie> series = new ArrayList<>();
    private SerieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);
        operations = DBOperations.getDBOperations(getApplicationContext());
        serie.setIdSerie("");
        initComponents();
    }

    private void initComponents(){
        rcvSerie = (RecyclerView)findViewById(R.id.rcv_list);
        rcvSerie.setHasFixedSize(true);
        LinearLayoutManager layoutManeger = new LinearLayoutManager(this);
        rcvSerie.setLayoutManager(layoutManeger);
        getSerie();
        adapter = new SerieAdapter(series);

        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_delete:
                        operations.deleteSerie(series.get(rcvSerie.getChildPosition((View)v.getParent().getParent())).getIdSerie());
                        getSeries();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.btn_edit:
                        Toast.makeText(getApplicationContext(),"Edit serie.",Toast.LENGTH_SHORT).show();
                        Cursor c = operations.getSerieById(series.get(rcvSerie.getChildPosition((View)v.getParent().getParent())).getIdSerie());
                            if (c!=null){
                                if (c.moveToFirst()){
                                    serie = new Serie(c.getString(1),c.getString(2),c.getString(3),c.getString(4), c.getString(4), c.getString(5));
                                }
                                edtName.setText(serie.getName());
                                edtCreator.setText(serie.getCreator());
                                edtGender.setText(serie.getGender());
                                edtYear.setText(serie.getYear());
                                edtYear.setText(String.valueOf(serie.getYear()));
                                edtChapters.setText(String.valueOf(serie.getChapters()));
                            }else{
                                Toast.makeText(getApplicationContext(),"Record not found.",Toast.LENGTH_SHORT).show();
                            }
                        break;
                }
            }
        });

        rcvSerie.setAdapter(adapter);
        edtName = (EditText) findViewById(R.id.edt_name);
        edtCreator = (EditText) findViewById(R.id.edt_creator);
        edtGender = (EditText) findViewById(R.id.edt_gender);
        edtYear = (EditText) findViewById(R.id.edt_year);
        edtChapters = (EditText) findViewById(R.id.edt_chapters);
        btnSaveSerie = (Button) findViewById(R.id.btn_save_song);

        btnSaveSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!serie.getIdSerie().equals("")){
                    serie.setName(edtName.getText().toString());
                    serie.setCreator(edtCreator.getText().toString());
                    serie.setGender(edtGender.getText().toString());
                    serie.setYear(edtYear.getText().toString());
                    serie.setChapters(edtChapters.getText().toString());
                    operations.updateSerie(serie);
                }else {
                    serie = new Serie("", edtName.getText().toString(), edtCreator.getText().toString(), edtGender.getText().toString(),
                            edtYear.getText().toString(), edtChapters.getText().toString());
                    operations.insertSerie(serie);
                }
                getSeries();
                clearData();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void getSeries(){
        Cursor c = operations.getSeries();
        series.clear();
        if(c!=null){
            while (c.moveToNext()){
                series.add(new Serie(c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6)));
            }
        }
    }

    private void clearData(){
        edtName.setText("");
        edtCreator.setText("");
        edtGender.setText("");
        edtYear.setText("");
        edtChapters.setText("");
        serie = null;
        serie = new Serie();
        serie.setIdSerie("");
    }

}//End
