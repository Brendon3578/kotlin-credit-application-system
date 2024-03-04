package com.brendon.creditsystem.service.impl

import com.brendon.creditsystem.exception.BusinessException
import com.brendon.creditsystem.model.Credit
import com.brendon.creditsystem.repository.CreditRepository
import com.brendon.creditsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        this.validDayFirstInstallment(credit.dayFirstInstallment)
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
            ?: throw BusinessException("Credit code $creditCode not found")

        return if (credit.customer?.id == customerId) credit
        else throw IllegalArgumentException("Contact Admin")
    }

    private fun validDayFirstInstallment(dayFirstInstallment : LocalDate):
            Boolean {
        return if (dayFirstInstallment.isBefore(LocalDate.now().plusMonths(3))) true
        else throw BusinessException("Invalid Date")
    }

}