package com.exampl.photopickerimplementation

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.launch
import androidx.fragment.app.viewModels

import com.exampl.photopickerimplementation.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }


    private val viewModel by viewModels<ExampleViewModel>()

    private val singlePhotoPickerLauncher = registerForActivityResult(PickSinglePhotoContract()) { imageUri: Uri? ->
        imageUri?.let(viewModel::setImageUri)
    }

    private fun pickPhoto() = singlePhotoPickerLauncher.launch()
}