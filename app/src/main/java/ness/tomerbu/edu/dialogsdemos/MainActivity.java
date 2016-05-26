package ness.tomerbu.edu.dialogsdemos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null)
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showMultiItemsAlert();
                }
            });
    }

    private void showAlert() {
        //init a builder:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //set some properties:
        //title, message, positive button, negative button
        builder.setTitle("Hello, Alerts");
        builder.setMessage("This is the message!");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yes Pressed", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });

        //show dialog
        builder.show();
    }


    private void showItemsAlert() {
        //init a builder:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //set some properties:
        //title, message, positive button, negative button
        builder.setTitle("Hello, Alerts");

        final String[] items = {"Red", "Green", "Azure", "Sky Blue"};

        final String[] colors = getResources().getStringArray(R.array.colors);
        builder.setItems(R.array.colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, colors[i], Toast.LENGTH_SHORT).show();
            }
        });


        //show dialog
        builder.show();
    }


    private void showMultiItemsAlert() {
        //init a builder:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //set some properties:
        //title, message, positive button, negative button
        builder.setTitle("Hello, Alerts");

        final String[] items = {"Mushrooms", "Onion", "Tomatoes", "Anchovy", "Tuna"};
        final boolean[] itemsChecked = {true, true, true, false, false};


        builder.setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                itemsChecked[which] = isChecked;
                Toast.makeText(MainActivity.this, items[which] +" " +isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String toastMessage = "";
                for (int i = 0; i < items.length; i++) {
                    String item = items[i];
                    if (itemsChecked[i])
                     toastMessage+= item + " V" + "\n";
                }
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        //show dialog
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
