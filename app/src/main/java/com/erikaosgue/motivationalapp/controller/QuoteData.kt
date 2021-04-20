package com.erikaosgue.motivationalapp.controller

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.erikaosgue.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONObject

class QuoteData {

    var quoteArrayList = ArrayList<Quote>()

    //
    fun getQuote(callback: QuoteListAsyncResponse) {

        val url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"

        val quoteRequest = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            { response: JSONArray ->

                for (i in 0 until response.length()) {

                    val quoteObject = response[i] as JSONObject
                    //Converting from Json to Kotlin Object the quote
                    val quote = Quote(quoteObject["quote"].toString(), quoteObject["name"].toString())
                    quoteArrayList.add(quote)
                }
                callback.processFinished(quoteArrayList)
            },
            { error: VolleyError ->
                Log.d("Response: ", error.toString())
            })
        AppController.appControllerInstance!!.addToRequestQueue(quoteRequest)
    }
}