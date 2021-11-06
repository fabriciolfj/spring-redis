package com.github.fabricio.customerservice.adapter.out.persistence

import com.github.fabricio.customerservice.adapter.out.persistence.entities.CustomerEntity
import com.github.fabricio.customerservice.adapter.out.persistence.entities.toDomain
import com.github.fabricio.customerservice.adapter.out.persistence.entities.toEntity
import com.github.fabricio.customerservice.adapter.out.persistence.repositories.CustomerRepository
import com.github.fabricio.customerservice.application.out.FindCustomer
import com.github.fabricio.customerservice.application.out.SaveCustomer
import com.github.fabricio.customerservice.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class AggregateAdapter : SaveCustomer, FindCustomer {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    override fun find(document: String): Customer {
        return customerRepository.findByDocument(document)
                .map { it.toDomain() }
                .orElseThrow { throw RuntimeException("Customer not found $document") }
    }

    override fun save(customer: Customer) {
        customerRepository.save(CustomerEntity().toEntity(customer))
    }
}