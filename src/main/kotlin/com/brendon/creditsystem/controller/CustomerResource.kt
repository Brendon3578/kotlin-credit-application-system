package com.brendon.creditsystem.controller

import com.brendon.creditsystem.dto.CustomerDto
import com.brendon.creditsystem.dto.CustomerUpdateDto
import com.brendon.creditsystem.dto.CustomerView
import com.brendon.creditsystem.model.Customer
import com.brendon.creditsystem.service.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : CustomerView {
        val customer : Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody customerUpdateDto: CustomerUpdateDto
    ): CustomerView {
        val customer : Customer = this.customerService.findById(id)
        val customerUpdated = this.customerService.save(
            customerUpdateDto.toEntity(customer)
        )
        return CustomerView(customerUpdated)
    }

}