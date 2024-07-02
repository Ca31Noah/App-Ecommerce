package ec.edu.espoch.aplicativo.Empresas.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ec.edu.espoch.aplicativo.Empresas.Empresa
import ec.edu.espoch.aplicativo.R

class EmpresaAdapter(
    private val empresas: List<Empresa>,
    private val context: Context,
    private val onEmpresaClickListener: (Empresa) -> Unit
) : RecyclerView.Adapter<EmpresaAdapter.EmpresaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpresaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_empresa, parent, false)
        return EmpresaViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmpresaViewHolder, position: Int) {
        val empresa = empresas[position]
        holder.bind(empresa, onEmpresaClickListener)
    }

    override fun getItemCount(): Int {
        return empresas.size
    }

    class EmpresaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.tvNombre)
        private val propietarioTextView: TextView = itemView.findViewById(R.id.tvPropietario)
        private val emailTextView: TextView = itemView.findViewById(R.id.tvEmail)
        private val contactoTextView: TextView = itemView.findViewById(R.id.tvContacto)
        private val direccionTextView: TextView = itemView.findViewById(R.id.tvDireccion)
        private val imageViewEmpresa: ImageView = itemView.findViewById(R.id.imageViewEmpresa)
        private val verProductosButton: Button = itemView.findViewById(R.id.btnVerProductosServicios)

        fun bind(empresa: Empresa, onEmpresaClickListener: (Empresa) -> Unit) {
            nombreTextView.text = empresa.Nombre
            propietarioTextView.text = empresa.Propietario
            emailTextView.text = empresa.Email
            contactoTextView.text = empresa.Contacto
            direccionTextView.text = empresa.Direccion

            Glide.with(itemView.context)
                .load(empresa.imagenUrl)
                .placeholder(R.drawable.placeholder_image1)
                .error(R.drawable.error_image)
                .into(imageViewEmpresa)

            verProductosButton.setOnClickListener { onEmpresaClickListener(empresa) }
        }
    }
}
