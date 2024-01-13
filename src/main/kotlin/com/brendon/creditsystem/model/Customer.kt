package com.brendon.creditsystem.model

import jakarta.persistence.*

@Entity
@Table(name = "Customer")
data class Customer(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false)
        var firstName: String = "",

        @Column(nullable = false)
        var lastName: String = "",

        @Column(nullable = false, unique = true)
        val cpf: String,

        @Column(nullable = false, unique = true)
        var email: String = "",

        @Column(nullable = false)
        var password: String = "",

        @Column(nullable = false)
        @Embedded
        var address: Address = Address(),

        @OneToMany(fetch = FetchType.LAZY,
                cascade = arrayOf(CascadeType.REMOVE),
                mappedBy = "customer")
        @Column(nullable = false)
        var creditsval : List<Credit> = mutableListOf(),
)
