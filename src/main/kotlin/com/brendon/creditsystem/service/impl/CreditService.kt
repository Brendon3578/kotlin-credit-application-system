package com.brendon.creditsystem.service.impl

import com.brendon.creditsystem.model.Credit
import com.brendon.creditsystem.repository.CreditRepository
import com.brendon.creditsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomerId(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(creditCode: UUID, customerId: Long): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Credit code $creditCode not found")

        return if (credit.customer?.id == customerId) credit
            else throw RuntimeException("Not your Credit")
    }

}