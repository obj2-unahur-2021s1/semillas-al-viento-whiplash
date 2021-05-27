package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencionSemilla: Int, var altura: Double) {
  fun esFuerte() = this.horasDeSolQueTolera() > 10     //SIMPLICIDAD = resuelve lo solicitado de forma concreta y simple

  fun parcelaTieneComplicaciones(parcela: Parcela) =   // (DES)ACOPLAMIENTO = este método deberia ser de parcela y no de la planta
    parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia } //(DES)ACOPLAMIENTO = este método accede a la lista de plantas de la parcela, esta acoplado a la implementacion de parcela, si cambia el código esto ya no sirve

  abstract fun horasDeSolQueTolera(): Int
  abstract fun daSemillas(): Boolean
}

//SIMPLICIDAD
class Menta(anioObtencionSemilla: Int, altura: Double) : Planta(anioObtencionSemilla, altura) { // se refactoriza de Float A double para poder correr Test
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = this.esFuerte() || altura > 0.4
}

//COHESION = en este caso la Soja y la soja transgénica son una sola clase, no es correcto y no es cohesivo, se apunta que esta clase resuelva todos los problemas de otra subclase
//FLEXIBILIDAD = la implementacion no es flexible dado que si se agrega un cambio afecta a las dos tipos de planta cosa que no sería necesario si se hubieran implementado correctamente

class Soja(anioObtencionSemilla: Int, altura: Double, val esTransgenica: Boolean) : Planta(anioObtencionSemilla, altura) { //Se Refactoriza la altura de float a doble para poder realizar test
  override fun horasDeSolQueTolera(): Int  {  //COHESION = hace demasiadas cosas y podrian ser menos cosas
    // ¡Magia de Kotlin! El `when` es como un `if` pero más poderoso:
    // evalúa cada línea en orden y devuelve lo que está después de la flecha.
    val horasBase = when {
      altura < 0.5  -> 6
      altura < 1    -> 7
      else          -> 9
    }

    return if (esTransgenica) horasBase * 2 else horasBase
  }

  // override fun daSemillas() = False // MUTACIONES CONTROLADAS = podria ser un método solo de sojaTransgenica y no un atributo


  override fun daSemillas(): Boolean  {
    if (this.esTransgenica) {
      return false
    }

    return this.esFuerte() || (this.anioObtencionSemilla > 2007 && this.altura > 1)  //this.altura > 1 = se podria crear un metodo que resuelva esto y se reutilice cada vez que se necesita
  }
}
