package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencionSemilla: Int, val altura: Double) {

  abstract fun horasDeSolQueTolera(): Int

  fun esFuerte() = this.horasDeSolQueTolera() > 10

  open fun daSemillas(): Boolean =  this.esFuerte()
}

//SIMPLICIDAD
class Menta(anioObtencionSemilla: Int, altura: Double) : Planta(anioObtencionSemilla, altura) { // se refactoriza de Float A double para poder correr Test
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = super.daSemillas()|| altura > 0.4
}


open class Soja(anioObtencionSemilla: Int, altura: Double) : Planta(anioObtencionSemilla, altura) { //Se Refactoriza la altura de float a doble para poder realizar test

  //REFACTORIZADO
  override fun horasDeSolQueTolera(): Int  {
    return when {
      altura < 0.5  -> 6
      altura < 1    -> 7
      else          -> 9
    }
  }

  //REFACTORIZADO
  override fun daSemillas(): Boolean  =
    super.daSemillas() || (anioObtencionSemilla > 2007 && altura > 1)

}

//REFACTORIZADO
class SojaTransgenica(anioObtencionSemilla: Int, altura: Double) : Soja(anioObtencionSemilla, altura){

  override fun daSemillas() = false
  override fun horasDeSolQueTolera() = super.horasDeSolQueTolera() * 2



}


