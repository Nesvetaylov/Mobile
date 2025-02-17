package com.example.task21

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        private lateinit var btnTrue : Button
        private lateinit var btnFalse : Button
        private lateinit var NextButton : ImageButton
        private lateinit var PrevButton : ImageButton
        private lateinit var questionTextView: TextView

        val quizViewModule: MainActivityViewModule by lazy {
            val provider = ViewModelProvider(this)
            provider.get(MainActivityViewModule::class.java)
        }

        override fun OnCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_main)

            btnTrue=findViewById(R.id.btnTrue)
            btnFalse=findViewById(R.id.btnFalse)
            NextButton = findViewById(R.id.ibNext)
            PrevButton = findViewById(R.id.ibPrev)
            questionTextView=findViewById(R.id.tvQuestion)

            updateQuestion()

            btnTrue.setOnClickListener {
                checkAnswer(true)
            }
            btnFalse.setOnClickListener {
                CheckAnswer(false)
            }
            nextButton.setOnClickListener {
                quizViewModule.moveToNext()
                updateQuestion()
            }
            nextButton.setOnClickListener {
                quizViewModule.moveToPrev()
                updateQuestion()
            }

            val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data: Intent? == result.data
                    QuizViewModel.ischeater = data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) ?: false
                }
            }










        }





    }
    public fun textViewClick(view: View)
    {
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = resources.getString(R.string.app_name)
    }
}