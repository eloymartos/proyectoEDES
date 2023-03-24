package clases

class Tipo(cadena:String) {
    var tipo = cadena
        set(value) {
            if (value in arrayOf("acero", "agua", "bicho", "dragon", "electrico", "fantasma", "fuego",
                    "hada", "hielo", "lucha", "normal", "planta", "psiquico", "roca", "siniestro", "tierra",
                    "veneno", "volador")) field = value else {
                field = ""
                IllegalArgumentException("el tipo no es válido")
            }
        }

    companion object{
        val supereficaces = mapOf("acero" to arrayOf("hada", "hielo", "roca"),
            "agua" to arrayOf("fuego", "roca", "tierra"),
            "bicho" to arrayOf("psiquico", "planta"),
            "dragon" to arrayOf("dragon"),
            "electrico" to arrayOf("agua", "volador"),
            "fantasma" to arrayOf("fantasma", "psiquico"),
            "fuego" to arrayOf("planta", "acero", "hielo", "bicho"),
            "hada" to arrayOf("lucha", "dragon", "siniestro"),
            "hielo" to arrayOf("dragon", "planta", "volador", "tierra"),
            "lucha" to arrayOf("normal", "roca", "acero", "siniestro"),
            "planta" to arrayOf("agua", "roca", "tierra"),
            "psiquico" to arrayOf("lucha", "veneno"),
            "roca" to arrayOf("volador", "hielo", "fuego", "bicho"),
            "siniestro" to arrayOf("psiquico", "fantasma"),
            "tierra" to arrayOf("roca", "fuego", "acero", "electrico"),
            "veneno" to arrayOf("planta", "hada"),
            "volador" to arrayOf("planta", "bicho", "lucha"))

        val listanomuy = mapOf(
            "acero" to arrayOf("acero", "agua", "electrico", "fuego"),
            "agua" to arrayOf("agua", "dragon", "planta"),
            "bicho" to arrayOf("acero", "fantasma", "fuego", "hada", "lucha", "veneno", "volador"),
            "dragon" to arrayOf("acero"),
            "electrico" to arrayOf("dragon", "electrico", "planta"),
            "fantasma" to arrayOf("siniestro"),
            "fuego" to arrayOf("agua", "dragon", "fuego", "roca"),
            "hada" to arrayOf("acero", "fuego", "veneno"),
            "huelo" to arrayOf("acero", "agua", "fuego", "hielo"),
            "lucha" to arrayOf("bicho", "hada", "psiquico", "veneno", "volador"),
            "normal" to arrayOf("roca", "acero"),
            "planta" to arrayOf("acero", "bivcho", "dragon", "fuego", "planta", "veneno", "volador"),
            "psiquico" to arrayOf("acero", "psiquico"),
            "roca" to arrayOf("acero", "lucha", "tierra"),
            "siniestro" to arrayOf("hada", "siniestro", "lucha"),
            "tierra" to arrayOf("bicho", "normal"),
            "veneno" to arrayOf("fantasma", "roca", "tierra", "veneno"),
            "volador" to arrayOf("acero", "electrico", "roca")
        )
    }
    fun efectividad(otro:Tipo):Double{
        var respuesta = 0.0
        if (supereficaces[this.tipo]?.contains(otro.tipo) == true) respuesta = 2.0 else{
            if (listanomuy[this.tipo]?.contains(otro.tipo) == true) respuesta = 0.5 else respuesta = 1.0
        }
        return respuesta
    }

}
