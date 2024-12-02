import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import com.Ing3.R

class GalleryAdapter(
    private val context: Context,
    private val imageUris: List<Uri>
) : RecyclerView.Adapter<GalleryAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image_card, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUri = imageUris[position]
        holder.imageView.setImageURI(imageUri)

        // Afficher l'image en grand sur clic
        holder.itemView.setOnClickListener {
            val intent = Intent(context, FullscreenImageActivity::class.java).apply {
                putExtra("imageUri", imageUri.toString())
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = imageUris.size
}
