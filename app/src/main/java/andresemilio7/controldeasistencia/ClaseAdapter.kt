package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Clases
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ClaseAdapter(var claseList: List<Clases>? = ArrayList<Clases>()): RecyclerView.Adapter<ClaseAdapter.ViewHolder>() {
    private var onClaseItemClickListener: OnClaseClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ClaseAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.template_clase, parent, false)

        return ViewHolder(vista, claseList!!)
    }

    override fun getItemCount(): Int {
        return claseList?.count()!!
    }

    override fun onBindViewHolder(holder: ClaseAdapter.ViewHolder, position: Int) {
        // Obtener la posición del item clickeado
        holder.vista.setOnClickListener{
            onClaseItemClickListener?.onClaseItemClickListener((claseList?.get(position)!!))
        }
        holder.vista.setOnLongClickListener{
            onClaseItemClickListener?.onClaseItemLongClickListener((claseList?.get(position)!!))
            true
        }
        holder.onBindViews(position)
    }

    class ViewHolder(val vista: View, val claseList: List<Clases>): RecyclerView.ViewHolder(vista) {
        fun onBindViews(position: Int) {
            vista.findViewById<TextView>(R.id.tvNombreClase).text = claseList.get(position).asignatura
            vista.findViewById<TextView>(R.id.tvPrimeraLetraClase).text = claseList.get(position).asignatura.first().toUpperCase().toString()
        }
    }


    /**
     * Utilizamos un método en lugar de asignar la funcionalidad vía el constructor
     * de la clase principal para mayor comodidad al momento de sobreescribir la funcionalidad.
     */
    fun setClaseItemClickListener(onClaseItemClickListener: OnClaseClickListener) {
        this.onClaseItemClickListener = onClaseItemClickListener
    }

    /**
     * Definimos la interface que permite extender métodos que el RecyclerView no posee
     */
    interface OnClaseClickListener {
        fun onClaseItemClickListener(clases: Clases)
        fun onClaseItemLongClickListener(clases: Clases)
    }

}