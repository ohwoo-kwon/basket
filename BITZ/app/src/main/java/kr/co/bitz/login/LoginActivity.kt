package kr.co.bitz.login

import android.app.VoiceInteractor
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.co.bitz.databinding.ActivityLoginBinding
import kr.co.bitz.home.MainActivity
import kr.co.bitz.service.BitzService
import kr.co.bitz.service.LoginBody
import kr.co.bitz.service.Service
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var loginbody : LoginBody
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val loginbody = listOf<String>()
        val username = binding.editTextTextPersonName7.toString()
        val password = binding.editTextTextPersonName.text.toString()
        val passwordConfirmation = binding.editTextTextPersonName2.text.toString()
        val firts_name = binding.editTextTextPersonName3.text.toString()
        val last_name = binding.editTextTextPersonName4.text.toString()
        val phone_number = binding.editTextTextPersonName5.text.toString()
        val birth = binding.editTextTextPersonName6.text.toString()

        binding.button2.setOnClickListener {
            val loginbody = listOf<String>()
            val username = binding.editTextTextPersonName7.toString()
            val password = binding.editTextTextPersonName.text.toString()
            val passwordConfirmation = binding.editTextTextPersonName2.text.toString()
            val firts_name = binding.editTextTextPersonName3.text.toString()
            val last_name = binding.editTextTextPersonName4.text.toString()
            val phone_number = binding.editTextTextPersonName5.text.toString()
            val birth = binding.editTextTextPersonName6.text.toString()

            BitzService.invoke(this).servicelogin(username,password,passwordConfirmation,firts_name,last_name,phone_number,birth)
                ?.enqueue(object :Callback<Service>{

                })

            }

        BitzService.invoke(this).servicelogin(username,password,passwordConfirmation,firts_name,last_name,phone_number,birth)
            .
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({//요청이 성공한다면
//                    startActivity(Intent(this,MainActivity::class.java))
//                },{
//                    //요청실패시
//                    Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
//                })
////            if (/*로그인이 성공한다면*/){
//                startActivity(Intent(this, MainActivity::class.java))
//        }

    }
    private fun setitem(){
        val loginbody = LoginBody()
        val username = binding.editTextTextPersonName7.text.toString()
        loginbody.password = binding.editTextTextPersonName.text.toString()
        loginbody.passwordConfirmation = binding.editTextTextPersonName2.text.toString()
        loginbody.firts_name = binding.editTextTextPersonName3.text.toString()
        loginbody.last_name = binding.editTextTextPersonName4.text.toString()
        loginbody.phone_number = binding.editTextTextPersonName5.text.toString()
        loginbody.birth = binding.editTextTextPersonName6.text.toString()


    }
}