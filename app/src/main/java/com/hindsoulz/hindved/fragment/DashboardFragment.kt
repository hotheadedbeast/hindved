package com.hindsoulz.hindved.fragment

import android.app.AlertDialog
import android.app.DownloadManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.hindsoulz.hindved.R
import com.hindsoulz.hindved.adapter.DashboardRecyclerAdapter
import com.hindsoulz.hindved.util.ConnectionManager
import com.hindsoulz.hindved.model.Book
import java.lang.reflect.Method


class DashboardFragment : Fragment() {

    lateinit var recyclerDashboard: RecyclerView

    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var btnCheckInternet: Button

    val bookList = arrayListOf(
        "Book 1",
        "Book 2",
        "Book 3",
        "Book 4",
        "Book 5",
        "Book 6",
        "Book 7",
        "Book 8",
        "Book 9",
        "Book 10"

    )

    lateinit var recyclerAdapter: DashboardRecyclerAdapter

    val bookInfoList = arrayListOf<Book>(
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji),
        Book("Hanuman Chalisa", "God", "Free", "5", R.drawable.hanumanji)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)

        btnCheckInternet = view.findViewById(R.id.btnCheckInternet)

        btnCheckInternet.setOnClickListener {
            if (ConnectionManager().checkConnectivity(activity as Context)) {
                val dialogs = AlertDialog.Builder(activity as Context)
                dialogs.setTitle("Success")
                dialogs.setMessage("Internet Connection Found")
                dialogs.setPositiveButton("Ok") { text, listener ->
                }
                dialogs.setNegativeButton("Cancel") { text, listener ->
                }
                dialogs.create()
                dialogs.show()
            } else {
                val dialogs = AlertDialog.Builder(activity as Context)
                dialogs.setTitle("Error")
                dialogs.setMessage("Internet Connection Not Found")
                dialogs.setPositiveButton("Ok") { text, listener ->
                }
                dialogs.setNegativeButton("Cancel") { text, listener ->
                }
                dialogs.create()
                dialogs.show()
            }
        }


        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

        recyclerDashboard.adapter = recyclerAdapter

        recyclerDashboard.layoutManager = layoutManager

        recyclerDashboard.addItemDecoration(
            DividerItemDecoration(
                recyclerDashboard.context,
                (layoutManager as LinearLayoutManager).orientation
            )
        )

        val queue = Volley.newRequestQueue(activity as Context)

        val url = "http://13.235.250.119/v1/book/fetch_books/"

        val jsonObjectRequest =
            object : JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {

            println("Response is $it")

            }, Response.ErrorListener {

                println("Error is $it")

            }) {
                override fun getHeaders(): MutableMap<String, String> {
                    val headers = HashMap<String, String>()
                    headers["Content-Type"] = "application/json"
                    headers["token"] = "9bf534118365f1"
                    return headers
                }
            }

        queue.add(jsonObjectRequest)

        return view
    }

}
