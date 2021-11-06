package com.github.fabricio.customerservice.adapter.out.persistence.entities

import com.github.fabricio.customerservice.domain.Customer
import javax.persistence.*

@Entity
@Table(name = "customer")
data class CustomerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @Column(name = "name")
        var name: String,
        @Column(name = "document")
        var document: String,
        @OneToMany(cascade = [CascadeType.REMOVE, CascadeType.PERSIST], mappedBy = "customer")
        var addresses: List<AddressEntity>) {

        constructor() : this(null, "", "", emptyList())
}

fun CustomerEntity.toEntity(customer: Customer) : CustomerEntity {
        this.name = customer.name
        this.document = customer.document
        this.addresses = customer.addresses.map { AddressEntity().toEntity(it, this) }
        return this
}

fun CustomerEntity.toDomain() : Customer {
        return Customer(this.name, this.document, this.addresses.map { it.toDomain() })
}