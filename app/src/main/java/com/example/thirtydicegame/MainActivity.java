package com.example.thirtydicegame;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private TextView mTextView;
    private Button mButton;
    private Spinner mSpinner;

    private ImageView mDice1;
    private ImageView mDice2;
    private ImageView mDice3;
    private ImageView mDice4;
    private ImageView mDice5;
    private ImageView mDice6;

    private MainActivityContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainActivityPresenter(this);
    }

    @Override
    public void initView() {
        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.btn);
        mSpinner = findViewById(R.id.points_spinner);
        
        mDice1 = findViewById(R.id.imageViewDice1);
        mDice2 = findViewById(R.id.imageViewDice2);
        mDice3 = findViewById(R.id.imageViewDice3);
        mDice4 = findViewById(R.id.imageViewDice4);
        mDice5 = findViewById(R.id.imageViewDice5);
        mDice6 = findViewById(R.id.imageViewDice6);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(this, R.array.points_option_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        mSpinner.setAdapter(mAdapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickThrow(v);
            }
        });

        mDice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickDie(mDice1, 1);
            }
        });

        mDice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickDie(mDice2, 2);
            }
        });

        mDice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickDie(mDice3, 3);
            }
        });

        mDice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickDie(mDice4, 4);
            }
        });

        mDice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickDie(mDice5, 5);
            }
        });

        mDice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onClickDie(mDice6, 6);
            }
        });


        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.onItemSelected(parent, view, position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });

    }

    @Override
    public void setViewData(String data) {
        mTextView.setText(data);
    }

    @Override
    public void setDices(int [] diceDrawable) {

        mDice1.setImageResource(diceDrawable[0]);
        mDice2.setImageResource(diceDrawable[1]);
        mDice3.setImageResource(diceDrawable[2]);
        mDice4.setImageResource(diceDrawable[3]);
        mDice5.setImageResource(diceDrawable[4]);
        mDice6.setImageResource(diceDrawable[5]);
    }

    @Override
    public void setDieHoldImage(ImageView imageView, int dieDrawable) {
     imageView.setImageResource(dieDrawable);
    }


}
