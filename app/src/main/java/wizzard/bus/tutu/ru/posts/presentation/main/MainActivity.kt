package wizzard.bus.tutu.ru.posts.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import wizzard.bus.tutu.ru.posts.R
import wizzard.bus.tutu.ru.posts.presentation.words.contract.WordsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.main_content, WordsFragment.newInstance())
                    .addToBackStack("common")
                    .commit()
        }
    }

}
