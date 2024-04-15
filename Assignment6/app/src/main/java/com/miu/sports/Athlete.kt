package com.miu.sports

interface Data {}
data class Athlete(
    val name: String,
    val sport: String,
    val country: String,
    val personalBest: String,
    val award: String,
    val fact: String
) : Data