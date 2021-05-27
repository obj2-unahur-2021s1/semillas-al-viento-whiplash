package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()

  fun superficie() = ancho * largo //SIMPLICIDAD = el metodo resuelve el tema de la superficie , pero no se usa

  //REFACTORIZADO
  fun cantidadMaximaPlantas() =
    if (ancho > largo) this.superficie() / 5 else this.superficie() / 3 + largo // ABSTRACCION / REUSABILIDAD= se podria haber utilizado el resultado del método superficie() para calcular ancho*largo


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


  //fun tieneComplicaciones() // este método es de parcela pero esta en planta

}


