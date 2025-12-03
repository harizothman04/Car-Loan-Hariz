package com.example.harizassignment;
// cam biasa import function dari android
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
// input punya part , kat sinilah user nak isi maklumat
    EditText etPrice, etDown, etYears, etRate;
// ni output, apa yang akan keluar
    TextView tvLoanAmount, tvTotalInterest, tvTotalPayment, tvMonthlyPayment;
// ni button-button yang kite nak tekan, macam button kira2 dengan button reset
    Button btnCalculate, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // nak setup layout untuk activity yang ni
        setContentView(R.layout.activity_main);

        // ambik toolbar dalam xml
        Toolbar toolbar = findViewById(R.id.toolbar);
        // nak jadikan die header bar
        setSupportActionBar(toolbar);
        // nak set die punya title untuk header bar
        getSupportActionBar().setTitle("Car Loan Calculator");


        // nak connectkan variable input dengan ui xml
        etPrice = findViewById(R.id.inputPrice);
        etDown = findViewById(R.id.inputDown);
        etYears = findViewById(R.id.inputYears);
        etRate = findViewById(R.id.inputRate);

        // nak connectkan variable output dengan ui xml
        tvLoanAmount = findViewById(R.id.tvLoanAmount);
        tvTotalInterest = findViewById(R.id.tvTotalInterest);
        tvTotalPayment = findViewById(R.id.tvTotalPayment);
        tvMonthlyPayment = findViewById(R.id.tvMonthlyPayment);

        // sama jugak tpi untuk button
        btnCalculate = findViewById(R.id.btnCalculate);
        btnReset = findViewById(R.id.btnReset);
        // kalau user klik button ni, nnti die akan panggil method tu
        btnCalculate.setOnClickListener(v -> calculateLoan());
        btnReset.setOnClickListener(v -> resetForm());
    }

    private void calculateLoan() {
        try {
            // nak convert kan input kepada string
            double price = Double.parseDouble(etPrice.getText().toString());
            double down = Double.parseDouble(etDown.getText().toString());
            double years = Double.parseDouble(etYears.getText().toString());
            double rate = Double.parseDouble(etRate.getText().toString());
            // formula2 untuk kira
            double loanAmount = price - down;
            double totalInterest = loanAmount * (rate / 100) * years;
            double totalPayment = loanAmount + totalInterest;
            double monthlyPayment = totalPayment / (years * 12);
            // nak paparkan dalam ui
            tvLoanAmount.setText(String.format("Loan Amount = RM %.2f", loanAmount));
            tvTotalInterest.setText(String.format("Total Interest = RM %.2f", totalInterest));
            tvTotalPayment.setText(String.format("Total Payment  = RM %.2f", totalPayment));
            tvMonthlyPayment.setText(String.format("Monthly Payment = RM %.2f", monthlyPayment));

        } catch (Exception e) {
            // kalau tk isi apa2 nnti keluar mesej ni
            Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
        }
    }
    // nak kosongkan semua input
    private void resetForm() {
        etPrice.setText("");
        etDown.setText("");
        etYears.setText("");
        etRate.setText("");
    // nak reset output ke nilai default
        tvLoanAmount.setText("RM 0.00");
        tvTotalInterest.setText("RM 0.00");
        tvTotalPayment.setText("RM 0.00");
        tvMonthlyPayment.setText("RM 0.00");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // nak loadkan file menu_main.xml dlm toolbar
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // kalau tekan Home
        if (id == R.id.action_home) {
            Toast.makeText(this, "Home clicked!", Toast.LENGTH_SHORT).show();
            return true;
        }
        // kalau tekan About
        else if (id == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
