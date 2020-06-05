package com.silky.quizzler

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int =0
    private var mCorrectAnswers: Int =0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        intent.getStringExtra(Constant.USERNAME)

        mQuestionList = Constant.getQuestions()

        setQuestions()
        tv_option_One.setOnClickListener(this)
        tv_option_Two.setOnClickListener(this)
        tv_option_Three.setOnClickListener(this)
        tv_option_Four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestions(){

        val question = mQuestionList!!.get(mCurrentPosition-1)

        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size)
            btn_submit.text = "FINISH"
        else
            btn_submit.text = "SUBMIT"

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition/${progressBar.max}"

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_One.text = question.optionOne
        tv_option_Two.text = question.optionTwo
        tv_option_Three.text = question.optionThree
        tv_option_Four.text = question.optionFour

    }

    private fun defaultOptionView() {

      val options = ArrayList<TextView>()
        options.add(0,tv_option_One)
        options.add(1,tv_option_Two)
        options.add(2,tv_option_Three)
        options.add(3,tv_option_Four)

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tv_option_One -> {
                selectedOptionView(tv_option_One,1)
            }
            R.id.tv_option_Two -> {
                selectedOptionView(tv_option_Two, 2)
            }
            R.id.tv_option_Three -> {
                selectedOptionView(tv_option_Three,3)
            }
            R.id.tv_option_Four -> {
                selectedOptionView(tv_option_Four,4)
            }
            R.id.btn_submit -> {

                if(mSelectedOptionPosition==0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionList!!.size -> {
                            setQuestions()
                        }else -> {
                         val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constant.USERNAME,mUserName)
                        intent.putExtra(Constant.CORRECT_ANSWER,mCorrectAnswers)
                        intent.putExtra(Constant.TOTAL_QUESTION,mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    }
                }
                else {
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAns !=mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++;
                    }
                    answerView(question.correctAns,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionList!!.size)
                        btn_submit.text = "FINISH"
                    else
                        btn_submit.text = "GO TO NEXT QUESTION"

                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun answerView(answer:Int , drawablesView: Int) {
      when(answer) {
         1 -> {
                tv_option_One.background = ContextCompat.getDrawable(this,drawablesView)
            }
         2 -> {
             tv_option_Two.background = ContextCompat.getDrawable(this,drawablesView)
         }
         3 -> {
             tv_option_Three.background = ContextCompat.getDrawable(this,drawablesView)
         }
         4 -> {
             tv_option_Four.background = ContextCompat.getDrawable(this,drawablesView)
         }
        }
    }

    private fun selectedOptionView(tv: TextView,selectedOptionNum:Int) {

        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg)
    }

}
