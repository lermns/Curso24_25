import com.example.ramosl_pmdm_examen_2aeval.model.Mascota


interface MascotaDAO {
    fun insertarMascota(user: Mascota)
    fun leerMascota(): List<Mascota>
    fun borrarMascota(id: Int)
    fun borrarTodoMascota()
}