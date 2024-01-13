package com.brendon.creditsystem.service

import com.brendon.creditsystem.model.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}