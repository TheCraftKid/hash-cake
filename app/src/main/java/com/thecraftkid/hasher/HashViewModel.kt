package com.thecraftkid.hasher

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.thecraftkid.hasher.hash.HashGenerator
import com.thecraftkid.hasher.hash.HashOption

/**
 * A [ViewModel] that keeps track of the currently selected [HashOption] and currently
 * inputted string to hash.
 *
 * @since 1.0.0
 * @version 1.0.0
 */
class HashViewModel : ViewModel() {

    private val hashData = MutableLiveData<String>()

    private val optionData = MutableLiveData<HashOption>();

    val hash: LiveData<String>
        get() = hashData

    fun setHash(input: String) {
        hashData.value = when (optionData.value) {
            HashOption.MD5 -> HashGenerator.generateMD5(input)
            HashOption.SHA1 -> HashGenerator.generateSHA1(input)
            HashOption.SHA256 -> HashGenerator.generateSHA256(input)
            else -> throw IllegalStateException("")
        }
    }

    val option: LiveData<HashOption>
        get() = optionData

    fun setHashOption(hashOption: HashOption) {
        optionData.value = hashOption;
    }
}