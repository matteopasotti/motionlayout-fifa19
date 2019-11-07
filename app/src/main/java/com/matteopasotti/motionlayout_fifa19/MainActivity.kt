package com.matteopasotti.motionlayout_fifa19

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var doShowPaths = false

    private val dataset: Array<ExampleAdapter.Example> = arrayOf(
        ExampleAdapter.Example("Scene 1", R.layout.layout_01),
        ExampleAdapter.Example("Scene 2", R.layout.layout_02),
        ExampleAdapter.Example("Scene 3", R.layout.layout_03),
        ExampleAdapter.Example("Scene 4", R.layout.layout_04)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = ExampleAdapter(dataset)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        showPaths.setOnCheckedChangeListener(this)
    }

    fun start(activity: Class<*>, layoutFileId: Int) {
        val intent = Intent(this, activity).apply {
            putExtra("layout_file_id", layoutFileId)
            putExtra("showPaths", doShowPaths)
        }

        startActivity(intent)
    }

    override fun onCheckedChanged(p0: CompoundButton?, value: Boolean) {
        doShowPaths = value
    }
}