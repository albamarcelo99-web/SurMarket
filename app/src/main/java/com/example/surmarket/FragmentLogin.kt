package com.example.surmarket


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlin.math.sign

class FragmentLogin : Fragment() {
    private lateinit var ETX_frg_login_username: EditText
    private lateinit var ETX_frg_login_password: EditText
    private lateinit var txv_frg_login_recover: TextView
    private lateinit var btn_frg_login: Button
    private lateinit var btn1_frg_login: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fracment_login,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inizalice_views(view)
        configure_listeners()
    }

    private fun inizalice_views(view: View) {
        ETX_frg_login_username =view.findViewById(R.id.ETX_frg_login_username)
        ETX_frg_login_password =view.findViewById(R.id.ETX_frg_login_password)
        txv_frg_login_recover =view.findViewById(R.id.txv_frg_login_recover)
        btn_frg_login =view.findViewById(R.id.btn_frg_login)
        btn1_frg_login =view.findViewById(R.id.btn1_frg_login)
    }

    private fun configure_listeners() {
        txv_frg_login_recover.setOnClickListener {

        }
        btn_frg_login.setOnClickListener {
            SignIn()
        }
        btn1_frg_login.setOnClickListener {

        }

    }
    private fun FragmentLogin.SignIn() {
        val user= ETX_frg_login_username.text.toString().trim()
        val password= ETX_frg_login_password.toString().trim()
        if (!verify_Integrity(user,password)) {
            return
        }
            if (verify_Credentials(user, password)) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.login_welconme),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.login_error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    private fun verify_Integrity(user: String, password: String): Boolean {
        var res= true
        if(user.isEmpty()){
            ETX_frg_login_username.error= getString(R.string.userEmpy)
            res=false
        }
        else
        {
            ETX_frg_login_username.error= null
        }
        if(password.isEmpty()){
            ETX_frg_login_password.error= getString(R.string.passwordEmpy)
            res=false
        }
        else
        {
            ETX_frg_login_password.error= null
        }
        return res
    }
    private fun verify_Credentials(user: String, password: String): Boolean {

        return user=="admin"&& password=="123456"
    }

}


