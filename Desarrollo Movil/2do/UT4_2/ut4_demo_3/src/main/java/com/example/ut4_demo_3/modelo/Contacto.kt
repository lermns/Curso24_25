package com.example.ut4_demo_3.modelo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contacto(
    val nombre: String,
    val telefono: String,
    val email: String,
): Parcelable
