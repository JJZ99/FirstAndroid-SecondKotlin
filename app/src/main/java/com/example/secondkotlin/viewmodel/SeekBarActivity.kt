package com.example.secondkotlin.viewmodel

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.secondkotlin.databinding.ActivitySeekBarBinding
import com.example.secondkotlin.viewmodel.bean.User
import com.example.secondkotlin.viewmodel.model.MyViewModel
import com.example.secondkotlin.viewmodel.view.MyFragment
import com.example.secondkotlin.viewmodel.view.MyFragment2


class SeekBarActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySeekBarBinding

    var fragment1 : MyFragment ? = null
    var fragment2 : MyFragment2? = null
    private var viewModel :MyViewModel ? = null

    var mContext: Context ? = null
    init {
        fragment1 = MyFragment()
        fragment2 = MyFragment2()
        fragment1?.fragment2 = fragment2
        fragment2?.fragment1 = fragment1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeekBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //如果没有引入是这样创建的
        //var view = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application).get(MyViewModel::class.java)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        //给viewmodel中的number设置观察  当值发生变化时就会更新textview,这里我们不需要这个,设置输出日志就行
        viewModel?.userMess?.observe(this, Observer {
            Log.i("Observer", "--list Change--")

        })

        supportFragmentManager.beginTransaction().replace(binding.frameLayout.id,fragment1!! ,"a").addToBackStack(null).commitAllowingStateLoss()
        mContext = this

        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textviewseekbar.text = "Now percent:${progress}/100"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(mContext, "Start", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(mContext, "stop", Toast.LENGTH_SHORT).show()
            }
        })



        //add
        binding.btnSeek1.setOnClickListener {
            var id =binding.editTextTextPersonName2.text.toString().toInt()
            var name =binding.editTextTextPersonName3.text.toString()
            var age =binding.editTextTextPersonName4.text.toString().toInt()
            val user = User(id, name,age)
            if (viewModel!!.addUser(user)){
                Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"failure,has add",Toast.LENGTH_SHORT).show()
            }
        }

        //remove
        binding.btnSeek2.setOnClickListener {
            var id =binding.editTextTextPersonName2
            if (viewModel!!.remove(id.toString().toInt())){
                Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"failure,不存在",Toast.LENGTH_SHORT).show()
            }
        }

        //query
        binding.btnSeek3.setOnClickListener {
            var id = binding.editTextTextPersonName2.text
            var user = viewModel!!.query(id.toString().toInt())
            if (user != null) {
                binding.editTextTextPersonName3.setText(user.name.toCharArray(), 0, user.name.length)
                binding.editTextTextPersonName4.setText(user.age.toString().toCharArray(), 0, user.age.toString().length)
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "failure,不存在", Toast.LENGTH_SHORT).show()
            }
        }
    }
}