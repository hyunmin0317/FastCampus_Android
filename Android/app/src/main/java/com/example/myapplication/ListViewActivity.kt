package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carList.add(CarForList(""+i+"번째 자동차", ""+i+"순위 엔진"))
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter = adapter

        // Listener 달기
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this@ListViewActivity, carName+" "+carEngine, Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(
    val carForList: ArrayList<CarForList>,
    val layoutInflater: LayoutInflater
) : BaseAdapter() {

    // 그리고자 하는 아이템 리스트의 전체 갯수
    override fun getCount(): Int {
        return carForList.size
    }

    // 그리고자 하는 아이템 리스트의 하나(포지션에 해당하는)
   override fun getItem(position: Int): Any {
        return carForList.get(position)
    }

    // 해당 포지션에 위치해 있는 아이템뷰의 아이디 설정
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        ViewHolder 미사용
//        val view = layoutInflater.inflate(R.layout.item_view, null)
//        val carNameTextview = view.findViewById<TextView>(R.id.car_name)
//        val carEngineTextview = view.findViewById<TextView>(R.id.car_engine)
//
//        carNameTextview.setText(carForList.get(position).name)
//        carEngineTextview.setText(carForList.get(position).engine)
//        return view

        val view : View
        val holder : ViewHolder

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()

            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

        return view
    }
}

class ViewHolder{
    var carName: TextView? = null
    var carEngine: TextView? = null
}