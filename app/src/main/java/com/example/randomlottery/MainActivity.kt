package com.example.randomlottery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var l1TV : ArrayList<TextView>
    val l1 = intArrayOf(R.id.l1num0, R.id.l1num1, R.id.l1num2, R.id.l1num3, R.id.l1num4, R.id.l1num5)
    lateinit var l2TV : ArrayList<TextView>
    val l2 = intArrayOf(R.id.l2num0, R.id.l2num1, R.id.l2num2, R.id.l2num3, R.id.l2num4, R.id.l2num5)
    lateinit var l3TV : ArrayList<TextView>
    val l3 = intArrayOf(R.id.l3num0, R.id.l3num1, R.id.l3num2, R.id.l3num3, R.id.l3num4, R.id.l3num5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        l1TV = ArrayList()
        l2TV = ArrayList()
        l3TV = ArrayList()
        for (i in 0..5){
            l1TV.add(findViewById(l1[i]))
            l1TV[i].setText("-")
            l2TV.add(findViewById(l2[i]))
            l2TV[i].setText("-")
            l3TV.add(findViewById(l3[i]))
            l3TV[i].setText("-")
        }
    }

    fun random(view: View){
        var a = 0

        createLottery().forEach{
            l1TV[a].setText(it.toString())
            a++
        }
        a = 0

        createLottery().forEach{
            l2TV[a].setText(it.toString())
            a++
        }
        a = 0

        createLottery().forEach{
            l3TV[a].setText(it.toString())
            a++
        }
    }

    fun createLottery() :IntArray{
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
