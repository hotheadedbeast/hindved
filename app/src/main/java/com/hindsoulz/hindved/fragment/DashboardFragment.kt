package com.hindsoulz.hindved.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hindsoulz.hindved.R
import com.hindsoulz.hindved.adapter.DashboardRecyclerAdapter
import com.hindsoulz.hindved.model.Book


class DashboardFragment : Fragment() {

    lateinit var recyclerDashboard: RecyclerView

    lateinit var layoutManager: RecyclerView.LayoutManager

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

        return view
    }

}
