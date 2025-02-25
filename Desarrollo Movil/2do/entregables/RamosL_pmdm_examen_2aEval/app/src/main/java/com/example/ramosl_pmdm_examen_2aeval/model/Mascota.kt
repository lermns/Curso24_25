package com.example.ramosl_pmdm_examen_2aeval.model

data class Mascota(
    var id: Int? = null,
    var nombre: String = "",
    var tipo: String = "",
    var sexo: String = ""
) {
    override fun toString(): String {
        return "id: $id, nombre: $nombre, tipo: $tipo, sexo: $sexo"
    }
}
