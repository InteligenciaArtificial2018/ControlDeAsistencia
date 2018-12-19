package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Catedraticos
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class CatedraticoAdapter(var catedraticoList: List<Catedraticos>? = ArrayList<Catedraticos>()): RecyclerView.Adapter<CatedraticoAdapter.ViewHolder>() {
    private var onCatedraticoItemClickListener: OnCatedraticoClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CatedraticoAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.template_catedratico, parent, false)

        return ViewHolder(vista, catedraticoList!!)
    }

    override fun getItemCount(): Int {
        return catedraticoList?.count()!!
    }

    override fun onBindViewHolder(holder: CatedraticoAdapter.ViewHolder, position: Int) {
        // Obtener la posición del item clickeado
        holder.vista.setOnClickListener{
            onCatedraticoItemClickListener?.onCatedraticoItemClickListener(catedraticoList?.get(position)!!)
        }
        holder.vista.setOnLongClickListener{
            onCatedraticoItemClickListener?.onCatedraticoItemLongClickListener(catedraticoList?.get(position)!!)
            true
        }
        holder.onBindViews(position)
    }

    class ViewHolder(val vista: View, val catedraticoList: List<Catedraticos>): RecyclerView.ViewHolder(vista) {
        fun onBindViews(position: Int) {
            vista.findViewById<TextView>(R.id.tvNombre).text = catedraticoList.get(position).nombre
            vista.findViewById<TextView>(R.id.tvPrimeraLetra).text = (catedraticoList.get(position).nombre.first().toUpperCase().toString())
            vista.findViewById<TextView>(R.id.tvMostarId).text = catedraticoList.get(position).id.toString()

        }
    }


    /**
     * Utilizamos un método en lugar de asignar la funcionalidad vía el constructor
     * de la clase principal para mayor comodidad al momento de sobreescribir la funcionalidad.
     */
    fun setCatedraticoItemClickListener(onCatedraticoItemClickListener: OnCatedraticoClickListener) {
        this.onCatedraticoItemClickListener = onCatedraticoItemClickListener
    }

    /**
     * Definimos la interface que permite extender métodos que el RecyclerView no posee
     */
    interface OnCatedraticoClickListener {
        fun onCatedraticoItemClickListener(catedraticos : Catedraticos)
        fun onCatedraticoItemLongClickListener(catedraticos: Catedraticos)
    }

}


