package ps.moh.mypharmacy12

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button3.setOnClickListener { startActivity(Intent(this,ChooseActivity::class.java)) }
        button4.setOnClickListener { startActivity(Intent(this,AddActivity::class.java)) }

    }
}