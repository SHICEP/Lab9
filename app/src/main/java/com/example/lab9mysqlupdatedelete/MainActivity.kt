package com.example.lab9mysqlupdatedelete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    var studentList = arrayListOf<Student>()
    val createClient = StudentAPI.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.addItemDecoration(DividerItemDecoration(recycler_view.getContext(),DividerItemDecoration.VERTICAL))

        recycler_view.addOnItemTouchListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                Toast.makeText(
                    applicationContext, "You click on :" + studentList[position]
                            Toast . LENGTH_SHORT
                ).show()
                val std = studentList[position]
                val intent = Intent(applicationContext, EditStudentsActivity::class.java)
                intent.putExtra("mId", std_id)
                intent.putExtra("mName", std_name)
                intent.putExtra("mAge", std_age.toString())
                startActivity(intent)
            }

        })
        override fun onResume() {
            super.onResume()
            callStudentData()
        }
        fun clickSearch(v:View){
            studentList.retrieveStudentID
        }
    }
}
