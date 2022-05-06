package com.example.a6

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a6.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), ItemAdapter.CellClickListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 4)
        recyclerView.adapter = ItemAdapter(this, fetchList(), this)
    }

    private fun fetchList(): ArrayList<DataModel> {
        val list = arrayListOf<DataModel>()
        val rnd = Random()

        for (i in 0..99) {
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            val random = (0..99).random()
            val model = DataModel( "$random","$color")
            list.add(model)
        }
        return list
    }

    override fun onCellClickListener(data: DataModel) {
//        Toast.makeText(this,data.value, Toast.LENGTH_SHORT).show()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Number")
        builder.setMessage(data.value)

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
        }
        builder.show()
    }
}