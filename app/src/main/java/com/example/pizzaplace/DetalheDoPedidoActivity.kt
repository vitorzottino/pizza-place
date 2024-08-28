package com.example.pizzaplace

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pizzaplace.databinding.ActivityDetalheDoPedidoBinding
import com.example.pizzaplace.model.Pedido

class DetalheDoPedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalheDoPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalheDoPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pedido = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("pedido", Pedido::class.java)
        } else {
            intent.getParcelableExtra("pedido")
        }
        Toast.makeText(this, pedido?.nomeCliente, Toast.LENGTH_SHORT).show()
    }
}