package com.caselles.miscontactos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.text.Editable;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button boton;
    EditText etNacimiento;
    EditText etNombre;
    EditText etEmail;
    EditText etTelefono;
    EditText etDescripcion;

    DatePickerDialog.OnDateSetListener setListener;
    ArrayList<contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNacimiento = findViewById(R.id.etNacimiento);
        Calendar calendario = Calendar.getInstance();
        final int año = calendario.get(Calendar.YEAR);
        final int mes = calendario.get(Calendar.MONTH);
        final int dia = calendario.get(Calendar.DAY_OF_MONTH);

        etNacimiento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int año, int mes, int dia) {
                        mes = mes + 1;
                        String fecha = dia+"/"+mes+"/"+año;
                        etNacimiento.setText(fecha);
                    }
                },año,mes,dia);
                datePickerDialog.show();
            }
        });

        etDescripcion = findViewById(R.id.etDescripcion);
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);

        //acá empieza el ejemplo del video
        contactos= new  ArrayList<contacto>();

        contactos.add(new contacto( "j", "222555888", "pedro@gmail.com", "15/9/2010", "Lo conocí en el parque"));


        boton = (Button) findViewById(R.id.btnSiguiente);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Nacimiento =  etNacimiento.getText().toString();
                String Descripcion =  etDescripcion.getText().toString();
                String Nombre =  etNombre.getText().toString();
                String Telefono =  etTelefono.getText().toString();
                String Email =  etEmail.getText().toString();


                //lanzarActivity(v, texto.getText().toString());
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);

                intent.putExtra(getResources().getString(R.string.pnombre), Nombre);
                intent.putExtra(getResources().getString(R.string.ptelefono), Telefono);
                intent.putExtra(getResources().getString(R.string.pemail), Email);
                intent.putExtra(getResources().getString(R.string.pnacimiento), Nacimiento);
                intent.putExtra(getResources().getString(R.string.pdescripcion), Descripcion);

                startActivity(intent);
            }
        });



        }

        /*contactos.add(new contacto("Pedro Campo","32114357622","Pcampo@hotmail.com"));
        contactos.add(new contacto("José Pérez","3004461325","Jperez@hotmail.com"));
        contactos.add(new contacto("Julian Sosa","350233195","Sosa5252@gmail.com"));
        contactos.add(new contacto("Oscar Ruiz","3017753166","Oscar4Ruiz@gmail.com"));
        contactos.add(new contacto("Edward Jurado","302645885","Juradoedward@outlook.com"));


        ArrayList<String> nombresContactos = new ArrayList<>();
        for (contacto contacto:contactos) {
            nombresContactos.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresContactos));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());
                startActivity(intent);
                //finish();
            }
        });
        */
    }
