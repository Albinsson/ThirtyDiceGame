package com.example.thirtydicegame;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View mView;
    private MainActivityContract.Model mModel;

    public MainActivityPresenter(MainActivityContract.View v) {
        mView = v;

        initPresenter();
    }

    private void initPresenter() {
        mModel = new MainActivityModel();
        mView.initView();
    }

    @Override
    public void onClickThrow(View view) {
        String data = mModel.getData();

        int [] diceDrawable = mModel.getDice();

        mView.setViewData(data);
        mView.setDices(diceDrawable);
    }

    @Override
    public void onClickDie(ImageView imageView, int dieNumber) {
        mModel.toggleDieHold(dieNumber);
        int dieDrawable = mModel.getImage(dieNumber);
        mView.setDieHoldImage(imageView, dieDrawable);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                break;
            case 1:
                Toast.makeText(parent.getContext(), "Spinner item 2!", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(parent.getContext(), "Spinner item 3!", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
