package com.github.fabricio.customerservice.adapter.out.cache

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fabricio.customerservice.application.out.FindCustomerCache
import com.github.fabricio.customerservice.application.out.PutCustomerCache
import com.github.fabricio.customerservice.configuration.ConfigCache.Companion.CACHE_CUSTOMER
import com.github.fabricio.customerservice.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.Cache
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException
import java.util.*

@Component
class CustomerCache : FindCustomerCache, PutCustomerCache{

    @Autowired
    @Qualifier(CACHE_CUSTOMER)
    private lateinit var cache: Cache

    @Autowired
    private lateinit var mapper: ObjectMapper

    override fun find(document: String): Customer {
        val value = Optional.ofNullable(cache.get(document))
                .map { it.get() as String }
                .orElseThrow { throw IllegalArgumentException("Customer $document not found") }

        return mapper.readValue(value, Customer::class.java)
    }

    override fun create(customer: Customer) {
        cache.put(customer.document, mapper.writeValueAsString(customer))
    }
}