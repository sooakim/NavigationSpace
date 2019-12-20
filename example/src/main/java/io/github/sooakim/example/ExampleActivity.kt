package io.github.sooakim.example

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_example.*

class ExampleActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        btnToggle.setOnClickListener {
            bottomGuide.visibility = when(bottomGuide.visibility){
                View.INVISIBLE -> View.GONE
                else -> View.INVISIBLE
            }
            topGuide.visibility = when(topGuide.visibility){
                View.INVISIBLE -> View.GONE
                else -> View.INVISIBLE
            }
        }
    }
}