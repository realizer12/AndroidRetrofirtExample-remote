package com.example.leedonghun.androidretrofitexample.Activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.leedonghun.androidretrofitexample.R

/**
 * AndroidRetrofitExample
 * Class: SeconActivity.
 * Created by leedonghun.
 * Created On 2020-04-26.
 * Description: 두번째
 */
class SeconActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.second_activity)

        Log.v("check",localClassName+"의 oncreate() 실행됨")
        Toast.makeText(this,"second엑티비티",Toast.LENGTH_SHORT).show()



    }



}




