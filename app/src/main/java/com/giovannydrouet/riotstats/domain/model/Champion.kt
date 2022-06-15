package com.giovannydrouet.riotstats.domain.model

//Data class that receives the name of every champion, and delivers it to presentation
data class Champion(
    val id: String,
    val name : String,
    val image : String
)
