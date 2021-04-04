package com.nmks.kotlinflowdemo

import android.content.Context
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class PhotoRepository(val names : Flow<String>,var context: Context) {

    val flowOfPhoto : Flow<Photo> =
        names.map {
            it.getPhoto(context)
        }.onEach { delay(1000L) }
}