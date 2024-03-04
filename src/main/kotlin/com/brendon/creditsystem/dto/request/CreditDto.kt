package com.brendon.creditsystem.dto.request

import com.brendon.creditsystem.model.Credit
import com.brendon.creditsystem.model.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid input")
    val creditValue: BigDecimal,
    @field:Future
    val dayFirstOfInstallment: LocalDate, // primeiro dia da parcela
    val numberOfInstallments: Int, //número de parcelas
    @field:NotNull(message = "Invalid input")
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
