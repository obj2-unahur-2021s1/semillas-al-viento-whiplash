package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class AgricultoraTest:DescribeSpec ({

    describe("Una Agricultora"){
        val unaParcela = Parcela(5,3,8) //3 plantas - 1 espacio
        val unaParcelaGrande = Parcela(2,3,8) //5 plantas - 2 espacios
        val otraParcelaGrande = Parcela(5,4,8) //4 plantas - 1 espacio

        val plantaDeSoja1 = Soja(1998,2.0,false)
        val plantaDeSoja2 = Soja(1997,3.0,true)
        val plantaDeSoja3 = Soja(2008,2.0,false)
        val plantaDeSoja4 = Soja(2012,2.0,false)
        val plantaDeSoja5 = Soja(2015,2.3,false)

        unaParcela.plantar(plantaDeSoja1)
        unaParcela.plantar(plantaDeSoja2)


        unaParcelaGrande.plantar(plantaDeSoja3)
        unaParcelaGrande.plantar(plantaDeSoja4)
        unaParcelaGrande.plantar(plantaDeSoja5)

        otraParcelaGrande.plantar(plantaDeSoja3)
        otraParcelaGrande.plantar(plantaDeSoja5)
        otraParcelaGrande.plantar(plantaDeSoja1)

        val listaDeParcelas = mutableListOf(unaParcela,unaParcelaGrande,otraParcelaGrande)
        val agricultora = Agricultora(listaDeParcelas)

        it ("parcela semillera"){
            agricultora.parcelasSemilleras().shouldContainAll(unaParcelaGrande,otraParcelaGrande)

        }

        it("Plantar estrategicamente una planta"){
            val plantaEspecial = Menta(2008,1.0)
            agricultora.plantarEstrategicamente(plantaEspecial)

            unaParcelaGrande.plantas.shouldContain(plantaEspecial)

        }

    }






})