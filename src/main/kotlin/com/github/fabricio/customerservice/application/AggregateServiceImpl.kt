package com.github.fabricio.customerservice.application

import com.github.fabricio.customerservice.application.`in`.AggregateService
import com.github.fabricio.customerservice.application.out.FindAddressCache
import com.github.fabricio.customerservice.application.out.FindCustomer
import com.github.fabricio.customerservice.application.out.FindCustomerCache
import com.github.fabricio.customerservice.application.out.SaveCustomer
import com.github.fabricio.customerservice.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AggregateServiceImpl : AggregateService {

    @Autowired
    private lateinit var findAddressCache: FindAddressCache

    @Autowired
    private lateinit var findCustomerCache: FindCustomerCache

    @Autowired
    private lateinit var saveCustomer: SaveCustomer

    @Autowired
    private lateinit var findCustomer: FindCustomer

    override fun save(document: String, geocode: String) {
        var customer = findCustomerCache.find(document)
        customer.addresses = arrayListOf(findAddressCache.find(geocode))

        saveCustomer.save(customer)
    }

    override fun find(document: String): Customer {
        return findCustomer.find(document)
    }
}