package com.example.goncaloduque.festafimdeano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.example.goncaloduque.festafimdeano.constants.FimDeAnoConstants;
import com.example.goncaloduque.festafimdeano.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = (CheckBox) findViewById(R.id.check_participate);

        this.mViewHolder.checkParticipate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.check_participate){
            if(this.mViewHolder.checkParticipate.isChecked()){
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE,FimDeAnoConstants.CONFIRMED_GO);
            }else {
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE,FimDeAnoConstants.CONFIRMED_NOGO);
            }
        }
    }

    private static class ViewHolder{
        CheckBox checkParticipate;
    }
}
