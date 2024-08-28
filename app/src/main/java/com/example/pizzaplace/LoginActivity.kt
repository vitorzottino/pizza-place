package com.example.pizzaplace

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pizzaplace.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun login(view: View) {
        val login = binding.etLogin.text.toString()
        val senha = binding.etSenha.text.toString()

        if (login == "FIAP" && senha == "123") {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("usuario", login)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Usuario ou senha invalidos", Toast.LENGTH_SHORT).show()
        }

    }
}