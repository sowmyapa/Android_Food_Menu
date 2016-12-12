package com.cs442.sparameshwara.foodmenu;

import android.app.Activity;
import android.app.ListFragment;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by sowmyaparameshwara on 9/25/16.
 */
public class MenuListFragment extends ListFragment {

    OnClickMenuListListener onClickMenuListListener;

    public interface OnClickMenuListListener{
        public void onClick(int pos);
        public void onLongClick(int position);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            onClickMenuListListener = (OnClickMenuListListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    " must implement OnNewItemAddedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);
        onClickMenuListListener.onClick(pos);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
       // getListView().setBackgroundResource(R.color.colorDarkOrange);

        int[] colors = {0,0xff8c00,0}; // red for the example
        getListView().setDivider(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors));
        getListView().setDividerHeight(2);

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View view,
                                           int position, long id) {
                onClickMenuListListener.onLongClick(position);
                return true;
            }
        });
    }




}
