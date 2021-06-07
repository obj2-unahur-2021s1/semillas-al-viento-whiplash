package ar.edu.unahur.obj2.semillasAlViento

class Agricultora(val parcelas: List<Parcela>) {


    fun parcelasSemilleras() = // REFACTORIZADO
        parcelas.filter { it.esSemillera()}

    fun plantarEstrategicamente(planta: Planta) {
        val laElegida = parcelas.maxBy { it.cantidadMaximaPlantas() - it.cantidadDePlantas() }!!
        laElegida.plantar(planta)  // REFACTIRIZADO
    }
}