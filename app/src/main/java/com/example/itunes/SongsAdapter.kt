package com.example.itunes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongsAdapter(private val mTracks: List<Track>) :
    RecyclerView.Adapter<SongsAdapter.ViewHolder>() {


    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val trackNameTextView: TextView = itemView.findViewById<TextView>(R.id.track_name)
        val trackArtistTextView: TextView = itemView.findViewById<TextView>(R.id.track_artist)
        val trackYearTextView: TextView = itemView.findViewById<TextView>(R.id.track_year)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val songView = inflater.inflate(R.layout.track_item, parent, false)
        return ViewHolder(songView)
    }

    override fun onBindViewHolder(viewHolder: SongsAdapter.ViewHolder, position: Int) {

        val track: Track = mTracks[position]

        val trackName = viewHolder.trackNameTextView
        trackName.text = track.name

        val trackArtist = viewHolder.trackArtistTextView
        trackArtist.text = track.artist

        val trackYear = viewHolder.trackYearTextView
        trackYear.text = track.releaseDate

    }

    override fun getItemCount(): Int {
        return mTracks.size
    }
}