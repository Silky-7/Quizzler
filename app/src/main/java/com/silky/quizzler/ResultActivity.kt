package com.silky.quizzler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val correct_ans = intent.getIntExtra(Constant.CORRECT_ANSWER,0)
        val total_ques = intent.getIntExtra(Constant.TOTAL_QUESTION,0)
        val userName = intent.getStringExtra(Constant.USERNAME)
        tv_name.text = userName

        tv_score.text = "Your Score is $correct_ans out of $total_ques"

        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}
