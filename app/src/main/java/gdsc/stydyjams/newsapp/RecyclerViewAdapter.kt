package gdsc.stydyjams.newsapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gdsc.stydyjams.newsapp.databinding.RecyclerViewItemBinding
import androidx.navigation.findNavController
import gdsc.stydyjams.newsapp.network.Article


class RecyclerViewAdapter(
    var news : List<Article>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private lateinit var binding: RecyclerViewItemBinding
    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        binding = RecyclerViewItemBinding.bind(view)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position%2==0) {
            binding.headlineText.setTextColor(Color.DKGRAY)
        } else {
            binding.headlineText.setTextColor(Color.BLACK)
        }
        binding.headlineText.text = news[position].title
        //binding.headlineImage.setImageResource(news[position].urlToImage)


        holder.itemView.setOnClickListener {
//                val activity = v!!.context as AppCompatActivity
//            val newsFragment = NewsFragment()
//            activity.supportFragmentManager.beginTransaction().replace(R.id.main, newsFragment)
//                .addToBackStack(null).commit()
            val action = ListFragmentDirections.actionListFragmentToNewsFragment2()
            holder.itemView.findNavController().navigate(action)


        }
    }

    override fun getItemCount(): Int {
        return news.size
    }

}