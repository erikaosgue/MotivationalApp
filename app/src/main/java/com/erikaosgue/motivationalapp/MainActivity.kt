package com.erikaosgue.motivationalapp

import android.app.VoiceInteractor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.erikaosgue.motivationalapp.controller.AppController
import com.erikaosgue.motivationalapp.controller.QuoteData
import com.erikaosgue.motivationalapp.controller.QuoteListAsyncResponse
import com.erikaosgue.motivationalapp.controller.QuoteViewPagerAdapter
import com.erikaosgue.motivationalapp.databinding.ActivityMainBinding
import com.erikaosgue.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

	private lateinit var quoteViewPagerAdapter: QuoteViewPagerAdapter

	lateinit var activityMainBinding: ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(activityMainBinding.root)

		// QuoteViewPagerAdapter
		quoteViewPagerAdapter = QuoteViewPagerAdapter(supportFragmentManager, getFragments())


		activityMainBinding.viewPager.adapter = quoteViewPagerAdapter
	}

	private fun getFragments(): ArrayList<Fragment> {

		val fragmentList = ArrayList<Fragment>()

		//QuoteData().getQuote makes the request to bring all data from the API
		// The parameter object is pass from the call back
		QuoteData().getQuote(object : QuoteListAsyncResponse {

			// This quotes ArrayList come from the QuoteData getQuote Function that calls the callBack that
			// passes the ArrayList as a Parameter
			override fun processFinished(quotes: ArrayList<Quote>) {
				for (i in 0 until quotes.size) {
					val quoteFragment = QuoteFragment().newInstance(quotes[i].quote, quotes[i].author)
					fragmentList.add(quoteFragment)
				}

				quoteViewPagerAdapter.notifyDataSetChanged()
			}

		})

		return fragmentList
	}

}