package com.cs442.sparameshwara.foodmenu;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sowmyaparameshwara on 9/25/16.
 */
public class AddNewMenuItemFragment extends Fragment {

     View view;
     EditText editName;
     EditText editPrice;
     EditText editDescription;

     Button button;
    OnAddNewMenuItemListener addNewMenuItemListener;

    public interface OnAddNewMenuItemListener{
      public void addNewMenuItem(String name, String price, String description);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.add_new_menu_item_fragment,container,false);
        editName = (EditText) view.findViewById(R.id.editName);
        editPrice = (EditText) view.findViewById(R.id.editPrice);
        editDescription = (EditText) view.findViewById(R.id.editDescription);

        button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,price,decsription;
                if(editName.getText()!=null && editName.getText().length()!=0)
                  name = editName.getText().toString();
                else
                  name = " Default Food Name ";

                if(editPrice.getText()!=null && editPrice.getText().length()!=0)
                    price = editPrice.getText().toString();
                else
                    price = " ??? USD ";

                if(editDescription.getText()!=null && editDescription.getText().length()!=0  )
                    decsription = editDescription.getText().toString();
                else
                    decsription = " Check with waiter for further details ";
                addNewMenuItemListener.addNewMenuItem(name,price,decsription);
                editName.setText("");
                editPrice.setText("");
                editDescription.setText("");
            }
        });

    return view;
    }

    public  void onAttach(Activity activity){
        super.onAttach(activity);
        addNewMenuItemListener = (OnAddNewMenuItemListener) activity;

    }
}
