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

class Agricultora(val parcelas: MutableList<Parcela>) { // MINIMIZAR MUTABILIDAD = si "por lo tanto cuando se crea una agricultora se configura con todas las parcelas que tiene." no hace falta que sea una lista mutable, porque no cambian
  var ahorrosEnPesos = 20000  // YAGNI = esta variable no se necesita, ni se pidio, dado que la tierra no puede ser ni vendida ni comprada , por lo tanto no necesita esta implementacion

  // Suponemos que una parcela vale 5000 pesos
  fun comprarParcela(parcela: Parcela) { // YAGNI = este método no se necesita, ni se pidio, dado que la tierra no puede ser ni vendida ni comprada , por lo tanto no necesita esta implementacion
    if (ahorrosEnPesos >= 5000) { //
      parcelas.add(parcela)
      ahorrosEnPesos -= 5000
    }
  }

  fun parcelasSemilleras() = //KISS = se puede simplificar
    parcelas.filter {
      parcela -> parcela.plantas.all {
        planta -> planta.daSemillas()
      }
    }

  fun plantarEstrategicamente(planta: Planta) { // SE PODRIA HABER RESUELTO DE FORMA MAS SIMPLE
    val laElegida = parcelas.maxBy { it.cantidadMaximaPlantas() - it.cantidadPlantas }!!
    laElegida.plantas.add(planta)
  }
}
