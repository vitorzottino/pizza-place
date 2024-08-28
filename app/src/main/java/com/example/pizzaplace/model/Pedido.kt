package com.example.pizzaplace.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pedido(

    val nomeCliente: String,
    val sabores: List<String>,
    val tamanho: String,
    val tipoPagamento: String

) : Parcelable