package com.salsipuedes.gob.recyclerview.api.response

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)