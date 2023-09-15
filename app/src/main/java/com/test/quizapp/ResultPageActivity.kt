package com.test.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)

        val finish : Button = findViewById(R.id.btn_finish)

//        displaying username collected from intent
        val userName : TextView = findViewById(R.id.tv_username)
        userName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQues = intent.getIntExtra(Constants.TOTAL_QUESTIONS,10)
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

//        displaying score collected from intent
        val score:TextView = findViewById(R.id.tv_score)
        score.text = "Your score is $correctAns out of $totalQues"

        finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}