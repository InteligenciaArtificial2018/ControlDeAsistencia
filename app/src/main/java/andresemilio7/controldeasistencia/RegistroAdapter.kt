package andresemilio7.controldeasistencia

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

class RegistroAdapter(var registroList: List<RegistroDeActividad>? = ArrayList<RegistroDeActividad>()): RecyclerView.Adapter<RegistroAdapter.ViewHolder>() {
    private var onRegistroItemClickListener: OnRegistroClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RegistroAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.template_registro, parent, false)

        return ViewHolder(vista, registroList!!)
    }

    override fun getItemCount(): Int {
        return registroList?.count()!!
    }

    override fun onBindViewHolder(holder: RegistroAdapter.ViewHolder, position: Int) {
        // Obtener la posición del item clickeado
        holder.vista.setOnClickListener{
            onRegistroItemClickListener?.onCatedraticoItemClickListener(registroList?.get(position)!!)
        }
        holder.vista.setOnLongClickListener{
            onRegistroItemClickListener?.onCatedraticoItemLongClickListener(registroList?.get(position)!!)
            true
        }
        holder.onBindViews(position)
    }

    class ViewHolder(val vista: View, val registroList: List<RegistroDeActividad>): RecyclerView.ViewHolder(vista) {
        fun onBindViews(position: Int) {
            vista.findViewById<EditText>(R.id.etAsignatura).text = registroList.get(position).idcodigo
            vista.findViewById<EditText>(R.id.etCatedratico).text = registroList.get(position).idCatedratico
            vista.findViewById<EditText>(R.id.etHora).text = registroList.get(position).hora

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
        fun onCatedraticoItemClickListener(registroActividad: RegistroDeActividad)
        fun onCatedraticoItemLongClickListener(registroActividad: RegistroDeActividad)
    }

}