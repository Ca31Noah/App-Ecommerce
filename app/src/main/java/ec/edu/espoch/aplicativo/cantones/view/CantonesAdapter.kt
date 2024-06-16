package ec.edu.espoch.aplicativo.cantones.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.cantones.CantonesMain

class CantonesAdapter(private val onItemClick: (CantonesMain) -> Unit) : RecyclerView.Adapter<CantonesAdapter.CantonesViewHolder>() {

    private var cantones: List<CantonesMain> = listOf()

    fun setCantones(cantones: List<CantonesMain>) {
        this.cantones = cantones
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CantonesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_canton, parent, false)
        return CantonesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CantonesViewHolder, position: Int) {
        val canton = cantones[position]
        holder.bind(canton)
    }

    override fun getItemCount(): Int {
        return cantones.size
    }

    inner class CantonesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photoImageView: ImageView = itemView.findViewById(R.id.imageViewCanton)
        private val nameButton: Button = itemView.findViewById(R.id.buttonCantonName)

        fun bind(canton: CantonesMain) {
            nameButton.text = canton.name
            // Cargar la imagen usando Picasso u otra biblioteca de carga de imágenes
            Picasso.get().load(canton.photoUrl).into(photoImageView)

            itemView.setOnClickListener {
                onItemClick(canton)
            }
        }
    }
}
