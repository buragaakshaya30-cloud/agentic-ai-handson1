package com.project.handson_1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.handson_1.databinding.ActivityMainBinding
import com.project.handson_1.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewModel()

        binding.btnAskAI.setOnClickListener {

            val prompt = binding.etPrompt.text.toString().trim()

            if (prompt.isNotEmpty()) {
                viewModel.askAI(prompt)
            } else {
                binding.tvResponse.text = "Please enter a prompt."
            }
        }
    }

    private fun observeViewModel() {

        viewModel.response.observe(this) {
            binding.tvResponse.text = it
        }

        viewModel.loading.observe(this) { loading ->

            if (loading)
                binding.progressBar.visibility = android.view.View.VISIBLE
            else
                binding.progressBar.visibility = android.view.View.GONE
        }
    }
}