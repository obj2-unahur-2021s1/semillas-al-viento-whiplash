package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe

class ParcelaTest : DescribeSpec( {

    describe("Una parcela"){
        val unaParcela = Parcela(20,1,8)
        val plantaDeSoja1 = Soja(1998,2.0,false)
        val plantaDeSoja2 = Soja(1997,3.0,true)
        val plantaDeSoja3 = Soja(1994,2.0,false)
        val plantaDeSoja4 = Soja(1996,2.0,true)
        val plantaDeSoja5 = Soja(1996,2.3,false)
        it("Conocer superficie de una parcela"){

        unaParcela.superficie().shouldBe(20)

        }

        it("cantidad maxima de plantas que tolera"){
            unaParcela.cantidadMaximaPlantas().shouldBe(4)
        }

        it ("saber si tiene complicaciones"){
            unaParcela.plantar(plantaDeSoja1)
            unaParcela.plantar(plantaDeSoja2)
            unaParcela.plantar(plantaDeSoja3)
            unaParcela.plantar(plantaDeSoja4)
            plantaDeSoja1.parcelaTieneComplicaciones(unaParcela).shouldBeFalse()

        }

        //Este test no se puede correr porque en el código no devuelve un error sino que en su lugar imprime un mensaje de error
        it("una parcela tira error si quiere agregar una quinta planta de soja"){
            unaParcela.plantar(plantaDeSoja1)
            unaParcela.plantar(plantaDeSoja2)
            unaParcela.plantar(plantaDeSoja3)
            unaParcela.plantar(plantaDeSoja4)

            shouldThrowAny {
                unaParcela.plantar(plantaDeSoja5)
            }

        }









    }





})