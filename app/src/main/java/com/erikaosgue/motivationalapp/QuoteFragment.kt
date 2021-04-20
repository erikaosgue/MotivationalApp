package com.erikaosgue.motivationalapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlin.random.Random

class QuoteFragment : Fragment() {

	// this is A combination of Create view an Bind data, once the Fragment is Created it will
	//contain the data we pass it with Bundle(), and Once the ViewAdapter call it will return this
	//view with the data fill in the view everytime the users move to a next fragment
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {

		val view = inflater.inflate(R.layout.fragment_quote, container, false)

		val quote = arguments?.get("quote").toString()
		val author = arguments?.get("author").toString()

		val quoteText = view.findViewById<TextView>(R.id.quoteText)
		val authorText = view.findViewById<TextView>(R.id.authorText)

        quoteText.text = quote
		authorText.text = author

		val cardView = view.findViewById<CardView>(R.id.cardView)
//		cardView.setCardBackgroundColor(Color.parseColor("grey"))

		val colors = intArrayOf(R.color.amber_900, R.color.amber_400, R.color.amber_900, R.color.blue_400, R.color.blue_900, R.color.blue_grey_600, R.color.blue_grey_900, R.color.brown_900, R.color.colorAccent, R.color.cyan_800, R.color.dark_purple_300, R.color.dark_purple_900, R.color.deep_orange_A100, R.color.light_green_800, R.color.light_blue_900, R.color.light_green_A700, R.color.lime_900, R.color.dark_purple_500)
		cardView.setBackgroundResource(getColor(colors))

		return view
	}

	fun newInstance(quote: String, author: String): QuoteFragment {


		val fragment = QuoteFragment()

		val bundle = Bundle()
		bundle.apply {
			putString("quote", quote)
			putString("author", author)
		}
		fragment.arguments = bundle
		return fragment
	}
	private fun getColor(colors: IntArray): Int{
		//ThreadLocalRandom.current().nextInt(colors.size)
		return colors[Random.nextInt(colors.size)]
	}
}