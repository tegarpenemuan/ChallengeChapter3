package com.tegarpenemuan.challengechapter3.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val nama: String?,
    val usia: Int?,
    val alamat: String?,
    val pekerjaan: String?
): Parcelable