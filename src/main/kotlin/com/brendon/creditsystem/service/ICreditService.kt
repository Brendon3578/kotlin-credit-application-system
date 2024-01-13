package com.brendon.creditsystem.service

import com.brendon.creditsystem.model.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomerId(customerId: Long): List<Credit>
    fun findByCreditCode(creditCode: UUID, customerId: Long): Credit?
}