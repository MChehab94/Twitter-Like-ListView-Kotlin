package mchehab.com.twitterlikelistview

import kotlinx.android.synthetic.main.listview_row.view.*
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_row, null)
        }

        val twitterRow = listTwitterRows.get(position)

        Picasso.with(context)
                .load(twitterRow.imageURL)
                .transform(CropCircleTransformation())
                .placeholder(R.drawable.profile)
                .into(convertView!!.imageViewProfile)

        convertView.textViewUsername!!.text = twitterRow.username
        convertView.textViewTwittername!!.text = twitterRow.twitterName
        convertView.textViewTweetTime!!.text = twitterRow.timeOfTweet
        convertView.textViewTweetText!!.text = twitterRow.tweetMessage

        convertView.textViewChats!!.text = "${twitterRow.messageCount} "
        convertView.textViewRetweet!!.text = "${twitterRow.retweetCount} "
        convertView.textViewLike!!.text = "${twitterRow.likeCount} "

        return convertView
    }
}