package com.salinas.a4plenespolizas

class CalcularSeguroAutosModel(private val mayor40Anios: Int, private val tipoPoliza: Int,
                               private val bebeAlcohol: Boolean,
                               private val usaLentes: Boolean,
                               private val padeceEnfermedad: Boolean) {

    fun calculateInsuranceCost(
        tipoPoliza: String,
        bebeAlcohol: String,
        usaLentes: String,
        padeceEnfermedad: String,
        mayor40Anios: String
    ): Double {
        val costoBase = if (tipoPoliza == "Cobertura Amplia") 1200.0 else 950.0

        // Inicializar costoTotal con el costoBase
        var costoTotal = costoBase

        // Calcular los cargos adicionales basados en la edad
        if (mayor40Anios == "Si") {
            costoTotal += costoBase * 0.2
        } else {
            costoTotal += costoBase * 0.1
        }

        // Verificar otros criterios y agregar cargos adicionales
        if (bebeAlcohol == "Si") {
            costoTotal += costoBase * 0.1 // 10% por hábito de beber alcohol
        }
        if (usaLentes == "Si") {
            costoTotal += costoBase * 0.05 // 5% por usar lentes
        }
        if (padeceEnfermedad == "Si") {
            costoTotal += costoBase * 0.05 // 5% por tener una enfermedad
        }

        // Redondear el resultado final a un entero si es necesario
        return costoTotal
    }



    fun validateInputs(
        tipoPoliza: String,
        bebeAlcohol: String,
        usaLentes: String,
        padeceEnfermedad: String,
        mayor40Anios: String
    ): Boolean {
        return tipoPoliza != "-Seleccione-" && bebeAlcohol != "-Seleccione-" && usaLentes != "-Seleccione-" &&
                padeceEnfermedad != "-Seleccione-" && mayor40Anios != "-Seleccione-"
    }
}