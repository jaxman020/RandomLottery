package com.example.randomlottery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SimpleAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var from = arrayOf("title","num0","num1","num2","num3","num4","num5")
    private var to = intArrayOf(R.id.itemTitle,R.id.item_num0,R.id.item_num1,R.id.item_num2,R.id.item_num3,R.id.item_num4,R.id.item_num5)
    private var data = LinkedList<HashMap<String, String>>()
    private lateinit var adapter : SimpleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {


        adapter = SimpleAdapter(this, data, R.layout.item, from, to)
        list.adapter = adapter
    }

    fun random(view: View){
        var row = HashMap<String, String>()
        row.put(from[0], "第" + (data.size + 1) + "組")

        var i = 1
        createLottery().forEach {
            row.put(from[i], it.toString())
            i++
        }

        data.add(row)

        adapter.notifyDataSetChanged()

        list.smoothScrollToPosition(data.size-1)
    }

    private fun createLottery() :IntArray{
        var hashSet = HashSet<Int>()
        var ans = IntArray(6)
        var i = 0
        while (hashSet.size < 6){
            hashSet.add(Random.nextInt(1, 49))
        }

        for (aa in hashSet) {
            ans[i] = aa
            i++
        }

        return ans
    }
}
