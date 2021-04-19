package com.erikaosgue.motivationalapp.controller

import com.erikaosgue.motivationalapp.model.Quote

interface QuoteListAsyncResponse {

	// This arrayList comes from the callBack call in QuoteData
	fun processFinished(quotes: ArrayList<Quote>)
}