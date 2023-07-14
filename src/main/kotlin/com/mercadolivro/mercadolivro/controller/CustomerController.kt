package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.Service.CustomerService
import com.mercadolivro.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.mercadolivro.extension.toCustomerModel
import com.mercadolivro.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(
        var customerService: CustomerService
) {

    @GetMapping
    fun getAll(name: String?): List<CustomerModel>{
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel{
        return customerService.getCustomer(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest){
        customerService.create(customer.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id:String, @RequestBody customer: PutCustomerRequest){
        customerService.update(customer.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id:String){
        customerService.delete(id)
    }

}