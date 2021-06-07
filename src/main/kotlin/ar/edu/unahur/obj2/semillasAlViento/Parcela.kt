package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()

  fun superficie() = ancho * largo

  //REFACTORIZADO
  fun cantidadMaximaPlantas() =
    if (ancho > largo) this.superficie() / 5 else this.superficie() / 3 + largo


    fun tieneComplicaciones() =
        plantas.any { it.horasDeSolQueTolera() < horasSolPorDia }

  fun cantidadDePlantas() = plantas.size


  //REFACTORIZADO
  fun plantar(planta: Planta) {
    when {
        this.cantidadDePlantas() == this.cantidadMaximaPlantas() -> {
          throw Exception("Ya no hay lugar en esta parcela")
        }
        horasSolPorDia > planta.horasDeSolQueTolera() + 2 -> {
          throw Exception("No se puede plantar esto acá, se va a quemar")
        }
        else -> {
          plantas.add(planta)
        }
    }
  }

  //REFACTORIZADO
  fun esSemillera(): Boolean =  plantas.all{it.daSemillas()}


}


