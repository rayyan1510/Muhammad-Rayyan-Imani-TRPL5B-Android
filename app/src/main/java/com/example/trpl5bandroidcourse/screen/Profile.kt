package com.example.trpl5bandroidcourse.screen

import android.content.Context
import android.util.Log
import android.util.Size
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.trpl5bandroidcourse.APIController
import com.example.trpl5bandroidcourse.ListModal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun Profile(navController: NavHostController){

    /*A Box as a container and the position at center*/
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        Column {

            Row {
                Text(text = "Keahlian Bahasa", modifier = Modifier.padding(10.dp), fontWeight = FontWeight.SemiBold)
            }

            Row {
                Text(text = "Muhammad Rayyan Imani", modifier = Modifier.padding(10.dp), fontWeight = FontWeight.Medium)
            }

            Divider()

            Spacer(modifier = Modifier.height(20.dp))

            Column {
                /* UNTUK MENAMPILKAN DATA api*/
                displayListView()
            }

        }
    }
}

/* fungsi untuk memanggil data dari API*/
fun getJSONData(courseList: MutableList<String>, ctx: Context) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://mocki.io/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitAPI = retrofit.create(APIController::class.java)
    val call: Call<ArrayList<ListModal>> = retrofitAPI.getLanguages()
    call!!.enqueue(object : Callback<ArrayList<ListModal>?> {
        override fun onResponse(
            call: Call<ArrayList<ListModal>?>,
            response: Response<ArrayList<ListModal>?>
        ){
            /*cek jika respon dari api berhasil*/
            if (response.isSuccessful){
                /*
                    tampilkan isi data api kemudian dilopping dan dimasukkan ke dalam
                    variable
                */
                var lst: ArrayList<ListModal> = ArrayList()
                lst = response.body()!!
                for (i in 0 until lst.size) {
                    courseList.add(lst.get(i).languageName)
                }
            }
        }

        /*jika gagal*/
        override fun onFailure(call: Call<ArrayList<ListModal>?>, t: Throwable){
            Toast.makeText(ctx, "Gagal mendapatkan data...", Toast.LENGTH_SHORT).show()
            Log.d("ERROR", t.toString())
        }
    })
}

@Composable
fun displayListView() {
    val context = LocalContext.current
    val courseList = remember { mutableStateListOf<String>() }
    getJSONData(courseList, context)
    LazyColumn {
        items(courseList) { language ->
            Text(language, modifier = Modifier.padding(15.dp))
            Divider()
        }
    }
}