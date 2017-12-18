package com.qkrsogusl3.mylibrary

import android.content.Intent
import android.net.Uri
import com.unity3d.player.UnityPlayer
import java.io.File

/**
 * Created by SEONG on 2017-12-11.
 */
fun StartSelect(address:String, subject:String, body:String, mimeType:String, chooser:String, attachmentPath:String) {
    val intent = Intent()

    intent.action = Intent.ACTION_SEND
    intent.type = mimeType
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(address))
    intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    intent.putExtra(Intent.EXTRA_TEXT, body)

    val file = File(attachmentPath)

    if(file.exists() && file.isFile){
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
    }

    UnityPlayer.currentActivity.applicationContext.startActivity(
            Intent.createChooser(
                    intent, chooser
            )
    )


}