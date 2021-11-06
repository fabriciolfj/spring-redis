package com.github.fabricio.customerservice.application

import com.github.fabricio.customerservice.application.`in`.AddressService
import com.github.fabricio.customerservice.application.out.FindAddressCache
import com.github.fabricio.customerservice.application.out.PutAddressCache
import com.github.fabricio.customerservice.domain.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AddressServiceImpl: AddressService {

    @Autowired
    private lateinit var putAddressCache : PutAddressCache

    @Autowired
    private lateinit var findAddressCache: FindAddressCache

    override fun save(address: Address) {
        putAddressCache.save(address)
    }

    override fun find(geocode: String): Address {
        return findAddressCache.find(geocode)
    }
}