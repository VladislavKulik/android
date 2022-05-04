package com.example.a5

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a5.databinding.ActivityShareBinding


class ShareActivity : AppCompatActivity() {
    lateinit var binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val i = Intent(Intent.ACTION_SEND)

        i.type = "image/*"
        i.putExtra(Intent.EXTRA_SUBJECT, "КПП АІ-194 Кулик")
        val imageUri: Uri = Uri.parse(
             packageName
                    + "/cache/" + "image")
        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        i.putExtra(Intent.EXTRA_STREAM, imageUri)


        try {
            startActivity(i)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Error sending a message", Toast.LENGTH_LONG).show()
        }
    }

}