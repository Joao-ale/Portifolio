package com.mercadolivro.mercadolivro.controller.request

data class PutCustomerRequest (
        var id: String?,
        var name: String,
        var email: String
)