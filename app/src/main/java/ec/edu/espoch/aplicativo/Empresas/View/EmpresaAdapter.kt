package ec.edu.espoch.aplicativo.Empresas.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ec.edu.espoch.aplicativo.Empresas.Empresa
import ec.edu.espoch.aplicativo.R



class EmpresaAdapter(private val empresas: List<Empresa>, private val context: Context) : RecyclerView.Adapter<EmpresaAdapter.EmpresaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpresaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_empresa, parent, false)
        return EmpresaViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmpresaViewHolder, position: Int) {
        val empresa = empresas[position]
        holder.bind(empresa)
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
        private val imageViewEmpresa: ImageView = itemView.findViewById(R.id.imageViewEmpresa) // Asegúrate de que este ID coincida con el de tu ImageView

        fun bind(empresa: Empresa) {
            nombreTextView.text = empresa.Nombre
            propietarioTextView.text = empresa.Propietario
            emailTextView.text = empresa.Email
            contactoTextView.text = empresa.Contacto
            direccionTextView.text = empresa.Direccion

            // Carga la imagen usando Glide
            Glide.with(itemView.context)
                .load(empresa.imagenUrl) // Asegúrate de que tu modelo Empresa tenga una propiedad 'imagenUrl'
                .placeholder(R.drawable.placeholder_image1) // Reemplaza con tu placeholder
                .error(R.drawable.error_image) // Reemplaza con tu imagen de error
                .into(imageViewEmpresa)
        }
    }
}