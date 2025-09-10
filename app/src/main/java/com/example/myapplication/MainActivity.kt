package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.VideoView
import android.view.View
class MainActivity : ComponentActivity() {
    private val CORRECTPASSWORD = "0721"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreat execute");
        enableEdgeToEdge()
        setContentView(R.layout.mainact)

        val editText = findViewById<EditText>(R.id.editTextNumberPassword)
        val buttonConfirm = findViewById<Button>(R.id.button)
        val textViewResult = findViewById<TextView>(R.id.textView)

        buttonConfirm.setOnClickListener {
            val enteredPassword = editText.text.toString()
            if (enteredPassword == CORRECTPASSWORD) {
                textViewResult.text = "密码正确"

                val videoView = findViewById<VideoView>(R.id.videoView2)


                videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.ng)
                videoView.visibility = View.VISIBLE
                videoView.start()
            } else {
                textViewResult.text = "密码错误"
            }
        }
//        setContent {
//            MyApplicationTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}