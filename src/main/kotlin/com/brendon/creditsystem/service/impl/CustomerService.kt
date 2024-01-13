package com.brendon.creditsystem.service.impl

import com.brendon.creditsystem.model.Customer
import com.brendon.creditsystem.repository.CustomerRepository
import com.brendon.creditsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {


    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException("Id $id not found")
        }


    override fun delete(id: Long) =
        this.customerRepository.deleteById(id)
}