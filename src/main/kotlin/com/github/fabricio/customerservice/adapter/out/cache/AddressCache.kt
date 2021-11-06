package com.github.fabricio.customerservice.adapter.out.cache

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fabricio.customerservice.application.out.FindAddressCache
import com.github.fabricio.customerservice.application.out.PutAddressCache
import com.github.fabricio.customerservice.configuration.ConfigCache.Companion.CACHE_ADDRESS
import com.github.fabricio.customerservice.domain.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.Cache
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException
import java.util.*

@Component
class AddressCache : PutAddressCache, FindAddressCache{

    @Autowired
    @Qualifier(CACHE_ADDRESS)
    private lateinit var cache: Cache

    @Autowired
    private lateinit var mapper: ObjectMapper

    override fun find(geocode: String): Address {
        val value = Optional.ofNullable(cache.get(geocode))
                .map { it.get() as String }
                .orElseThrow { throw IllegalArgumentException("Address $geocode not found") }

        return mapper.readValue(value, Address::class.java)
    }

    override fun save(address: Address) {
        cache.put(address.geoCode, mapper.writeValueAsString(address))
    }
}