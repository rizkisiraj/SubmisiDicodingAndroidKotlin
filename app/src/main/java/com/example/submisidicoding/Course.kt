package com.example.submisidicoding
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Course (
    val title: String,
    val description: String,
    val photo: String,
    val semester: String
) : Parcelable