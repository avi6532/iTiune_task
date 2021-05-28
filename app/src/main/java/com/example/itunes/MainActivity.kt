package com.example.itunes

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var searchView: SearchView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide();
        searchView = findViewById(R.id.searchView)


        searchView?.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    getSongs(query)
                    return true
                }

                override fun onQueryTextChange(query: String): Boolean {
                    getSongs(query)
                    return false
                }

            })

    }

    private fun getSongs(searchTerm: String) {
        val call = RetrofitClient.instance?.getMyApi()?.getSongs(searchTerm)
        call?.enqueue(object : Callback<Results?> {
            override fun onResponse(
                call: Call<Results?>?,
                response: Response<Results?>
            ) {
                val queryResult = response.body()
                val songs = queryResult?.results

                val rvSongs = findViewById<View>(R.id.song_list) as RecyclerView
                val adapter = songs?.let { SongsAdapter(it) }
                rvSongs.adapter = adapter
            }

            override fun onFailure(
                call: Call<Results?>?,
                t: Throwable?
            ) {
                if (t != null) {
                    Toast.makeText(applicationContext, t?.message, Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}
