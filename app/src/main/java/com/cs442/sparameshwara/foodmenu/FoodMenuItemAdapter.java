package com.cs442.sparameshwara.foodmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ResourceCursorTreeAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by sowmyaparameshwara on 9/25/16.
 */
public class FoodMenuItemAdapter extends ArrayAdapter<FoodMenuItem> {

    int resource;

    public FoodMenuItemAdapter(Context context, int resource) {
        super(context, resource);
    }

    public FoodMenuItemAdapter(Context context, int resource, ArrayList<FoodMenuItem> foodMenuItems) {
        super(context, resource,foodMenuItems);
        this.resource = resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout layout= null;

        if (convertView == null) {
            layout = new RelativeLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater)getContext().getSystemService(inflater);
            li.inflate(resource, layout, true);
        } else {
            layout = (RelativeLayout) convertView;
        }


        FoodMenuItem foodMenuItem = getItem(position);
       TextView foodNameWidget = (TextView) layout.findViewById(R.id.foodName);
        TextView foodPriceWidget = (TextView)layout.findViewById(R.id.foodPrice);
        ImageView foodImage = (ImageView)layout.findViewById(R.id.foodImage);
        TextView foodIndexWidget = (TextView)layout.findViewById(R.id.foodIndex);
        foodImage.setImageResource(foodMenuItem.resId);
        foodNameWidget.setText(foodMenuItem.foodName);
        foodPriceWidget.setText(foodMenuItem.price);
        foodIndexWidget.setText(String.valueOf(foodMenuItem.position));
        return layout;
    }
}
