package com.offbyamilestudios.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.offbyamilestudios.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityMainBinding
	private val myName: MyName = MyName("Jeremy DuBois")
	
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		binding.myName = myName
		setSupportActionBar(toolbar)
		
		materialButton.setOnClickListener {
			addNickname(it)
		}
		
		
	}
	private fun addNickname(view: View) {
		binding.apply {
			myName?.nickName = edit_text_nickname.text.toString()
			invalidateAll()
			materialButton.visibility = View.GONE
			edit_text_field.visibility = View.GONE
			edit_text_nickname.visibility = View.GONE
			nickname_text.visibility = View.VISIBLE
			
			// This hides the KeyBoard
			val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
			imm.hideSoftInputFromWindow(view.windowToken, 0)
		}
	
	}
}
