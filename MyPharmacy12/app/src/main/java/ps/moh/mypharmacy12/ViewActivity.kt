package ps.moh.mypharmacy12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {
    lateinit var database: Database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        database= Database(this)
        val n=database.print()as ArrayList<Pro>
        gridview.adapter=CastuomAdapter(this,n)
    }
}