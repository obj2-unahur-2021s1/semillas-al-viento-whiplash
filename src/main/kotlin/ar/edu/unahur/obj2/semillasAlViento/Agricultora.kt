package ar.edu.unahur.obj2.semillasAlViento

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