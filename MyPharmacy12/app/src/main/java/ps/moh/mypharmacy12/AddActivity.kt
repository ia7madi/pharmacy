package ps.moh.mypharmacy12

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    private lateinit var database: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        database = Database(this)

        cancel.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        add.setOnClickListener {
            val nameText = name.text.toString()
            val qText = q.text.toString()
            val priceText = price.text.toString()

            if (nameText.isEmpty() || qText.isEmpty() || priceText.isEmpty()) {
                Toast.makeText(this, "يرجى تعبئة البيانات", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val quantity = qText.toIntOrNull()
            val priceVal = priceText.toDoubleOrNull()

            if (quantity == null || priceVal == null) {
                Toast.makeText(this, "تأكد من أن الكمية والسعر أرقام صحيحة", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val type = when (radio1.checkedRadioButtonId) {
                R.id.Injection1 -> Injection1.text.toString() to R.drawable.apr
                R.id.Syrup1 -> Syrup1.text.toString() to R.drawable.shrab
                R.id.Pills1 -> Pills1.text.toString() to R.drawable.hopop
                else -> {
                    Toast.makeText(this, "الرجاء اختيار نوع الدواء", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            database.add(Pro(0, nameText, quantity, priceVal, type.first, type.second))
            name.text.clear()
            q.text.clear()
            price.text.clear()
            radio1.clearCheck()
        }
    }
}
