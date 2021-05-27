package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()
  var cantidadPlantas = 0 //REDUNDANCIA // MUTACION CONTROLADA = no necesito esta variable para obtener la cantidad de plantas, es algo que le puedo preguntar a la lista de plantas con un método en vez de esta variable

  fun superficie() = ancho * largo //SIMPLICIDAD = el metodo resuelve el tema de la superficie , pero no se usa

  fun cantidadMaximaPlantas() =
    if (ancho > largo) ancho * largo / 5 else ancho * largo / 3 + largo // ABSTRACCION / REUSABILIDAD= se podria haber utilizado el resultado del método superficie() para calcular ancho*largo
    //if (ancho > largo) this.superficie() /5 else this.superficie() / 3 + largo

  //fun cantidadDePLantas() = plantas.count() //MUTACION CONTROLADA = este método no está , pero sería ideal antes que la variable cantidadPlantas

  fun plantar(planta: Planta) {  //ROBUSTEZ ?? devería arrojar error al fallar
    if (cantidadPlantas == this.cantidadMaximaPlantas()) {// se podría haber resuelto de forma más simple
      println("Ya no hay lugar en esta parcela")
    } else if (horasSolPorDia > planta.horasDeSolQueTolera() + 2) {
      println("No se puede plantar esto acá, se va a quemar")
    } else {
      plantas.add(planta)
      cantidadPlantas += 1 // REDUNDANCIA = No hace falta sumar cada vez que se agrega una planta a la parcela , se le debería preguntar a un método
    }
  }

  //fun tieneComplicaciones() // este método es de parcela pero esta en planta

}


