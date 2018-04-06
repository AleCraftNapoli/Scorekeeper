package tk.larobadiale.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toActivity(View view) {
        if (view.getId() == R.id.buttonRun) {
            Intent intent = new Intent(getApplicationContext(), ScorekeeperActivity.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.buttonSettings) {
            Intent intent = new Intent(getApplicationContext(), OptionsActivity.class);
            startActivity(intent);
        }
    }
}
