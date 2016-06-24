package com.mattmccoleman.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etInput;
    TextView txtText;
    Button btnAdd, btnDelete;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        etInput = (EditText)findViewById(R.id.etInput);
        txtText = (TextView)findViewById(R.id.txtText);

        dbHandler = new MyDBHandler(this, null, null, 1);
        try {
            printDatabase();
        }catch (Exception e){
            Log.i("exxxx", e.toString());
        }

    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        txtText.setText(dbString);
        etInput.setText("");
    }

    //Add a product to the database
    public void addButtonClicked(View view){
        Log.i("exxxx", "CLİCKED ADD BUTTON");
        String product = etInput.getText().toString();
        Products p = new Products(product);
        dbHandler.addProduct(p);
        printDatabase();
    }

    //Delete a product to the database
    public void deleteButtonClicked(View view){
        Log.i("exxxx", "CLİCKED DELETE BUTTON");
        String inputText = etInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }
}

//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
//
//import android.support.v7.app.ActionBarActivity;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//
//public class MainActivity extends AppCompatActivity {
//
//    EditText buckysInput;
//    TextView buckysText;
//    MyDBHandler dbHandler;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        buckysInput = (EditText) findViewById(R.id.buckysInput);
//        buckysText = (TextView) findViewById(R.id.buckysText);
//        dbHandler = new MyDBHandler(this, null, null, 1);
//        printDatabase();
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    //Add a prodcut to the database
//    public void addButtonClicked(View view){
//        Products product = new Products(buckysInput.getText().toString());
//        dbHandler.addProduct(product);
//        buckysInput.setText("");
//    }
//
//    //Delete Items
//    public void deleteButtonClicked(View view){
//        String inputText = buckysInput.getText().toString();
//        dbHandler.deleteProduct(inputText);
//        printDatabase();
//    }
//
//    public void printDatabase(){
//        String dbString = dbHandler.databaseToString();
//        buckysText.setText(dbString);
//        buckysInput.setText("");
//    }
//}
