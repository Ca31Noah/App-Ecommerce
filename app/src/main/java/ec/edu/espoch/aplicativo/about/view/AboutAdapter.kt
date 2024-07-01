package ec.edu.espoch.aplicativo.about.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ec.edu.espoch.aplicativo.R
import ec.edu.espoch.aplicativo.about.AboutMain

class AboutAdapter(
    private val onItemClick: (AboutMain) -> Unit,
) : RecyclerView.Adapter<AboutAdapter.AboutViewHolder>() {

    private var desarrolladores: List<AboutMain> = listOf()

    fun setDesarrolladores(desarrolladores: List<AboutMain>) {
        this.desarrolladores = desarrolladores
        notifyDataSetChanged()  // Añadir esta línea para notificar al adaptador que los datos han cambiado
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_about, parent, false)
        return AboutViewHolder(view)
    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {
        val desarrollador = desarrolladores[position]
        holder.bind(desarrollador)
    }

    override fun getItemCount(): Int {
        return desarrolladores.size
    }

    inner class AboutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photoImageView: ImageView = itemView.findViewById(R.id.imageViewAbout)
        private val nameTextView: TextView = itemView.findViewById(R.id.textViewAboutName)

        fun bind(desarrollador: AboutMain) {
            nameTextView.text = desarrollador.name
            Picasso.get().load(desarrollador.photoUrl).placeholder(R.drawable.placeholder_image1).into(photoImageView)

            itemView.setOnClickListener {
                onItemClick(desarrollador)

            }
        }
    }
}
