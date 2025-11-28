package ps.moh.mypharmacy12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
        button.setOnClickListener { startActivity(Intent(this,ViewActivity::class.java)) }
        button2.setOnClickListener { startActivity(Intent(this,SearchActivity::class.java)) }
    }
}