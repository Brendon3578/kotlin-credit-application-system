package com.brendon.creditsystem.dto

import com.brendon.creditsystem.model.Credit
import com.brendon.creditsystem.model.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate, // primeiro dia da parcela
    val numberOfInstallments: Int, //número de parcelas
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
