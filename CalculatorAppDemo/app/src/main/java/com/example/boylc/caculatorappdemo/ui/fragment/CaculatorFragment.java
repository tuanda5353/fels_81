package com.example.boylc.caculatorappdemo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boylc.caculatorappdemo.R;
import com.example.boylc.caculatorappdemo.ui.activity.MainActivity;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaculatorFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = "CaculatorFragment";
    private static OnDataPass dataPasser;
    private TextView mTextInputNumber;
    private TextView mTextResult;
    private TextView mTextInputAc;
    private TextView mTextInputMod;
    private TextView mTextInputDivide;
    private TextView mTextInputSeven;
    private TextView mTextInputEight;
    private TextView mTextInputNine;
    private TextView mTextInputMulti;
    private TextView mTextInputFour;
    private TextView mTextInputFive;
    private TextView mTextInputSix;
    private TextView mTextInputSubtract;
    private TextView mTextInputOne;
    private TextView mTextInputTwo;
    private TextView mTextInputThree;
    private TextView mTextInputAdd;
    private TextView mTextInputZezo;
    private TextView mTextInputDot;
    private TextView mTextInputResult;


    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;
    private DecimalFormat decimalFormat;
    public CaculatorFragment() {

        // Required empty public constructor
    }
    public static CaculatorFragment newInstance(String data) {
        CaculatorFragment caculatorFragment = new CaculatorFragment();
        Bundle args = new Bundle();
        args.putString(MainActivity.RESULT, data);
        caculatorFragment.setArguments(args);
        return caculatorFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_caculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initListener();
        initVariable();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataPasser = (OnDataPass) context;
    }


    @Override
    public void onClick(View v) {
        String textInput = mTextInputNumber.getText().toString();
        StringBuilder stringBuilder = new StringBuilder();
        switch (v.getId()) {
            case R.id.text_input_ac:
                clearData();
                break;
            case R.id.text_input_dot:
                stringBuilder.append(textInput).append(getResources().getString(R.string.dot));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_zezo:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_zezo));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_one:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_one));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_two:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_two));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_three:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_three));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_four:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_four));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_five:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_five));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_six:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_six));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_seven:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_seven));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_eight:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_eight));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_nine:
                stringBuilder.append(textInput).append(getResources().getString(R.string.number_nine));
                mTextInputNumber.setText(stringBuilder.toString());
                break;
            case R.id.text_input_add:
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                stringBuilder.append(decimalFormat.format(valueOne)).append(getResources().getString(R.string.addition));
                mTextResult.setText(stringBuilder.toString());
                mTextInputNumber.setText(null);
                break;
            case R.id.text_input_subtract:
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                stringBuilder.append(decimalFormat.format(valueOne)).append(getResources().getString(R.string.subtraction));
                mTextResult.setText(stringBuilder.toString());
                mTextInputNumber.setText(null);
                break;
            case R.id.text_input_multi:
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                stringBuilder.append(decimalFormat.format(valueOne)).append(getResources().getString(R.string.mutiplication));
                mTextResult.setText(stringBuilder.toString());
                mTextInputNumber.setText(null);
                break;
            case R.id.text_input_divide:
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                stringBuilder.append(decimalFormat.format(valueOne)).append(getResources().getString(R.string.division));
                mTextResult.setText(stringBuilder.toString());
                mTextInputNumber.setText(null);
                break;
            case R.id.text_input_mod:

                break;
            case R.id.text_input_result:
                computeCalculation();
                mTextResult.setText(mTextResult.getText().toString() +
                        decimalFormat.format(valueTwo)
                        + " = "
                        + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
                break;
            default:
                break;
        }
    }

    private void initViews(View view) {
        mTextInputNumber = view.findViewById(R.id.text_input_number);
        mTextResult = view.findViewById(R.id.text_result);
        mTextInputAc = view.findViewById(R.id.text_input_ac);
        mTextInputMod = view.findViewById(R.id.text_input_mod);
        mTextInputDivide = view.findViewById(R.id.text_input_divide);
        mTextInputSeven = view.findViewById(R.id.text_input_seven);
        mTextInputEight = view.findViewById(R.id.text_input_eight);
        mTextInputNine = view.findViewById(R.id.text_input_nine);
        mTextInputMulti = view.findViewById(R.id.text_input_multi);
        mTextInputFour = view.findViewById(R.id.text_input_four);
        mTextInputFive = view.findViewById(R.id.text_input_five);
        mTextInputSix = view.findViewById(R.id.text_input_six);
        mTextInputSubtract = view.findViewById(R.id.text_input_subtract);
        mTextInputOne = view.findViewById(R.id.text_input_one);
        mTextInputTwo = view.findViewById(R.id.text_input_two);
        mTextInputThree = view.findViewById(R.id.text_input_three);
        mTextInputAdd = view.findViewById(R.id.text_input_add);
        mTextInputZezo = view.findViewById(R.id.text_input_zezo);
        mTextInputDot = view.findViewById(R.id.text_input_dot);
        mTextInputResult = view.findViewById(R.id.text_input_result);
    }

    private void initListener() {
        mTextInputZezo.setOnClickListener(this);
        mTextInputOne.setOnClickListener(this);
        mTextInputTwo.setOnClickListener(this);
        mTextInputThree.setOnClickListener(this);
        mTextInputFour.setOnClickListener(this);
        mTextInputFive.setOnClickListener(this);
        mTextInputSix.setOnClickListener(this);
        mTextInputSeven.setOnClickListener(this);
        mTextInputEight.setOnClickListener(this);
        mTextInputNine.setOnClickListener(this);
        mTextInputAdd.setOnClickListener(this);
        mTextInputSubtract.setOnClickListener(this);
        mTextInputMulti.setOnClickListener(this);
        mTextInputDivide.setOnClickListener(this);
        mTextInputResult.setOnClickListener(this);
        mTextInputMod.setOnClickListener(this);
        mTextInputAc.setOnClickListener(this);
        mTextInputDot.setOnClickListener(this);
    }

    private void initVariable() {
        decimalFormat = new DecimalFormat("#.##########");
        setLastResult();
    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(mTextInputNumber.getText().toString());
            mTextInputNumber.setText(null);

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(mTextInputNumber.getText().toString());
            } catch (Exception e) {

            }
        }
    }

    public void clearData() {
        mTextResult.setText("");
        mTextInputNumber.setText("");
    }

    public void passData() {
        dataPasser.onDataPass(mTextResult.getText().toString());
    }

    public void setLastResult() {
        String lastResult = getArguments().getString(MainActivity.RESULT, "");
        mTextResult.setText(lastResult);
    }

    public interface OnDataPass {
        public void onDataPass(String data);
    }
}
