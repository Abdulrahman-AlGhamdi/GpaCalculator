package com.ss.gpacalculator.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.ss.gpacalculator.R;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SemesterCalculateFragment extends Fragment {

    // Views
    private View view;
    private LinearLayout mSubject;
    private int[] mGradeArray, mCreditArray;
    private Button mAdd, mRemove, mCalculate;

    // Functions
    private Dialog Dialog;
    private int RawPosition = 0;
    private double TotalScore, TotalCredit;
    private List<Double> GradeList, CreditList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_semester_calculate, container, false);

        init();
        RevealRow();
        Calculate();

        return view;
    }

    private void init(){
        GradeList = new ArrayList<>();
        CreditList = new ArrayList<>();
        Dialog = new Dialog(Objects.requireNonNull(getActivity()));
        mAdd = view.findViewById(R.id.Add);
        mRemove = view.findViewById(R.id.Remove);
        mCalculate = view.findViewById(R.id.Calculate);
        mGradeArray = new int[] {R.id.Grade1, R.id.Grade2, R.id.Grade3, R.id.Grade4, R.id.Grade5,
                R.id.Grade6, R.id.Grade7, R.id.Grade8, R.id.Grade9};
        mCreditArray = new int[] {R.id.Credit1, R.id.Credit2, R.id.Credit3, R.id.Credit4, R.id.Credit5,
                R.id.Credit6, R.id.Credit7, R.id.Credit8, R.id.Credit9};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_row_layout, getResources().getStringArray(R.array.Grades)) {
            @Override
            public int getCount() {
                return super.getCount() - 1;
            }
        };
        for (int GradeID : mGradeArray) {
            Spinner Grade = view.findViewById(GradeID);
            Grade.setAdapter(adapter);
            Grade.setSelection(adapter.getCount());
        }
        Animation AnimationFromButton = AnimationUtils.loadAnimation(getActivity(), R.anim.animation_from_button);
        mRemove.setAnimation(AnimationFromButton);
        mAdd.setAnimation(AnimationFromButton);
        mCalculate.setAnimation(AnimationFromButton);
        mCalculate.setEnabled(false);
    }

    private void RevealRow(){

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RawPosition < 9 && RawPosition >= 0){

                    RawPosition +=1;

                    if (RawPosition == 1) {
                        mSubject = view.findViewById(R.id.Subject1);
                        mSubject.setVisibility(View.VISIBLE);
                    }
                    if (RawPosition == 2) {
                        mSubject = view.findViewById(R.id.Subject2);
                        mSubject.setVisibility(View.VISIBLE);
                    }
                    if (RawPosition == 3) {
                        mSubject = view.findViewById(R.id.Subject3);
                        mSubject.setVisibility(View.VISIBLE);
                    }
                    if (RawPosition == 4) {
                        mSubject = view.findViewById(R.id.Subject4);
                        mSubject.setVisibility(View.VISIBLE);
                    }
                    if (RawPosition == 5) {
                        mSubject = view.findViewById(R.id.Subject5);
                        mSubject.setVisibility(View.VISIBLE);
                    }
                    if (RawPosition == 6) {
                        mSubject = view.findViewById(R.id.Subject6);
                        mSubject.setVisibility(View.VISIBLE);
                    }
                    if (RawPosition == 7) {
                        mSubject = view.findViewById(R.id.Subject7);
                        mSubject.setVisibility(View.VISIBLE);
                    }
                    if (RawPosition == 8) {
                        mSubject = view.findViewById(R.id.Subject8);
                        mSubject.setVisibility(View.VISIBLE);
                    }
                    if (RawPosition == 9) {
                        mSubject = view.findViewById(R.id.Subject9);
                        mSubject.setVisibility(View.VISIBLE);
                    }
                }

                if(RawPosition == 0){
                    mCalculate.setEnabled(false);
                }else{
                    mCalculate.setEnabled(true);
                }
            }
        });

        mRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(RawPosition <= 9 && RawPosition > 0){

                    RawPosition -=1;

                    if (RawPosition == 0) {
                        mSubject = view.findViewById(R.id.Subject1);
                        mSubject.setVisibility(View.INVISIBLE);
                    }
                    if (RawPosition == 1) {
                        mSubject = view.findViewById(R.id.Subject2);
                        mSubject.setVisibility(View.INVISIBLE);
                    }
                    if (RawPosition == 2) {
                        mSubject = view.findViewById(R.id.Subject3);
                        mSubject.setVisibility(View.INVISIBLE);
                    }
                    if (RawPosition == 3) {
                        mSubject = view.findViewById(R.id.Subject4);
                        mSubject.setVisibility(View.INVISIBLE);
                    }
                    if (RawPosition == 4) {
                        mSubject = view.findViewById(R.id.Subject5);
                        mSubject.setVisibility(View.INVISIBLE);
                    }
                    if (RawPosition == 5) {
                        mSubject = view.findViewById(R.id.Subject6);
                        mSubject.setVisibility(View.INVISIBLE);
                    }
                    if (RawPosition == 6) {
                        mSubject = view.findViewById(R.id.Subject7);
                        mSubject.setVisibility(View.INVISIBLE);
                    }
                    if (RawPosition == 7) {
                        mSubject = view.findViewById(R.id.Subject8);
                        mSubject.setVisibility(View.INVISIBLE);
                    }
                    if (RawPosition == 8) {
                        mSubject = view.findViewById(R.id.Subject9);
                        mSubject.setVisibility(View.INVISIBLE);
                    }
                }

                if(RawPosition == 0){
                    mCalculate.setEnabled(false);
                }else{
                    mCalculate.setEnabled(true);
                }
            }
        });
    }

    private void Calculate(){

        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int CreditID : mCreditArray) {
                    double CreditValue;
                    EditText Credit = view.findViewById(CreditID);
                    String CreditString = Credit.getText().toString();
                    if (CreditString.trim().equals("")) {
                        CreditValue = 0.0;
                    }else{
                        CreditValue = Double.parseDouble(CreditString);
                    }
                    CreditList.add(CreditValue);
                }

                for (int GradeID : mGradeArray) {
                    Spinner Grade = view.findViewById(GradeID);
                    String GradeString = Grade.getSelectedItem().toString();
                    final double GradeValue;

                    if (GradeString.trim().equals("")) {
                        GradeValue = 0;
                    } else if (GradeString.equals("A+")) {
                        GradeValue = 5;
                    } else if (GradeString.equals("A")) {
                        GradeValue = 4.75;
                    } else if (GradeString.equals("B+")) {
                        GradeValue = 4.5;
                    } else if (GradeString.equals("B")) {
                        GradeValue = 4;
                    } else if (GradeString.equals("C+")) {
                        GradeValue = 3.5;
                    } else if (GradeString.equals("C")) {
                        GradeValue = 3;
                    } else if (GradeString.equals("D+")) {
                        GradeValue = 2.5;
                    } else if (GradeString.equals("D")) {
                        GradeValue = 2;
                    } else if (GradeString.equals("F")) {
                        GradeValue = 1;
                    } else {
                        GradeValue = 0;
                    }
                    GradeList.add(GradeValue);
                }

                Result();
            }
        });
    }

    private void Result() {

        for (int i = 0; i < RawPosition; i++) {
            double Grade = GradeList.get(i);
            double Credit = CreditList.get(i);
            if (Grade > 0){
                double Score = (Credit*Grade);
                TotalCredit += Credit;
                TotalScore += Score;
            } else {
                TotalCredit += 0;
                TotalScore += 0;
            }
        }

        double GPA = (TotalScore / TotalCredit);

        if(String.valueOf(GPA).equals("NaN")){
            GPA = 0;
        }

        TotalCredit = 0.0;
        TotalScore = 0.0;
        GradeList.clear();
        CreditList.clear();

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Dialog.setContentView(R.layout.result_popup_massege);
        TextView ResultGPA = Dialog.findViewById(R.id.ResultGPA);
        ResultGPA.setText(decimalFormat.format(GPA));
        Objects.requireNonNull(Dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Dialog.show();
    }
}
