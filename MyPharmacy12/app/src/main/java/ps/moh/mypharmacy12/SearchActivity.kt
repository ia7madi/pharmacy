package ps.moh.mypharmacy12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_add.Injection1
import kotlinx.android.synthetic.main.activity_add.Pills1
import kotlinx.android.synthetic.main.activity_add.Syrup1
import kotlinx.android.synthetic.main.activity_add.radio1

class SearchActivity : AppCompatActivity() {
    private lateinit var database: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        database = Database(this)
    }

    fun find(view: View) {
        val  results = when (radio1.checkedRadioButtonId) {
            R.id.Injection1 -> Injection1.text.toString() to database.find(Injection1.text.toString())
            R.id.Syrup1 -> Syrup1.text.toString() to database.find(Syrup1.text.toString())
            R.id.Pills1 -> Pills1.text.toString() to database.find(Pills1.text.toString())
            else -> {
                Toast.makeText(this, "الرجاء اختيار نوع الدواء", Toast.LENGTH_SHORT).show()
                return
            }
        }

        listview.adapter = CastuomAdapter(this, results as ArrayList<Pro>)
    }
}
