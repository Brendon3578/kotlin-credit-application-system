package com.brendon.creditsystem.model

data class Customer(
        var id: Long? = null,
        var firstName: String = "",
        var lastName: String = "",
        val cpf: String,
        var email: String = "",
        var password: String = "",
        var address: Address = Address(),
        var creditsval : List<Credit> = mutableListOf(),
)
