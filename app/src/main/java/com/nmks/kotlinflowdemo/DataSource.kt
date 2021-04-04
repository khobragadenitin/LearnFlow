package com.nmks.kotlinflowdemo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow


class DataSource {

    companion object{
        val names : Flow<String> = listOf("Nitin","Pranu","Sarla","Manohar").asFlow()
    }
}