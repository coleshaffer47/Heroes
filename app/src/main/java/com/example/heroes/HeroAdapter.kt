package com.example.heroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class HeroAdapter(private val dataSet: List<Hero>) :
    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView
        val textViewDesc: TextView
        val textViewRanking: TextView
        val layout: ConstraintLayout

        init {
            textViewName = view.findViewById(R.id.textView_heroItem_name)
            textViewDesc = view.findViewById(R.id.textView_heroItem_description)
            textViewRanking = view.findViewById(R.id.textView_heroItem_number)
            layout = view.findViewById(R.id.layout_itemHero)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_hero, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val hero = dataSet[position]
        viewHolder.textViewName.text = hero.name
        viewHolder.textViewDesc.text = hero.description
        viewHolder.textViewRanking.text = hero.ranking.toString()
        viewHolder.layout.setOnClickListener {
            Toast.makeText(it.context,"Behold! " + hero.name + "!", Toast.LENGTH_SHORT).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
