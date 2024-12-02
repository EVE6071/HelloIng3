import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Ing3.R

class ListeGalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_gallery)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewGallery)

        // Liste des images dans le dossier
        val imageUris = (1..24).map {
            Uri.parse("android.resource://$packageName/res/drawable/Image/image_$it")
        }
        // Configurer le RecyclerView avec un GridLayoutManager
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = GalleryAdapter(this, imageUris)

        // Activer la flèche de retour
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(android.R.drawable.ic_menu_revert)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}


