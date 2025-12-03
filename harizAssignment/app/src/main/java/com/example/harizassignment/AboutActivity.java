package com.example.harizassignment;

// import function dalam android
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;

// yang ni import kelas dari androidX
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // nak setup layout dalam activity ni
        setContentView(R.layout.activity_about);
        // ambik toolbar daripada XML
        Toolbar toolbar = findViewById(R.id.toolbar);
        // jadikan toolbar ni header bar
        setSupportActionBar(toolbar);
        // nak tentukan tajuk untuk toolbar
        getSupportActionBar().setTitle("About");

        // guna textview nak tunjuk link Github
        TextView github = findViewById(R.id.tvGithub);
        // nak jadikan link github tu kepada hyperlink
        github.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate = masukkan menu_main.xml dalam toolbar
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // dapatkan id item/menu yang kene tekan
        int id = item.getItemId();
        // kalau tekan button Home
        if (id == R.id.action_home) {
            // pergi kat MainActivity (calculator Page)
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }
        // kalau tekan button About
        else if (id == R.id.action_about) {
            return true; // Already on About page
        }

        return super.onOptionsItemSelected(item);
    }
}
