package com.example.secondkotlin.viewmodel.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.secondkotlin.R
import com.example.secondkotlin.databinding.FragmentABinding
import com.example.secondkotlin.viewmodel.bean.User
import com.example.secondkotlin.viewmodel.model.MyViewModel

class MyFragment() : Fragment(R.layout.fragment_a) {
    private var viewModel :MyViewModel ? = null
    private lateinit var binding: FragmentABinding
    var id: Int? = null
    var name: String? = null
    var age: Int? = null


    var fragment2: MyFragment2 ? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = MyFragmentViewModelFactory()
        viewModel = ViewModelProvider(this.activity!!,factory).get(MyViewModel::class.java)
        binding = FragmentABinding.bind(view)

        var fragment: Fragment? = parentFragmentManager.findFragmentByTag("a")
        if (fragment2 == null){
            fragment2 = MyFragment2()
        }
        var frag = parentFragmentManager.findFragmentByTag("b")
        binding.btnJumpA.setOnClickListener {
            if (fragment != null) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, fragment2!!, "b")
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
                Log.i("JumpListener","jump to b")
            }else{
                parentFragmentManager.beginTransaction().replace(R.id.frame_layout,fragment2!!,"b").addToBackStack(null).commitAllowingStateLoss()
                Log.i("JumpListener","jump to b")
            }
        }
        //add
        binding.btnFrA1.setOnClickListener {
            var id =binding.editTextTextPersonName2.text.toString().toInt()
            var name =binding.editTextTextPersonName3.text.toString()
            var age =binding.editTextTextPersonName4.text.toString().toInt()
            val user = User(id, name, age)
            if (viewModel!!.addUser(user)){
                Toast.makeText(view.context,"success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(view.context,"failure,has add", Toast.LENGTH_SHORT).show()
            }
        }
        //remove
        binding.btnFrA2.setOnClickListener {
            var id =binding.editTextTextPersonName2.text
            if (viewModel!!.remove(id.toString().toInt())){
                Toast.makeText(view.context,"success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(view.context,"failure,不存在", Toast.LENGTH_SHORT).show()
            }
        }
        //query
        binding.btnFrA3.setOnClickListener {
            var id =binding.editTextTextPersonName2.text.toString().toInt()
            var user = viewModel!!.query(id)
            if (user != null) {
                binding.editTextTextPersonName3.setText(user.name.toCharArray(), 0, user.name.length)
                binding.editTextTextPersonName4.setText(user.age.toString().toCharArray(), 0, user.age.toString().length)
                Toast.makeText(view.context, "success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(view.context, "failure,不存在", Toast.LENGTH_SHORT).show()
            }
        }
        //count
        binding.btnFrA4.setOnClickListener {
            binding.tvFrA.text = viewModel!!.getCount().toString()
            Toast.makeText(view.context, "success", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Fragment","onAttach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Fragment","onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Fragment","onDetach")
    }
}