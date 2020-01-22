package com.example.emon.blood_bank;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DonorAdapter extends ArrayAdapter<Donor> {

    public DonorAdapter(Context context, ArrayList<Donor> donor)
    {
        super(context , 0 , donor);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Donor donor = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.display_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvFirstName);
        TextView tvAge = (TextView) convertView.findViewById(R.id.tvAge);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.tvPhoneNum);
        TextView tvBlood = (TextView) convertView.findViewById(R.id.tvBloodGrp);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);

        // Populate the data into the template view using the data object

        tvName.setText(donor.getName());
        tvAge.setText(String.valueOf(donor.getAge())) ;
        tvBlood.setText(donor.getBloodGroup());
        tvPhone.setText(donor.getPhone());
        tvLocation.setText(donor.getLocation());

        // Return the completed view to render on screen
        return convertView;
    }

}
