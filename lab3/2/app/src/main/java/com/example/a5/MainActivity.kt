package com.example.a5

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.a5.databinding.ActivityMainBinding
import java.io.ByteArrayOutputStream
import java.io.File


class MainActivity : AppCompatActivity() {
    private val cameraRequestId = 1222
    lateinit var binding: ActivityMainBinding
    var i: Intent = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (ContextCompat.checkSelfPermission(
                applicationContext, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_DENIED
        )
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.CAMERA),
                cameraRequestId
            )
        binding.cameraBtn.setOnClickListener {
            val cameraInt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraInt, cameraRequestId)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraRequestId) {

            val images: Bitmap = data?.extras?.get("data") as Bitmap
            val file = File(cacheDir, "image")
            file.createNewFile()
            val fileOutputStream = file.outputStream()
            val byteArrayOutputStream = ByteArrayOutputStream()
            images.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            val bytearray = byteArrayOutputStream.toByteArray()
            fileOutputStream.write(bytearray)
            fileOutputStream.flush()
            fileOutputStream.close()
            byteArrayOutputStream.close()
            val uri = file.toURI()
            val intent = Intent(this@MainActivity, ShareActivity::class.java)
            intent.putExtra("URI", uri.toString())
            startActivity(intent)
        }
    }
}