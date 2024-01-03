package com.brendon.creditsystem.model

import com.brendon.creditsystem.enumeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class Credit(
        val id: Long? = null,
        val creditCode: UUID = UUID.randomUUID(),
        val creditValue: BigDecimal = BigDecimal.ZERO, // valor do crédito solicitaddo
        val dayFirstInstallment: LocalDate, // primeiro dia da parcela
        val numberOfInstalalments: Int = 0, // número de parcelas
        val status: Status = Status.IN_PROGRESS,
        val customer: Customer? = null
)
