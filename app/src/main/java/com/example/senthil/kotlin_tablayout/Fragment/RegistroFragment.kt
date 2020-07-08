package com.example.senthil.kotlin_tablayout.Fragment


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.senthil.kotlin_tablayout.R


public class RegistroFragment : Fragment(){

    lateinit var edtName:EditText
    lateinit var edtEmail:EditText
    lateinit var btnSave:Button
    lateinit var btnRetrive:Button
    lateinit var btnClear:Button

    private val PREFS_NAME = "kotlincodes"
    private val sharedPref: SharedPreferences? = context?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d("mydata","obj defined")
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)

        //asigna valores a los controles para evitar que esten vacios, podria evitar errores
        val now_name = view?.findViewById<View>(R.id.edt_name) as EditText?
        val now_mail = view?.findViewById<View>(R.id.edt_email) as EditText?
        now_name?.setText("name");
        now_mail?.setText("email");

        //crea variable apuntando al xml, para ahorrar espacio y que no se vea tan feo
        val root = inflater.inflate(R.layout.fragment_registro, container, false)

        //crea variables con cada boton y elemento de texto usando el root antes creado
        val edtName = root.findViewById<View>(R.id.edt_name) as EditText
        val edtEmail = root.findViewById<View>(R.id.edt_email) as EditText
        val btnClear = root.findViewById<View>(R.id.btn_save) as Button
        val btnSave = root.findViewById<View>(R.id.btn_save) as Button
        val btnRetrive = root.findViewById<View>(R.id.btn_save) as Button
/*        val btnClear: Button? = view?.findViewById<View>(R.id.btn_clear) as Button?
        val btnSave: Button? = view?.findViewById<View>(R.id.btn_save) as Button?
        val btnRetrive: Button? = view?.findViewById<View>(R.id.btn_retriev) as Button?*/


        //boton de guardado
        btnSave.setOnClickListener {
            Log.d("mydata","entering save listener")

            val name=edtName!!.editableText.toString()
            val email=edtEmail!!.editableText.toString()
            Log.d("mydata",name)
            Log.d("mydata",email)
            save("name",name)
            save("email",email)

            Toast.makeText(activity,"Data Stored",Toast.LENGTH_SHORT).show()
            //to save an Int
            //(activity as TabLayoutActivity?)?.save("intval",1)

            //to save boolien
            //(activity as TabLayoutActivity?)?.save("bool",true)

        }
        //boton de lectura
        btnRetrive.setOnClickListener {
            if (getValueString("name")!=null) {
                edtName.hint = getValueString("name")!!
                Toast.makeText(activity,"Data Retrieved",Toast.LENGTH_SHORT).show()
            }else{
                edtName.hint="NO value found"
            }
            if (getValueString("email")!=null) {
                edtEmail.hint = getValueString("email")!!
            }else{
                edtEmail.hint="No value found"
            }


        }
        //elimina todos los datos
        btnClear.setOnClickListener {
            clearSharedPreference()
            Toast.makeText(activity,"Data Cleared",Toast.LENGTH_SHORT).show()
        }
        return inflater.inflate(R.layout.fragment_registro, container, false)
    }

    /////////////////////////////AQUI COMIENZAN LAS FUNCIONES QUE HACEN LA ESCITURA Y LECTURA COMO TAL//////////////////////////////////////////////////
    //cada funcion esta ordenada de la manera: string, int, bool, puedes guardar cualquiera de esos datos y no deberia dar problemas

    //logica de guardado
    fun save(KEY_NAME: String, text: String) {

        val editor: SharedPreferences.Editor? = sharedPref?.edit()

        editor?.putString(KEY_NAME, text)

        editor!!.commit()
    }

    fun save(KEY_NAME: String, value: Int) {
        val editor: SharedPreferences.Editor? = sharedPref?.edit()

        editor?.putInt(KEY_NAME, value)

        editor?.commit()
    }

    fun save(KEY_NAME: String, status: Boolean) {

        val editor: SharedPreferences.Editor? = sharedPref?.edit()

        editor?.putBoolean(KEY_NAME, status!!)

        editor?.commit()
    }

    //logica de lectura
    fun getValueString(KEY_NAME: String): String? {

        return sharedPref?.getString(KEY_NAME, null)


    }

    fun getValueInt(KEY_NAME: String): Int? {

        return sharedPref?.getInt(KEY_NAME, 0)
    }

    fun getValueBoolien(KEY_NAME: String, defaultValue: Boolean): Boolean? {

        return sharedPref?.getBoolean(KEY_NAME, defaultValue)

    }

    //logica de borrado
    fun clearSharedPreference() {

        val editor: SharedPreferences.Editor? = sharedPref?.edit()

        //sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

        editor?.clear()
        editor?.commit()
    }

    //logica para remover valor, no esta considerado entre lo que debe implementarse pero podria servir
    fun removeValue(KEY_NAME: String) {

        val editor: SharedPreferences.Editor? = sharedPref?.edit()

        editor?.remove(KEY_NAME)
        editor?.commit()
    }


    /////////////////////////////////////////////////////////////////////


}
