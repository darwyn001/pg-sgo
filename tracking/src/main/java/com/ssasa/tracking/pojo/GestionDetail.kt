package com.ssasa.tracking.pojo

import java.util.*

data class GestionDetail(
        val name: String,
        val comment: String,
        val actor: String,
        val status: Int,
        val date: Date,
        val paramList: ArrayList<Int>?
)