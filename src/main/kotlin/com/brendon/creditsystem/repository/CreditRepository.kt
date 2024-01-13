package com.brendon.creditsystem.repository

import com.brendon.creditsystem.model.Credit
import com.brendon.creditsystem.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit?

    @Query(
        value = "SELECT * FROM CREDIT WHERE CREDIT_ID = ?1",
        nativeQuery = true
    )
    fun findAllByCustomerId(customerId: Long): List<Credit> ;
}