import java.nio.file.Files
import java.nio.file.Paths

class LectorLog {
    private var totalCambiosControlador = 0
    private var totalCambiosVista = 0

    fun menuLog() {
        println(
            """
        Seleccione una opción:
        1) Analizar Log del controlador.
        2) Analizar Log de la vista.
        0) Salir
        """.trimIndent()
        )

        when (readln().toIntOrNull()) {
            1 -> {
                val logControlador =
                    leerLogs("C:\\Users\\juanj\\IdeaProjects\\modeloVistaExplorador\\logs\\archivoControlador.log")
                totalCambiosControlador += analizarLogs(logControlador, "Log Controlador")
                menuLog()
            }

            2 -> {
                val logVista = leerLogs("C:\\Users\\juanj\\IdeaProjects\\modeloVistaExplorador\\logs\\archivoVista.log")
                totalCambiosVista += analizarLogs(logVista, "Log Vista")
                menuLog()
            }

            0 -> {
                println("Saliendo del programa.")
                println("Total de actualizaciones en Controlador: $totalCambiosControlador")
                println("Total de actualizaciones en Vista: $totalCambiosVista")
            }

            else -> {
                println("Opción no válida. Inténtalo de nuevo.")
                menuLog()
            }
        }

    }


    private fun leerLogs(rutaArchivo: String): List<String> {
        try {
            return Files.readAllLines(Paths.get(rutaArchivo))
        } catch (e: Exception) {
            println("Error al leer el archivo: $e")
        }
        return emptyList()
    }

    private fun analizarLogs(logs: List<String>, nombreLog: String): Int {
        val cambios = logs.size
        println("Total de actualizaciones en $nombreLog: $cambios\n")
        return cambios
    }


}