package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText FullName;
    EditText GrossSalary;
    Button Calc;
    ListView netSalary;
    ArrayList<Employees> List = null;
    ArrayAdapter<Employees> ListAdapter = null;

    public static class Employees
    {
        private String FullName;
        private float GrossSalary;
        private float tax;

        public void setFullName(String fullname)
        {
            FullName = fullname;
        }

        public String getFullName()
        {
            return FullName;
        }

        public void setGrossSalary(float gross)
        {
            GrossSalary = gross;
        }

        public float getGrossSalary()
        {
            return GrossSalary;
        }

        public int netSalary()
        {
            float a = (float) (GrossSalary - (GrossSalary * 0.105));
            if (a <= 11000000)
            {
                return (int) a;
            }
            else
            {
                tax = (float) ((a - 11000000) * 0.05);
                return (int) (a - tax);
            }
        }

        public String toString()
        {
            return "Hello" + getFullName() + ", your net salary is " + netSalary() + "\n" + "Hope you like my product (✿◡‿◡)";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FullName = (EditText) findViewById(R.id.FullNameEntered);
        GrossSalary = (EditText) findViewById(R.id.GrossSalaryEntered);
        netSalary = (ListView) findViewById(R.id.netSalaryView);
        Calc = (Button) findViewById(R.id.CalculateButton);

        List = new ArrayList<Employees>();
        ListAdapter = new ArrayAdapter<Employees>(MainActivity.this, android.R.layout.simple_list_item_1, List);
        netSalary.setAdapter(ListAdapter);

        Calc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View event)
            {
                Employees em = new Employees();
                em.setFullName(FullName.getText().toString());
                em.setGrossSalary(Float.parseFloat(GrossSalary.getText().toString()));
                List.add(em);
                ListAdapter.notifyDataSetChanged();
            }
        });
    }
}
