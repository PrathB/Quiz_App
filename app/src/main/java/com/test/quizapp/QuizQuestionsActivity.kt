package com.test.quizapp

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity() ,OnClickListener{
    private var userName : String? = null
    private var correctAns: Int = 0

    private var qlist : ArrayList<Question>? = null
    private var quesNo : Int = 1
    private var selectedOption : Int = 0
    private var submitFlag : Boolean = false

    private var ques : TextView? = null
    private var img : ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress : TextView? = null

    private var option1 : TextView? = null
    private var option2 : TextView? = null
    private var option3 : TextView? = null
    private var option4 : TextView? = null

    private var submit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        userName = intent.getStringExtra(Constants.USER_NAME)

        ques = findViewById(R.id.tv_ques)
        img = findViewById(R.id.flag_img)
        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.tv_progress)

        option1 = findViewById(R.id.tv_op1)
        option2 = findViewById(R.id.tv_op2)
        option3  = findViewById(R.id.tv_op3)
        option4 = findViewById(R.id.tv_op4)

        submit = findViewById(R.id.submit_btn)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        submit?.setOnClickListener(this)


        qlist = Constants.getQues()

        setQues()

    }

    //    fxn to set image and options according to current question
    private fun setQues() {
        submitFlag = false

        defaultOptionView()

        val currentQues = qlist!![quesNo - 1]

        ques?.text = currentQues.ques

        img?.setImageResource(currentQues.image)

        progressBar?.progress = quesNo
        tvProgress?.text = "$quesNo/${progressBar?.max}"

        option1?.text = currentQues.option1
        option2?.text = currentQues.option2
        option3?.text = currentQues.option3
        option4?.text = currentQues.option4

        submit?.text = "SUBMIT"

    }

    //    fxn to set all options back to default background
    private fun defaultOptionView(){
        val options = arrayListOf<TextView>()
        option1?.let {
            options.add(0,it)
        }
        option2?.let {
            options.add(1,it)
        }
        option3?.let {
            options.add(2,it)
        }
        option4?.let {
            options.add(3,it)
        }

        for(op in options){
            op.typeface = Typeface.DEFAULT
            op.background = ContextCompat.getDrawable(this , R.drawable.option_bg)
        }
    }

    //  fxn to change background of selected option and also store the option number
    private fun selectedOptionView(option : TextView , opNum : Int){
        defaultOptionView()

        selectedOption = opNum

        option.typeface = Typeface.DEFAULT_BOLD
        option.background = ContextCompat.getDrawable(this,R.drawable.selected_option_bg)

    }

    private fun answerView(selOp: Int,correct: Boolean){
        val bg : Int = if(correct) {
            R.drawable.correct_option_bg
        } else {
            R.drawable.wrong_option_bg
        }
        when(selOp){
            1-> {
                option1?.background  = ContextCompat.getDrawable(this,bg)
            }
            2-> {
                option2?.background = ContextCompat.getDrawable(this,bg)
            }
            3-> {
                option3?.background = ContextCompat.getDrawable(this,bg)
            }
            4-> {
                option4?.background = ContextCompat.getDrawable(this,bg)
            }
        }
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_op1 -> {
                if(!submitFlag) {
                    option1?.let {
                        selectedOptionView(it, 1)
                    }
                }
            }
            R.id.tv_op2 -> {
                if(!submitFlag) {
                    option2?.let {
                        selectedOptionView(it, 2)
                    }
                }
            }
            R.id.tv_op3 -> {
                if(!submitFlag) {
                    option3?.let {
                        selectedOptionView(it, 3)
                    }
                }
            }
            R.id.tv_op4 -> {
                if (!submitFlag) {
                    option4?.let {
                        selectedOptionView(it, 4)
                    }
                }
            }
            R.id.submit_btn -> {
//                to restrict user to proceeding without selecting an option
                if(selectedOption == 0){
                    Toast.makeText(this, "Please select an option to submit", Toast.LENGTH_SHORT).show()
                }
//               set new screen
                else if(selectedOption == -1){
                    if(quesNo < qlist!!.size){
                        quesNo++
                        selectedOption = 0
                        setQues()
                    }
                    else{
//                        moving to score screen
                        val intent = Intent(this,ResultPageActivity::class.java)
//                        sending username,total questions and correct answers to ResultPageActivity
                        intent.putExtra(Constants.USER_NAME,userName)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, qlist!!.size)
                        intent.putExtra(Constants.CORRECT_ANSWERS,correctAns)
                        startActivity(intent)
                        finish()
                    }

                }
//                to mark right option
                else{
                    if (selectedOption != qlist!![quesNo - 1].ans) {
                        answerView(selectedOption, false)
                    }
                    else{
                        correctAns++
                    }
                    answerView(qlist!![quesNo - 1].ans, true)
                    selectedOption = -1
                    submitFlag = true



                    if (quesNo != qlist?.size) {
                        submit?.text = "GO TO NEXT QUESTION"
                    } else {
                        submit?.text = "FINISH"
                    }
                }

            }

        }


    }
}