package com.example.myapplication1603

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1603.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun style(input: String) : Int{
            if (input.lowercase() == "merapikan"){
                return  15000
            } else if (input.lowercase() == "potong rambut"){
                return 20000
            } else if (input.lowercase() == "mewarnai rambut"){
                return  25000
            } else {
                return 0
            }
        }

        fun tarif(input: String) : Int{
            if (input.lowercase() == "pagi"){
                return  2000
            } else if (input.lowercase() == "siang"){
                return 4000
            } else if (input.lowercase() == "sore"){
                return  4500
            } else if (input.lowercase() == "malam"){
                return  3000
            } else {
                return 0
            }
        }

        binding.BtnSubmit.setOnClickListener {
            val style_input = binding.TxtStyleRambut.text.toString()
            val tarif_input = binding.TxtWaktuPotong.text.toString()
            val pajak = binding.TxtPajak.text.toString().toFloat()
            val diskon = binding.TxtDiskon.text.toString().toFloat()

            val style_rambut = style(style_input)
            val waktu_potong = tarif(tarif_input)

            val hitung_pajak = (style_rambut + waktu_potong) * pajak
            val harga_kotor = style_rambut + waktu_potong + hitung_pajak
            val hitung_diskon = harga_kotor * diskon
            val total_harga = harga_kotor - hitung_diskon
            binding.TVOutputHarga.text = total_harga.toString()

        }
    }
}