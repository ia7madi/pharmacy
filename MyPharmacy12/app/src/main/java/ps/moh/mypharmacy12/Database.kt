package ps.moh.mypharmacy12

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
@SuppressLint("Range")
class Database(context: Context):SQLiteOpenHelper(context,"pharmacy.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(createtable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $database_Table_name")
        onCreate(db)
    }
    companion object {
        const val ID = "_ID"
        const val Name = "Name"
        const val quantity = "quantity"
        const val price = "price"
        const val type="type"
        const val image="Image"
        const val database_Table_name = "medicine"
        const val createtable =
            "CREATE TABLE $database_Table_name (" +
                    "$ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$Name TEXT NOT NULL, " +
                    "$quantity INTEGER, " +
                    "$price DOUBLE,"+
                    "$type TEXT,"+
                    "$image INTEGER);"
    }
    fun add(m:Pro){

        val db=writableDatabase
        val value=ContentValues().apply {
            put(Name,m.name)
            put(quantity,m.quantity)
            put(price,m.price)
            put(type,m.type)
            put(image,m.image)
        }
        db.insert(database_Table_name,null,value)
        db.close()
    }

    fun print():List<Pro>{
        val db = this.writableDatabase
        val patientList = ArrayList<Pro>()
        val cursor = db.rawQuery("SELECT * FROM $database_Table_name", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val name = cursor.getString(cursor.getColumnIndex(Name))
                val quantity = cursor.getString(cursor.getColumnIndex(quantity))
                val price = cursor.getDouble(cursor.getColumnIndex(price))
                val type=cursor.getString(cursor.getColumnIndex(type))
                val image=cursor.getInt(cursor.getColumnIndex(image))
                patientList.add(Pro(id,name, quantity.toInt(),price,type,image ))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return patientList
    }
    fun find(type1:String):List<Pro>{
        val db = this.writableDatabase
        val patientList = ArrayList<Pro>()
        val cursor = db.rawQuery("SELECT * FROM $database_Table_name where $type=\"$type1\";", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val name = cursor.getString(cursor.getColumnIndex(Name))
                val quantity = cursor.getString(cursor.getColumnIndex(quantity))
                val price = cursor.getDouble(cursor.getColumnIndex(price))
                val type=cursor.getString(cursor.getColumnIndex(Companion.type))
                val image=cursor.getInt(cursor.getColumnIndex(image))
                patientList.add(Pro(id,name, quantity.toInt(),price,type,image ))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return patientList

    }
    fun delete(id: Int) {
        val db = writableDatabase
        db.execSQL("DELETE FROM $database_Table_name WHERE $ID=\"$id\";")
        db.close()
    }
}