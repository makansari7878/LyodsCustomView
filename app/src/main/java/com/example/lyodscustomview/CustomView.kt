package com.example.lyodscustomview

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout

class CustomView : LinearLayout {

    private lateinit var editText: EditText
    private lateinit var imageButton: ImageButton
    private var passwordVisible = false

    // Constructor with one parameter (Context)
    constructor(context: Context) : this(context, null)

    // Constructor with two parameters (Context, AttributeSet)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    // Constructor with three parameters (Context, AttributeSet, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        // Inflate the custom layout
        inflate(context, R.layout.custom_view, this)

        // Find views
        editText = findViewById(R.id.edit_text)
        imageButton = findViewById(R.id.image_button)

        // Set click listener for the button
        imageButton.setOnClickListener {
            togglePasswordVisibility()
        }

        // Add text watcher to show/hide the button based on input
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s?.length ?: 0 > 0) {
                    imageButton.visibility = View.VISIBLE
                } else {
                    imageButton.visibility = View.GONE
                }
            }
        })
    }

    private fun togglePasswordVisibility() {
        if (passwordVisible) {
            editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            imageButton.setImageResource(R.drawable.abc) // Replace with your "hide password" icon
            passwordVisible = false
        } else {
            editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            imageButton.setImageResource(R.drawable.abc) // Replace with your "show password" icon
            passwordVisible = true
        }
        // Ensure the cursor position is retained
        editText.setSelection(editText.text.length)
    }
}
