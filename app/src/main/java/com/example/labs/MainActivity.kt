package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.adapter.UserAdapter
import com.example.labs.api.EndPoints
import com.example.labs.api.OutputPost
import com.example.labs.api.ServiceBuilder
import com.example.labs.api.User
import retrofit2.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.getUsers()

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                }
                recyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = UserAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
    })
    }



fun getSingle(view: View) {
    val request = ServiceBuilder.buildService(EndPoints::class.java)
  val callUserID = request.getUserById(2)
  callUserID.enqueue(object : Callback<User>{
      override fun onResponse(call: Call<User>, response: Response<User>) {
          if (response.isSuccessful){
              val c: User = response.body()!!
              Toast.makeText(this@MainActivity, c.name, Toast.LENGTH_SHORT).show()
          }
      }
      override fun onFailure(call: Call<User>, t: Throwable) {
          Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
      }
  })

}
fun post(view: View) {

    val request = ServiceBuilder.buildService(EndPoints::class.java)
    val callPost = request.postTest("teste")
    callPost.enqueue(object : Callback<OutputPost>{
        override fun onResponse(call: Call<OutputPost>, response: Response<OutputPost>) {
            if (response.isSuccessful){
                val c: OutputPost = response.body()!!
                Toast.makeText(this@MainActivity, c.id.toString() + "-" + c.title, Toast.LENGTH_SHORT).show()
            }
        }
        override fun onFailure(call: Call<OutputPost>, t: Throwable) {
            Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
        }
    })


}
}