package seeto.c2.artoria.us.myapplication.UI.ToDo.TodoCreate

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SibalLom : ViewModel() {
    val title = MutableLiveData<String>().apply { value = "" }
    val category = MutableLiveData<String>().apply { value = "" }
    val mode = MutableLiveData<String>().apply { value = "" }
    val expiration = MutableLiveData<String>().apply { value = "" }
    val milestone = MutableLiveData<ArrayList<String>>().apply { value = arrayListOf() }
    fun setMilestone(array: ArrayList<String>) {
        milestone.value = array
    }
}