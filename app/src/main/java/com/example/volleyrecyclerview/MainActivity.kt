package com.example.volleyrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var recycleView: RecyclerView
    lateinit var recycle: recycle
    val i:Int = 0
    lateinit var list:List<DataModel>
    val url1:String="https://simplifiedcoding.net/demos/view-flipper/heroes.php"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView=findViewById(R.id.recycler)

     list= ArrayList<DataModel>()
        val request: StringRequest = StringRequest(Request.Method.GET,url1, Response.Listener {
            response ->
            Log.e("response>>>>",response)
           val jb:JSONObject= JSONObject(response)
            val ja:JSONArray=jb.getJSONArray("heroes")
              for (i in 0 until ja.length()){
                  val jsonobject:JSONObject=ja.getJSONObject(i)
                  val name:String=jsonobject.getString("name")
                  val image:String=jsonobject.getString("imageurl")

                  val model=DataModel()
                  setOf(model.name)
                  list.addAll(list.createContactsList(5));
              }
            recycle= recycle(this,list)
            val layoutManager= LinearLayoutManager(this)
            recycleView.layoutManager=layoutManager
            recycleView.adapter=recycle

        }, Response.ErrorListener {

        })
        val  requestQueue = Volley.newRequestQueue(this)
        requestQueue?.add(request)



    }

}