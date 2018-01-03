package com.thecraftkid.hasher

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.thecraftkid.hasher.adapter.HashOptionsAdapter
import com.thecraftkid.hasher.hash.HashOption

class HashActivity : AppCompatActivity() {

    private lateinit var viewModel: HashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hash)

        this.viewModel = ViewModelProviders.of(this)
                .get(HashViewModel::class.java)

        val input = findViewById<EditText>(R.id.input_to_hash)
        val hashFunction = findViewById<Spinner>(R.id.spinner_hash_function)
        val output = findViewById<TextView>(R.id.hash_output)

        input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                viewModel.setHash(input.text.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // no-op
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // no-op
            }

        })
        setupSpinner(hashFunction)
        viewModel.hash.observe(this, Observer {
            output.text = it
        })
    }

    private fun setupSpinner(spinner: Spinner) {
        spinner.adapter = HashOptionsAdapter(this)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // no-op
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int,
                                        id: Long) {
                val item = spinner.adapter.getItem(position)
                viewModel.setHashOption(HashOption.valueOf(item as String))
            }
        }
    }

}
