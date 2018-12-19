package andresemilio7.controldeasistencia


import andresemilio7.controldeasistencia.data.RegistroActividad
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView


class RegistroAdapter(var registroList: List<RegistroActividad>? = ArrayList<RegistroActividad>()): RecyclerView.Adapter<RegistroAdapter.ViewHolder>() {
    private var onRegistroItemClickListener: OnRegistroClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RegistroAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.registroactividad, parent, false)

        return ViewHolder(vista, registroList!!)
    }

    override fun getItemCount(): Int {
        return registroList?.count()!!
    }

    override fun onBindViewHolder(holder: RegistroAdapter.ViewHolder, position: Int) {
        // Obtener la posición del item clickeado
        holder.vista.setOnClickListener{
            onRegistroItemClickListener?.onRegistroItemClickListener(registroList?.get(position)!!)
        }
        holder.vista.setOnLongClickListener{
            onRegistroItemClickListener?.onRegistroItemLongClickListener(registroList?.get(position)!!)
            true
        }
        holder.onBindViews(position)
    }

    class ViewHolder(val vista: View, val registroList: List<RegistroActividad>): RecyclerView.ViewHolder(vista) {
        fun onBindViews(position: Int) {
            vista.findViewById<TextView>(R.id.tvNombreRevision).text = registroList.get(position).idcodigo
            vista.findViewById<TextView>(R.id.tvPrimeraLetraRevision).text = registroList.get(position).idcodigo.first().toUpperCase().toString()
        }
    }


    /**
     * Utilizamos un método en lugar de asignar la funcionalidad vía el constructor
     * de la clase principal para mayor comodidad al momento de sobreescribir la funcionalidad.
     */
    fun setRegistroItemClickListener(onRegistroItemClickListener: OnRegistroClickListener) {
        this.onRegistroItemClickListener = onRegistroItemClickListener
    }

    /**
     * Definimos la interface que permite extender métodos que el RecyclerView no posee
     */
    interface OnRegistroClickListener {
        fun onRegistroItemClickListener(registroActividad: RegistroActividad)
        fun onRegistroItemLongClickListener(registroActividad: RegistroActividad)
    }
}