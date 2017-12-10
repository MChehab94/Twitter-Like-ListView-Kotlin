package mchehab.com.twitterlikelistview

/**
 * Created by muhammadchehab on 12/10/17.
 */

data class TwitterRow(
        val imageURL: String,
        val username: String,
        val twitterName: String,
        val timeOfTweet: String,
        val tweetMessage: String,
        val messageCount: Int,
        val retweetCount: Int,
        val likeCount: Int
)