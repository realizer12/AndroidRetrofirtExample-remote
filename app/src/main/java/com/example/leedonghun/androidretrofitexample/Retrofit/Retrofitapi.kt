package com.example.leedonghun.androidretrofitexample.Retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * AndroidRetrofitExample
 * Class: Retrofitapi.
 * Created by leedonghun.
 * Created On 2020-04-23.
 * Description: retrofit api
 */
interface Retrofitapi {

    companion object{
      val baseurl:String ="http://13.209.249.1/"
    }

    @FormUrlEncoded
    @POST("show_me_mask/retrofitExample.php")
    fun get_uid(
        @Field("uid") uid:String
    ): Call<String>

}//Retrofitapi끝