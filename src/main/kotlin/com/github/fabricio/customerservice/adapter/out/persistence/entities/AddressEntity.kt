package com.github.fabricio.customerservice.adapter.out.persistence.entities

import com.github.fabricio.customerservice.domain.Address
import javax.persistence.*

@Entity
@Table(name = "address")
data class AddressEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @Column(name = "street")
        var street: String,
        @Column(name = "city")
        var city: String,
        @Column(name = "zip_code")
        var zipCode: String,
        @Column(name = "number")
        var number: String,
        @Column(name = "geocode")
        var geoCode: String,
        @JoinColumn(name = "id_customer")
        @ManyToOne
        var customer: CustomerEntity?) {

        constructor() : this(null, "", "", "", "", "", null)
}


fun AddressEntity.toEntity(address: Address, customer: CustomerEntity) : AddressEntity {
        this.street = address.street
        this.city = address.city
        this.zipCode = address.zipCode
        this.number = address.number
        this.geoCode = address.geoCode
        this.customer = customer
        return this
}

fun AddressEntity.toDomain() : Address {
        return Address(this.street, this.city, this.number, this.zipCode, this.geoCode)
}