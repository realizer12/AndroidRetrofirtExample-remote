package com.example.leedonghun.androidretrofitexample.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.leedonghun.androidretrofitexample.R
import com.example.leedonghun.androidretrofitexample.Retrofit.Retrofitapi
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//메인 프로젝트를  하면 프로그램 진행한다.
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //서버에서  해당 원하는 값을 가져올때 사용한다.
        get_btn.setOnClickListener {

            SearchRetrofit.getService().get_uid("25").enqueue(object :Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {

                    //response successful
                    if(response.isSuccessful){

                        Log.v("check11111",response.body())
                        text_for_show_result.setText(response.body())

                    }

                }//onResponse()끝



                override fun onFailure(call: Call<String>, t: Throwable) {

                    Log.v("check1111",t.message)
                    text_for_show_result.setText(null)

                }//onFailure()끝

            })//SearchRetrofit끝

        }//get_btn 끝



        //두번째 버튼  클릭 리스너
        second_move_btn.setOnClickListener {

            val intent1=Intent(this, SeconActivity::class.java)
            startActivity(intent1)// 두번째  엑티비티로 넘어간다.

        }

        //두번째 이동 버튼
        second_move_btn.setOnClickListener {

            val intent=Intent(this,SeconActivity::class.java)
            startActivity(intent)

        }

    }//onCreate() 끝


     override fun onResume() {
        super.onResume()
         Log.v("check",localClassName+"의  onResume()실행")

        text_for_show_result.setText("sdad")

     }

    override fun onStart() {
        super.onStart()
        Log.v("check",localClassName+"의  onstart()실행")

    }


    object SearchRetrofit {
        // 위에서 만든 RetrofitService를 연결해줍니다.
        fun getService(): Retrofitapi = retrofit.create(
            Retrofitapi::class.java)

        var gson = GsonBuilder()
            .setLenient()
            .create()

        private val retrofit =
            Retrofit.Builder()
             .baseUrl(Retrofitapi.baseurl)
             .addConverterFactory(GsonConverterFactory.create(gson))
             .build()

    }


}//MainActivity 끝
