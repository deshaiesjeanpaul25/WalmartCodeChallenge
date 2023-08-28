package com.deshaies.walmartcodechallenge.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.recyclerview.widget.RecyclerView
import com.deshaies.walmartcodechallenge.Country
import com.deshaies.walmartcodechallenge.R

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var countries: List<Country> = emptyList()

    fun updateData(countries: List<Country>) {
        this.countries = countries
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(country: Country){
            itemView.findViewById<TextView>(R.id.tv_country_name).text = country.name.plus(", ")
            itemView.findViewById<TextView>(R.id.tv_country_region).text = country.region
            itemView.findViewById<TextView>(R.id.tv_country_code).text = country.code
            itemView.findViewById<TextView>(R.id.tv_country_capital).text = country.capital
        }
    }
}
