import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.Ing3.R

class FullscreenImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen_image)

        val imageView = findViewById<ImageView>(R.id.fullscreenImageView)
        val imageUri = intent.getStringExtra("imageUri")

        imageUri?.let {
            imageView.setImageURI(Uri.parse(it))
        }
    }
}
