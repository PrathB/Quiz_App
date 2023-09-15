package com.test.quizapp

object Constants {

    val USER_NAME : String = "user_name"
    val TOTAL_QUESTIONS : String = "total_questions"
    val CORRECT_ANSWERS : String = "correct_answers"


    fun getQues(): ArrayList<Question>{
        val quesList = ArrayList<Question>()

        val ques1 = Question(
            1,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_argentina,
            "Armenia","Australia","Argentina","Austria",3
        )

        quesList.add(ques1)

        val ques2 = Question(
            2,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_australia,
            "Armenia","Australia","United Kingdom","Austria",2
        )

        quesList.add(ques2)

        val ques3 = Question(
            1,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_belgium,
            "Germany","Belgium","France","Austria",2
        )

        quesList.add(ques3)

        val ques4  = Question(
            1,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_brazil,
            "Nigeria","Bharat","Columbia","Brazil",4
        )

        quesList.add(ques4)

        val ques5  = Question(
            1,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_denmark,
            "Denmark","Switzerland","Sweden","Norway",1
        )

        quesList.add(ques5)

        val ques6  = Question(
            1,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_fiji,
            "New Zealand","Fiji","Australia","United Kingdom",2
        )

        quesList.add(ques6)

        val ques7  = Question(
            1,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_germany,
            "Germany","France","Netherlands","Switzerland",1
        )

        quesList.add(ques7)

        val ques8  = Question(
            1,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_india,
            "Ireland","Niger","Pakistan","Bharat",4
        )

        quesList.add(ques8)

        val ques9 = Question(
            1,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_kuwait,
            "Nepal","Kuwait","Luxembourg","UAE",2
        )

        quesList.add(ques9)

        val ques10  = Question(
            1,"Which Country's flag is displayed below?",R.drawable.ic_flag_of_new_zealand,
            "New Zealand","Japan","Finland","United Kingdom",1
        )

        quesList.add(ques10)

        return quesList
    }
}