package com.example.medlists.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.medlists.databinding.ActivityMainBinding
import com.example.medlists.ui.adapters.ViewPagerAdapter
import com.example.medlists.ui.fragments.MedicineFragment
import com.example.medlists.ui.fragments.DiseaseFragment
import com.example.medlists.ui.fragments.DoctorFragment
import com.google.android.material.tabs.TabLayoutMediator
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.medlists.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val tabTitles = listOf("Препараты", "Заболевания", "Врачи")

    private val ADD_ITEM_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val fragments = listOf(
            MedicineFragment(),
            DiseaseFragment(),
            DoctorFragment()
        )

        val adapter = ViewPagerAdapter(this, fragments)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_add -> {
                // Запускаем AddItemActivity для результата
                val intent = Intent(this, AddItemActivity::class.java)
                startActivityForResult(intent, ADD_ITEM_REQUEST_CODE)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_ITEM_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val name = data?.getStringExtra("name") ?: return
            val description = data.getStringExtra("description") ?: ""

            // Здесь обработать добавленную запись, например обновить список
            Toast.makeText(this, "Добавлено: $name", Toast.LENGTH_SHORT).show()
        }
    }
}
