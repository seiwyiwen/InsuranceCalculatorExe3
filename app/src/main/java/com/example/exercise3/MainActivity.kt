package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var premiumModel:PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        premiumModel = ViewModelProviders.of(this).get(PremiumModel::class.java)

        buttonReset.setOnClickListener(){
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            checkBoxSmoker.setChecked(false)
            textView4.text = ""
        }

        buttonCalculate.setOnClickListener(){
            var premium = 0;
            var extraMale= 0;
            var extraSmoker = 0;
            if(spinnerAge.selectedItemPosition == 0){
                premium = 60;
            }else if(spinnerAge.selectedItemPosition == 1){
                premium = 70;
                if(radioGroupGender.checkedRadioButtonId == radioButtonMale.id){
                    extraMale = 50
                }
                if(checkBoxSmoker.isChecked == true){
                    extraSmoker =100;
                }
            }else if(spinnerAge.selectedItemPosition == 2){
                premium = 90;
                if(radioGroupGender.checkedRadioButtonId == radioButtonMale.id){
                    extraMale = 100
                }
                if(checkBoxSmoker.isChecked == true){
                    extraSmoker =150;
                }
            }else if(spinnerAge.selectedItemPosition == 3){
                premium = 120;
                if(radioGroupGender.checkedRadioButtonId == radioButtonMale.id){
                    extraMale = 150
                }
                if(checkBoxSmoker.isChecked == true){
                    extraSmoker =200;
                }
            }else if(spinnerAge.selectedItemPosition == 4){
                premium = 150;
                if(radioGroupGender.checkedRadioButtonId == radioButtonMale.id){
                    extraMale = 200
                }
                if(checkBoxSmoker.isChecked == true){
                    extraSmoker =250;
                }
            }else if(spinnerAge.selectedItemPosition == 5){
                premium = 150;
                if(radioGroupGender.checkedRadioButtonId == radioButtonMale.id){
                    extraMale = 200
                }
                if(checkBoxSmoker.isChecked == true){
                    extraSmoker =300;
                }
            }else{

            }
            var total = premium +extraMale +extraSmoker;
//
            premiumModel.premium = total.toString().toDouble()
            textView4.text = "RM"+ premiumModel.premium
        }
        textView4.text = "RM"+ premiumModel.premium
    }
}
