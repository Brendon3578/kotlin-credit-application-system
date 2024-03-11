package com.brendon.creditsystem.model

import com.brendon.creditsystem.enumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "Credit")
data class Credit(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    var creditCode: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO, // valor do crédito solicitaddo

    @Column(nullable = false)
    val dayFirstInstallment: LocalDate, // primeiro dia da parcela

    @Column(nullable = false)
    val numberOfInstallments: Int = 0, // número de parcelas

    @Enumerated
    val status: Status = Status.IN_PROGRESS,

    @ManyToOne
    var customer: Customer? = null
)
