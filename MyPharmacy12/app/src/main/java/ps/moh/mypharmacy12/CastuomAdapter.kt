package ps.moh.mypharmacy12

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item.view.*

@SuppressLint("ViewHolder")
class CastuomAdapter(context: Context, private val objects: ArrayList<Pro>) :
    ArrayAdapter<Pro>(context, R.layout.item, objects) {
    private lateinit var database: Database
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        database= Database(context)
        val n:Pro=getItem(position)!!
        val l=LayoutInflater.from(context)
        val v=l.inflate(R.layout.item,parent,false)
        v.price123.text=n.price.toString()
        v.name12.text=n.name
        v.quant.text=n.quantity.toString()
        v.imageView3.setImageResource(n.image)
        v.delete.setOnClickListener {
            AlertDialog.Builder(context).apply {
                setTitle("تحذير")
                setMessage("هل انت متاكد بحذف الدواء؟")
                setPositiveButton("نعم") { _, _ ->
                    database.delete(n.id)
                    objects.removeAt(position)
                    notifyDataSetChanged()
                }
                setNegativeButton("لا", null)
                show()
            }

        }
        return v
    }
}