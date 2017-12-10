package mchehab.com.twitterlikelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

/**
 * Created by muhammadchehab on 12/10/17.
 */
class ListViewAdapter(var context: Context, val listTwitterRows: List<TwitterRow>): BaseAdapter() {

    override fun getItem(position: Int): Any {
        return listTwitterRows[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listTwitterRows.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_row, null)
            viewHolder = ViewHolder()
            viewHolder.imageViewProfile = convertView.findViewById(R.id.imageViewProfile)
            viewHolder.textViewUsername = convertView.findViewById(R.id.textViewUsername)
            viewHolder.textViewTwittername = convertView.findViewById(R.id.textViewTwittername)
            viewHolder.textViewTweetTime = convertView.findViewById(R.id.textViewTweetTime)
            viewHolder.textViewTweetText = convertView.findViewById(R.id.textViewTweetText)

            viewHolder.imageViewChats = convertView.findViewById(R.id.imageViewChats)
            viewHolder.textViewChats = convertView.findViewById(R.id.textViewChats)
            viewHolder.imageViewRetweet = convertView.findViewById(R.id.imageViewRetweet)
            viewHolder.textViewRetweet = convertView.findViewById(R.id.textViewRetweet)
            viewHolder.imageViewLike = convertView.findViewById(R.id.imageViewLike)
            viewHolder.textViewLike = convertView.findViewById(R.id.textViewLike)
            viewHolder.imageViewPrivateMessage = convertView.findViewById(R.id.imageViewPrivateMessage)

            convertView.tag = viewHolder
        }else{
            viewHolder = convertView.tag as ViewHolder
        }

        val twitterRow = listTwitterRows.get(position)

        Picasso.with(context)
                .load(twitterRow.imageURL)
                .transform(CropCircleTransformation())
                .placeholder(R.drawable.profile)
                .into(viewHolder.imageViewProfile)

        viewHolder.textViewUsername!!.text = twitterRow.username
        viewHolder.textViewTwittername!!.text = twitterRow.twitterName
        viewHolder.textViewTweetTime!!.text = twitterRow.timeOfTweet
        viewHolder.textViewTweetText!!.text = twitterRow.tweetMessage

        viewHolder.textViewChats!!.text = "${twitterRow.messageCount} "
        viewHolder.textViewRetweet!!.text = "${twitterRow.retweetCount} "
        viewHolder.textViewLike!!.text = "${twitterRow.likeCount} "

        return convertView!!
    }

    class ViewHolder {
        var imageViewProfile: ImageView? = null
        var textViewUsername: TextView? = null
        var textViewTwittername: TextView? = null
        var textViewTweetTime: TextView? = null
        var textViewTweetText: TextView? = null

        var imageViewChats: ImageView? = null
        var textViewChats: TextView? = null
        var imageViewRetweet: ImageView? = null
        var textViewRetweet: TextView? = null
        var imageViewLike: ImageView? = null
        var textViewLike: TextView? = null
        var imageViewPrivateMessage: ImageView? = null
    }
}