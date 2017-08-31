package com.example.gduque.firsttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = (EditText) findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = (TextView) findViewById(R.id.text_dolar);
        this.mViewHolder.textReal = (TextView) findViewById(R.id.text_real);
        this.mViewHolder.buttonCalculate = (Button) findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_calculate){
            //TODO
            double value = Double.parseDouble(this.mViewHolder.editValue.getText().toString());
            this.mViewHolder.textDolar.setText(String.format("%.2f", value * 1.18 ) + "$");
            this.mViewHolder.textReal.setText("R$" + String.format("%.2f", value * 3.726));
        }
    }

    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textReal.setText("");
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textReal;
        Button buttonCalculate;
    }
}
