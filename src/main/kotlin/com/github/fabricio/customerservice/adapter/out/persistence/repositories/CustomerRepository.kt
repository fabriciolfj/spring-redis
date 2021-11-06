package com.github.fabricio.customerservice.adapter.out.persistence.repositories

import com.github.fabricio.customerservice.adapter.out.persistence.entities.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerRepository : JpaRepository<CustomerEntity, Long> {

    fun findByDocument(document: String) : Optional<CustomerEntity>
}