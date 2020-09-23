package com.caselles.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.MailTo;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.ACTION_CALL;

public class DetalleContacto extends AppCompatActivity {
    private Button boton;

    /*
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvNacimiento;
    private TextView tvDescripcion;

     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_contacto);


        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String nacimiento = parametros.getString(getResources().getString(R.string.pnacimiento));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvNacimiento = (TextView) findViewById(R.id.tvNacimiento);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvNacimiento.setText(nacimiento);
        tvDescripcion.setText(descripcion);

        boton = (Button) findViewById(R.id.btnEditar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //lo comentado es del ejemplo del video

                //lanzarActivity(v, texto.getText().toString());

                /*
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra("nombre", etNombre.getText().toString());
                intent.putExtra("telefono", etTelefono.getText().toString());
                intent.putExtra("email", etEmail.getText().toString());
                intent.putExtra("nacimiento", etNacimiento.getText().toString());
                intent.putExtra("descripcion", etDescripcion.getText().toString());

                 */
                finish();
            }
        });

    }

    /*public void llamar(View v){
        String telefono = tvtelefono.getText().toString();
        //if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager){

        //}
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }
    public void enviarmail(View v){
        String email = tvEmail.getText().toString();
        Intent EmailIntent = new Intent(Intent.ACTION_SEND);
        EmailIntent.setData(Uri.parse("MailTo:"));
        EmailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        EmailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(EmailIntent, "Email"));
    }


    @Override
    public boolean onKeyDown (int KeyCode, KeyEvent event){
        if(KeyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(KeyCode, event);
    }

     */

}