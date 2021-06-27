package kr.co.bitz.service

import android.content.Context
import android.util.Log
import android.widget.EditText
import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit
import okhttp3.Interceptor
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import kotlin.collections.HashMap as HashMap

/**
 * @author user15
 * @email silmxmail@naver.com
 * @created 2021-06-27
 * @desc
 */

private const val TARGET_ADDRESS = "http://127.0.0.1:8000/"
interface BitzService {

    @Headers("Content-Type: application/json")
    @POST("/api/member")
    fun servicelogin(
        @Body login : LoginBody
//        @Field("username") username: String,
//        @Field("password") password: String,
//        @Field("last_name") last_name: String,
//        @Field("firts_name") firts_name: String,
//        @Field("phone_number") phone_number: String,
//        @Field("birth") birth: String,
//        @Field("passwordConfirmation") passwordConfirmation: String
    ) : Call<Service>

//    @GET("api/notice")
//    fun getNotice(
//    ) : Single<NotifyResponse>

    companion object {
        private var _bitzservice : BitzService? = null
        private val bitzservice : BitzService get() = _bitzservice!!

        operator fun invoke(context: Context) : BitzService {
            if(_bitzservice != null) {
                return bitzservice
            } else {
                val requestInterceptor = Interceptor { chain ->
                    val url = chain.request()
                        .url()
                        .newBuilder()
                        .build()
                    val request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()
                    Log.e("[TEST]", "$url")
                    return@Interceptor chain.proceed(request)
                }
                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(NoConnectionInterceptor.getInstance(context))
                    .addInterceptor(requestInterceptor)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build()
                val gson = GsonBuilder()
                    .setLenient()
                    .create()
                _bitzservice = Retrofit.Builder()
                    .client(okHttpClient)
                    // .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(TARGET_ADDRESS)
                    .build()
                    .create(BitzService::class.java)
                return bitzservice
            }
        }
    }
}
