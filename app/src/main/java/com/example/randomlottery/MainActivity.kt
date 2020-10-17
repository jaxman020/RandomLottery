package com.example.randomlottery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun random(view: View){
        var hashSet = HashSet<Int>()
        var ans = IntArray(6)
        var i = 0

        while (hashSet.size < 6){
            hashSet.add(Random.nextInt(0, 50))
        }

        for (aa in hashSet) {
            ans[i] = aa
            i++
        }

        num0.setText(ans[0].toString())
        num1.setText(ans[1].toString())
        num2.setText(ans[2].toString())
        num3.setText(ans[3].toString())
        num4.setText(ans[4].toString())
        num5.setText(ans[5].toString())
    }
}