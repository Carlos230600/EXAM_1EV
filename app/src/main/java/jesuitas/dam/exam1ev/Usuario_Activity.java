package jesuitas.dam.exam1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.nio.file.Files;

public class Usuario_Activity extends AppCompatActivity {

    private TextView nombre;
    private TextView correo;
    private TextView telf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_);
        nombre=(TextView) findViewById(R.id.editTextTextPersonName);
        correo=(TextView) findViewById(R.id.editTextTextEmailAddress);
        telf=(TextView) findViewById(R.id.editTextNumber);
    }



    public void muestraMain(View view) {
        Activitymain();
    }

    //Actividad 2 y paso de datos a ella
    public void Activitymain(){
        Intent intent=new Intent(this, MainActivity.class);
        intent.putExtra("Nombre", nombre.toString());
        intent.putExtra("Email", correo.toString());
        intent.putExtra("telf",telf.toString());
        startActivity(intent);
    }

    // Metodo para regresar los datos a la actividad anterior
    public void enviar(View view) {

        if(nombre==null){
            Toast.makeText(this,"Fill All Data",Toast.LENGTH_SHORT).show();
        }
        else if(correo==null){
            Toast.makeText(this,"Fill All Data",Toast.LENGTH_SHORT).show();
        }

        else if(telf==null){
            Toast.makeText(this,"Fill All Data",Toast.LENGTH_SHORT).show();
        }else {
            //Creo el intent devuelto
                Activitymain();
        }
    }
}