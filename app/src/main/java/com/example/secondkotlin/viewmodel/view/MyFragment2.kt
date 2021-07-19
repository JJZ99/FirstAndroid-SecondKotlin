package com.example.secondkotlin.viewmodel.view

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.secondkotlin.R
import com.example.secondkotlin.databinding.FragmentBBinding
import com.example.secondkotlin.viewmodel.bean.User
import com.example.secondkotlin.viewmodel.model.MyViewModel

class MyFragment2() : Fragment(){
    private lateinit var binding : FragmentBBinding

    private var viewModel :MyViewModel ? = null
    private lateinit var factory: MyFragmentViewModelFactory
    var id: Int? = null
    var name: String? = null
    var age: Int? = null

    var fragment1: MyFragment ? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        Log.d("fragment2","...onCreateView...")

        binding = FragmentBBinding.inflate(inflater,container,false)
        //获取viewmodel，this.activity是获得这个fragment的宿主activity，因为在activity页面中viewmodel已经和这个
        //activity绑定了，那么我们通过activity可以拿到这个viewmodel。同理我们也可以在 activity 中通过fragment获取viewmodel，
        //activity或者fragment都可以。此外我们可能有很多个viewmodel，我们就要根据::class类型来确定是哪个viewmodel

        factory = MyFragmentViewModelFactory()

        viewModel = ViewModelProvider(this.activity!!,factory).get(MyViewModel::class.java)
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        id = binding.editTextTextPersonName2.text.toString().toInt()
        name = binding.editTextTextPersonName3.text.toString()
        age = binding.editTextTextPersonName4.text.toString().toInt()

        outState.putInt("id",id!!)
        outState.putString("name",name)
        outState.putInt("age",age!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (savedInstanceState != null) {
            binding.editTextTextPersonName2.text = savedInstanceState.get("id") as Editable?
            binding.editTextTextPersonName3.text = savedInstanceState.get("name") as Editable?
            binding.editTextTextPersonName4.text = savedInstanceState.get("age") as Editable?
        }
        val jump = view.findViewById<Button>(R.id.btn_jump_b)
        var fragment: Fragment? = parentFragmentManager.findFragmentByTag("b")
        if (fragment1 == null) {
            fragment1 = MyFragment()
        }
        jump.setOnClickListener {
            if (fragment != null) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, fragment1!!, "a")
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
                Log.i("JumpListener", "jump to a")
            } else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, fragment1!!, "a").addToBackStack(null)
                    .commitAllowingStateLoss()
                Log.i("JumpListener", "jump to a")
            }
        }
        //add
        view.findViewById<Button>(R.id.btn_fr_b1).setOnClickListener {

            var id =binding.editTextTextPersonName2.text.toString().toInt()
            var name =binding.editTextTextPersonName3.text.toString()
            var age =binding.editTextTextPersonName4.text.toString().toInt()
            val user = User(id, name, age)
            if (viewModel!!.addUser(user)) {
                Toast.makeText(view.context, "success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(view.context, "failure,has add", Toast.LENGTH_SHORT).show()
            }
        }
        //remove
        view.findViewById<Button>(R.id.btn_fr_b2).setOnClickListener {
            var id = binding.editTextTextPersonName2.text
            if (viewModel!!.remove(id.toString().toInt())) {
                Toast.makeText(view.context, "success", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(view.context, "failure,不存在", Toast.LENGTH_SHORT).show()
            }

        }
        //query
        view.findViewById<Button>(R.id.btn_fr_b3).setOnClickListener {
            var id =binding.editTextTextPersonName2.text.toString().toInt()
            var user = viewModel?.query(id)
            if (user != null) {
                binding.editTextTextPersonName3.setText(user.name.toCharArray(), 0, user.name.length)
                binding.editTextTextPersonName4.setText(user.age.toString().toCharArray(), 0, user.age.toString().length)
                Toast.makeText(view.context, "success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(view.context, "failure,不存在", Toast.LENGTH_SHORT).show()
            }
        }

        //count
        view.findViewById<Button>(R.id.btn_fr_b4).setOnClickListener {
            view.findViewById<TextView>(R.id.tv_fr_b).text = viewModel!!.getCount().toString()
            Toast.makeText(view.context, "success", Toast.LENGTH_SHORT).show()
        }
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Fragment2","onAttach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Fragment2","onDestroy")

    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Fragment2","onDetach")

    }
}