package com.example.thirtydicegame;

import android.widget.AdapterView;
import android.widget.ImageView;

public interface MainActivityContract {

    interface View {
        void initView();
        void setViewData(String data);
        void setDices(int[] diceDrawable);

        void setDieHoldImage(ImageView imageView, int dieDrawable);
    }

    interface Model {
        String getData();
        String [] getThrow();
        void rollDice();
        int [] getDice();
        int getImage(int dieNumber);

        void toggleDieHold(int dieNumber);
    }

    interface Presenter {
        void onClickThrow(android.view.View view);
        void onClickDie(ImageView imageView, int dieNumber);
        void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id);
    }
}

