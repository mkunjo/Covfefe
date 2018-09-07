package com.example.mk.covfefe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity;
    private Button waitingBt;

    public void setListener(){
        waitingBt = findViewById(R.id.waitBt);
        waitingBt.setTextColor(Color.YELLOW);
        waitingBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WaitActivity.class));
                Toast.makeText(MainActivity.this, "Our fun waiting screen!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void decrement(View view) {
        quantity=quantity-1;
        displayquantity(quantity);
    }
    private void displayquantity(int quantity) {
        EditText quantity1 = (EditText) findViewById(R.id.quantityTxt);
        quantity1.setText(""+quantity);
    }
    public void increment(View view) {
        quantity = quantity + 1;
        displayquantity(quantity);
    }
    private int calculatePrice(Boolean chocs, Boolean whipped) {
        int price =5;
        if (chocs)
        {
            price =price+1;
        }
        if (whipped)
        {
            price=price+2;
        }
        return price*quantity;
    }
    private void displayMessage(String finalMessage) {
        TextView Message = (TextView) findViewById(R.id.resultTxt);
        Message.setText(""+finalMessage);
    }
    private String createFinalMessage(String names, Boolean chocs, Boolean whipped,int price) {
        String Message = "Name: "+names+"\n"+"chocolate ordered :"+chocs+"\n"+"whipped ordered  :"+whipped+"\n"+" Total Price $: "+price;
        return  Message;
    }
    public void orderButton(View view) {
        EditText name = (EditText) findViewById(R.id.nameTxt);

        String names = name.getText().toString();
        CheckBox choc = (CheckBox) findViewById(R.id.chocalate_checkbox);
        Boolean chocs = choc.isChecked();
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean whipped = whippedCream.isChecked();
        int price = calculatePrice(chocs,whipped);
        String finalMessage =createFinalMessage (names,chocs,whipped,price);
        displayMessage(finalMessage);
        setListener();
    }
}

