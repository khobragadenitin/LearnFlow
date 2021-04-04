package com.nmks.kotlinflowdemo

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import java.security.AccessControlContext
import kotlin.coroutines.resume

data class Photo (var name : String, var image : Drawable?)

suspend fun String.getPhoto(context: Context) : Photo = withContext(Dispatchers.IO){
    suspendCancellableCoroutine<Photo> {cancellableCorotine->
        val drawable = with(context){
            val resourceId = resources.getIdentifier(this@getPhoto.toLowerCase(),
            "drawable",
                packageName
            )
            ContextCompat.getDrawable(this,resourceId)
        }
        val photo = Photo(this@getPhoto,drawable)
        cancellableCorotine.resume(photo)

    }
}
