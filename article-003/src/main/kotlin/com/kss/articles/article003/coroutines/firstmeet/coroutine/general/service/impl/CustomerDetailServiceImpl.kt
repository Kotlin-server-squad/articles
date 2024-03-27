package com.kss.articles.article003.coroutines.firstmeet.coroutine.general.service.impl

import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.AddressResponse
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.JobResponse
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.service.impl.AddressServiceImpl
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.client.service.impl.JobServiceImpl
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.domain.CustomerDetail
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.repository.Customer
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.repository.service.impl.CustomerRepositoryImpl
import com.kss.articles.article003.coroutines.firstmeet.coroutine.general.service.CustomerDetailService
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class CustomerDetailServiceImpl: CustomerDetailService {
    private val addressService = AddressServiceImpl()
    private val jobService = JobServiceImpl()
    private val customerRepository = CustomerRepositoryImpl()
    override suspend fun getCustomerDetail(customerId: String): CustomerDetail = coroutineScope {
        val customer = async { customerRepository.getCustomer(customerId) }
        val address = async { addressService.getAddress(customerId) }
        val job = async { jobService.getJob(customerId) }

        mapCustomerDetailResponse(customer.await(), address.await(), job.await())
    }

    private fun mapCustomerDetailResponse(customer: Customer, address: AddressResponse, job: JobResponse): CustomerDetail {
        return CustomerDetail(
            id = customer.id,
            username = customer.username,
            email = customer.email,
            address = CustomerDetail.Address(
                id = address.id,
                street = address.street,
                city = address.city,
                country = address.country
            ),
            job = CustomerDetail.Job(
                id = job.id,
                title = job.title,
               description = job.description,
            )
        )
    }
}