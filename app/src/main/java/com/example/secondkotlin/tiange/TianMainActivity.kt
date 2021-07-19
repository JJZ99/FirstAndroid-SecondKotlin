package com.example.secondkotlin.tiange

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.R
import com.example.secondkotlin.databinding.ActivityMainTiangeBinding

/**
 * 页面跳转
 */
class TianMainActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var binder: ActivityMainTiangeBinding

    val gridView : GridView by lazy {
        findViewById(R.id.btn_gv)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainTiangeBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.btnCheckbox.setOnClickListener{
            //val intent: Intent = Intent(this.application,CheckBoxActivity::class.java)
            val intent: Intent = Intent(this.baseContext,CheckBoxActivity::class.java)
            //val intent: Intent = Intent(this@MainActivity,CheckBoxActivity::class.java)


            //val intent: Intent = Intent(this,CheckBoxActivity().javaClass)
            //val intent: Intent = Intent(this,CheckBoxActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_gv -> Toast.makeText(this,"hhh",Toast.LENGTH_SHORT).show()



        }
    }



}

