package com.example.pizzaplace

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pizzaplace.databinding.ActivityLoginBinding
import com.example.pizzaplace.databinding.ActivityMainBinding
import com.example.pizzaplace.model.Pedido

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var formaDePagamento = ""
    var tamanhoSelecionado = ""
    val pizzaSelecionadas = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val usuario = bundle?.getString("usuario")

        binding.tvUsuario.text = "Ola $usuario"

    }

    fun calcular(view: View) {
        val idSelecionado = binding.rgTamanhoPizza.checkedRadioButtonId
        var valorTamanhoPizza = 0
        var valor = 0.0
        when (idSelecionado) {
            R.id.rbPequena -> {
                valorTamanhoPizza = 10
                tamanhoSelecionado = binding.rbPequena.text.toString()
            }

            R.id.rbPequena -> {
                valorTamanhoPizza = 12
                tamanhoSelecionado = binding.rbMedia.text.toString()
            }

            R.id.rbGrande -> {
                valorTamanhoPizza = 15
                tamanhoSelecionado = binding.rbGrande.text.toString()
            }
        }
        if (binding.cbAtum.isChecked) {
            valor += (3 + valorTamanhoPizza).toDouble()
            pizzaSelecionadas.add(binding.cbAtum.text.toString())
        }
        if (binding.cbBacon.isChecked) {
            valor += (5 + valorTamanhoPizza).toDouble()
            pizzaSelecionadas.add(binding.cbAtum.text.toString())
        }
        if (binding.cbCalabresa.isChecked) {
            valor += (4 + valorTamanhoPizza).toDouble()
            pizzaSelecionadas.add(binding.cbAtum.text.toString())
        }
        if (binding.cbMussarela.isChecked) {
            valor += (2 + valorTamanhoPizza).toDouble()
            pizzaSelecionadas.add(binding.cbAtum.text.toString())
        }

        val pagamento = binding.spPagamentos.selectedItem as String

        val alert = AlertDialog.Builder(this)

        alert.setTitle("Confirmacao")
        alert.setMessage("Valor: $valor\nPagamento: $pagamento")
        alert.setPositiveButton("SIM", DialogInterface.OnClickListener { dialog, which ->
            val intentDetalheDoPedido = Intent(this, DetalheDoPedidoActivity::class.java)
            val pedido = Pedido(
                binding.etNomeCliente.text.toString(),
                pizzaSelecionadas,
                tamanhoSelecionado,
                pagamento
            )
            intentDetalheDoPedido.putExtra("pedido", pedido)
            startActivity(intentDetalheDoPedido)
        })
        alert.setNegativeButton("NAO", null)
        alert.show()
    }
}