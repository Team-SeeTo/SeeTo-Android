package seeto.c2.artoria.us.myapplication

import android.content.Context
import android.content.SharedPreferences

private fun getPref(context: Context): SharedPreferences {
    val pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    return pref
}

fun saveToken(context: Context, token: String, isAccess: Boolean = true){
    val editor = getPref(context).edit()
    editor.putString(getKey(isAccess), token)
    editor.apply()
}

fun removeToken(context: Context, isAccess: Boolean = true){
    val editor = getPref(context).edit()
    editor.remove(getKey(isAccess))
    editor.apply()

}

fun saveQM(context: Context,text : String){
    val editor = getPref(context).edit()
    editor.putString("QM",text)
    editor.apply()
}

fun saveInfo(context: Context, key: String, value: String){
    val editor = getPref(context).edit()
    editor.putString(key,value)
    editor.apply()
}

fun getInfo(context: Context,key: String) : String{
    return getPref(context).getString(key,"")
}

fun getQM(context: Context) : String{
    return getPref(context).getString("QM","")
}

fun getToken(context: Context, isAccess: Boolean = true): String{
    return getPref(context).getString(getKey(isAccess), "")
}

private fun getKey(isAccess: Boolean): String = if (isAccess) "Access" else "Refresh"