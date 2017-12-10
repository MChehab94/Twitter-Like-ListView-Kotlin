package mchehab.com.twitterlikelistview

import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listTwitterRows = createList()
        val listViewAdapter = ListViewAdapter(this@MainActivity, listTwitterRows)
        listView.adapter = listViewAdapter
    }

    private fun createList(): List<TwitterRow> {
        val listTwitterRow = ArrayList<TwitterRow>()
        listTwitterRow.add(TwitterRow(
                "http://i.dailymail.co.uk/i/pix/2016/04/12/23/3319F89C00000578-3536787-image-m-19_1460498410943.jpg",
                "Mohamad Chehab",
                "@mchehab94",
                "39m",
                "This is my tweet message!",
                12,
                15,
                100))

        listTwitterRow.add(TwitterRow(
                "https://www.w3schools.com/css/paris.jpg",
                "First Lastname",
                "@firstlastname",
                "20h",
                "This is my tweet message!",
                2,
                25,
                10))

        listTwitterRow.add(TwitterRow(
                "https://www.w3schools.com/css/trolltunga.jpg",
                "Someother name",
                "@someothername",
                "1d",
                "This is a very long message to see how the line is going to wrap in the list, " + "some other text for " +
                        "testing...",
                3,
                20,
                13))

        listTwitterRow.add(TwitterRow(
                "http://wallpaper-gallery.net/images/image/image-11.jpg",
                "Some Name",
                "@somename",
                "2d",
                "This is some other tweet\nMultiline to see how row  will\nbe displayed",
                59,
                193,
                529))
        listTwitterRow.addAll(listTwitterRow)
        return listTwitterRow
    }
}