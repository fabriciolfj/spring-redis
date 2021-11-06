package com.github.fabricio.customerservice.application

import com.github.fabricio.customerservice.application.`in`.CustomerService
import com.github.fabricio.customerservice.application.out.FindCustomerCache
import com.github.fabricio.customerservice.application.out.PutCustomerCache
import com.github.fabricio.customerservice.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerServiceImpl : CustomerService {

    @Autowired
    private lateinit var putCustomerCache: PutCustomerCache

    @Autowired
    private lateinit var findCustomerCache: FindCustomerCache

    override fun save(customer: Customer) {
        putCustomerCache.create(customer)
    }

    override fun find(document: String): Customer {
        return findCustomerCache.find(document)
    }
}