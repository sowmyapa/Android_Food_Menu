package com.cs442.sparameshwara.foodmenu;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodMenuActivity extends AppCompatActivity implements AddNewMenuItemFragment.OnAddNewMenuItemListener,MenuListFragment.OnClickMenuListListener {

    int index = 1;
    ArrayList<FoodMenuItem> menuItemList;
    FoodMenuItemAdapter menuItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        FragmentManager fragmentManager = getFragmentManager();
        MenuListFragment menuListFragment = (MenuListFragment) fragmentManager.findFragmentById(R.id.MenuListFragment);
         menuItemList = new ArrayList<FoodMenuItem>();
        prepopulateMenu(menuItemList);
        menuItemAdapter = new FoodMenuItemAdapter(this,R.layout.menu_item_fragment,menuItemList);

        menuListFragment.setListAdapter(menuItemAdapter);
    }

    private void prepopulateMenu(ArrayList<FoodMenuItem> menuItemList) {
        String[] name = new String[]{"VEG CHEESE PIZZA","VEG BURGER COMBO","SUBWAY CLUB","SPICY SZECHUAN NOODLES","PANEER TIKKA ROLL","PANCAKE","CEREALS"};
        String[] price = new String[]{"10.00 USD", "12.05 USD","09.00 USD","11.25 USD", "08.25 USD","06.00 USD","05.00 USD"};
        int[] images = new int[]{R.drawable.pizza,R.drawable.burger,R.drawable.subs,R.drawable.noodles,R.drawable.rolls,R.drawable.pancake,R.drawable.cereals};
        String[] description = new String[]{"Veg Cheese Pizza : 10.00 USD \n Taste : Medium Spicy \n Ingredients : Cheese, Tomato & Spices served on thin crust.",
                "Veg Burger Combo : 12.05 USD \nTaste : Medium Spicy \nIngredients : Vegetable patty & an additional cheese patty served with french fries.",
                "Subway Club : 09.00 USD \nTaste : Medium Spicy \nIngredients : Pick your choice of vegetables among lettuce, jalapenoes, potato, beans, carrot, olives.",
                "Spicy Szechuan Noodles : 11.25 USD \nTaste : Spicy \nIngredients : Noodles served with hot garlic sauce and vegetables.",
                "Paneer Tikka Roll : 08.25 USD \nTaste : Spicy \nIngredients : Grilled paneer tikka wrapped in maida roll.",
                "Pancakes : 06.00 USD \nTaste : Sweet \nIngredients : Freshly made pancakes served with Maple Syrup.",
                "Cereals : 05.00 USD \nTaste : Sweet \nIngredients : Corn Flakes/Chocos/Maple Loops sereved with hot/cold milk."};

        for(int i = 0 ; i <7 ; i++){
            FoodMenuItem foodMenuItem = new FoodMenuItem(name[i],price[i],images[i],index++,description[i]);
            menuItemList.add(foodMenuItem);
        }
    }

    public void addNewMenuItem(String name, String price, String description){
        FragmentManager fm = getFragmentManager();
        MenuListFragment menuListFragment =
                (MenuListFragment)fm.findFragmentById(R.id.MenuListFragment);


        if(menuItemList.size()==0){
            menuListFragment.getListView().setBackgroundResource(0);
        }
        FoodMenuItem foodMenuItem = new FoodMenuItem(name,price,R.drawable.default_food_image,index++,description);
        menuItemList.add(foodMenuItem);
        menuItemAdapter.notifyDataSetChanged();
        menuListFragment.getListView().smoothScrollToPosition(menuItemList.size()-1);

    }


    @Override
    public void onClick(int pos) {
        Toast.makeText(this,menuItemList.get(pos).description, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLongClick(int position) {
        FoodMenuItem foodMenuItem = menuItemList.get(position);
        Toast.makeText(this,foodMenuItem.foodName+" removed from menu. ", Toast.LENGTH_LONG).show();
        menuItemList.remove(position);
        FragmentManager fm = getFragmentManager();
        MenuListFragment menuListFragment =
                (MenuListFragment)fm.findFragmentById(R.id.MenuListFragment);
        if(menuItemList.size()==0){

            menuListFragment.getListView().setBackgroundResource(R.drawable.out_of_stock);
        }
        menuItemAdapter.notifyDataSetChanged();
    }

}
