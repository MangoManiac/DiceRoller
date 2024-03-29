package learnprogramming.academy.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public void on_button_click(View view){

        // gv stands for generated view
       TextView gv =  this.findViewById(R.id.generatedView);

       Random r = new Random();
       // Plus 1 because this way zero is not generated and number goes up to 6
       int number = r.nextInt(6) +1;
       gv.setText(Integer.toString(number));


       EditText inputText = (EditText)findViewById(R.id.numberInput);

       // catch the exception to prevent no input problem
       try {
           int guess = Integer.parseInt(inputText.getText().toString());
           // sv stands for score view
           TextView sv = this.findViewById(R.id.scoreView);


           if(inputText == null){
               inputText.setText("0");
           }

           //check number is within range
           if(guess > 6 || guess < 1){
               gv.setText("Invalid number");
           }
           inputText.setText("");
           if(number == guess){
               gv.setText("Congratulations");
               this.score++;
               sv.setText(Integer.toString(score));
           }
       }catch (NumberFormatException e){
           gv.setText("No Input");
       }


    }


}
