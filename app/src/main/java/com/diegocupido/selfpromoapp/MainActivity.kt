package com.diegocupido.selfpromoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.button_preview
import kotlinx.android.synthetic.main.activity_main.check_box_immediate_start
import kotlinx.android.synthetic.main.activity_main.check_box_junior
import kotlinx.android.synthetic.main.activity_main.edit_text_contact_name
import kotlinx.android.synthetic.main.activity_main.edit_text_contact_number
import kotlinx.android.synthetic.main.activity_main.edit_text_my_display_name
import kotlinx.android.synthetic.main.activity_main.edit_text_start_date
import kotlinx.android.synthetic.main.activity_main.spinner_job_title

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_preview.setOnClickListener {
            onPreviewClicked()
        }
        val spinnerValues = arrayOf("Android Developer","Android Engineer")
        val spinnerAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,spinnerValues)
        spinner_job_title.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {
        val message = Message(
            edit_text_contact_name.text.toString() ,
            edit_text_contact_number.text.toString(),
            edit_text_my_display_name.text.toString(),
            check_box_junior.isChecked,
            spinner_job_title.selectedItem?.toString(),
            check_box_immediate_start.isChecked,
            edit_text_start_date.text.toString()

        )

        val previewActivityIntent = Intent(this,PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)
        startActivity(previewActivityIntent)
    }
}