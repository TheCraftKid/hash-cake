package com.thecraftkid.hasher.adapter

import android.content.Context
import android.widget.ArrayAdapter

import com.thecraftkid.hasher.R

/**
 * An adapter that displays every [com.thecraftkid.hasher.hash.HashOption] in a
 * user-readable format.
 *
 * @version 1.0.0
 * @see com.thecraftkid.hasher.hash.HashGenerator
 * @since 1.0.0
 */
class HashOptionsAdapter(context: Context) :
        ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, getArray(context)) {

    companion object {

        /**
         * Returns [R.array.hash_options] in a user-readable way.
         *
         * @return An array of available hash options
         */
        private fun getArray(context: Context): Array<String> {
            return context.resources.getStringArray(R.array.hash_options)
        }
    }
}
