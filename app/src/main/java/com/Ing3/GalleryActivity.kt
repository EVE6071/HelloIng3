package com.Ing3

import ListeGalleryActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gallery)

        // Configure les marges pour éviter le chevauchement avec les barres système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Activer la flèche de retour
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(android.R.drawable.ic_menu_revert) // Icône de la flèche
        }

        // Afficher un message de bienvenue
        val welcomeMessage = findViewById<TextView>(R.id.welcome_message)
        welcomeMessage.text = "Bienvenue dans la galerie !"

        // Rediriger vers ListeGalleryActivity lorsqu'on clique sur le bouton "Consulter"
        val btnConsulter = findViewById<Button>(R.id.btnConsulter)
        btnConsulter.setOnClickListener {
            val intent = Intent(this, ListeGalleryActivity::class.java)
            startActivity(intent)
        }

        // Ajouter d'autres comportements pour les autres boutons si nécessaire
        val btnAjouter = findViewById<Button>(R.id.btnAjouter)
        btnAjouter.setOnClickListener {
            // Action pour le bouton "Ajouter" (si besoin)
            val intent = Intent(this, AddGalleryActivity::class.java)
            startActivity(intent)
        }
    }

    // Gestion de l'action lorsque la flèche est cliquée
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Optionnel pour fermer la page actuelle
        return true
    }
}
