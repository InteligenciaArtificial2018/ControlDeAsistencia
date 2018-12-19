package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Clases
import andresemilio7.controldeasistencia.data.RegistroActividad
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class RevisionAdapter(var revisionList: List<RegistroActividad>? = ArrayList<RegistroActividad>()): RecyclerView.Adapter<RevisionAdapter.ViewHolder>() {
    private var onRevisionItemClickListener: OnRevisionClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RevisionAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.template_revision, parent, false)

        return ViewHolder(vista, revisionList!!)
    }

    override fun getItemCount(): Int {
        return revisionList?.count()!!
    }

    override fun onBindViewHolder(holder: RevisionAdapter.ViewHolder, position: Int) {
        // Obtener la posición del item clickeado
        holder.vista.setOnClickListener{
            onRevisionItemClickListener?.onRevisionItemClickListener((revisionList?.get(position)!!))
        }
        holder.vista.setOnLongClickListener{
            onRevisionItemClickListener?.onRevisionItemLongClickListener((revisionList?.get(position)!!))
            true
        }
        holder.onBindViews(position)
    }

    class ViewHolder(val vista: View, val revisionList: List<RegistroActividad>): RecyclerView.ViewHolder(vista) {
        fun onBindViews(position: Int) {
            vista.findViewById<TextView>(R.id.tvNombreRevision).text = revisionList.get(position).idcodigo
            vista.findViewById<TextView>(R.id.tvPrimeraLetraRevision).text = revisionList.get(position).idcodigo.first().toUpperCase().toString()
        }
    }


    /**
     * Utilizamos un método en lugar de asignar la funcionalidad vía el constructor
     * de la clase principal para mayor comodidad al momento de sobreescribir la funcionalidad.
     */
    fun setRevisionItemClickListener(onRevisionItemClickListener: OnRevisionClickListener) {
        this.onRevisionItemClickListener = onRevisionItemClickListener
    }

    /**
     * Definimos la interface que permite extender métodos que el RecyclerView no posee
     */
    interface OnRevisionClickListener {
        fun onRevisionItemClickListener(revision: RegistroActividad)
        fun onRevisionItemLongClickListener(clases: RegistroActividad)
    }

}