package jesuitas.dam.exam1ev;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Añadir barra de herramientas
        //Toolbar toolbar=(Toolbar) findViewById((R.id.toolbar));
        //setSupportActionBar(toolbar);


        //Recibo los datos de la Activity 2
        Intent intent=getIntent();
        String nombre=intent.getStringExtra("Nombre");
        Integer telefono= intent.getIntExtra("telf",0);
        String correo=intent.getStringExtra("Email");
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    /*public boolean onOptionsItemSelected(@NonNull MenuItem item){
        boolean a=false;
        switch(item.getItemId()){
            case R.id.action_perfil:
                break;
                rellenadatos();
                return true;
            case R.id.action_correo:
                EnviarMensaje();
                return true;
                break;
            case R.id.telefono:
                phoneDial();
                return true;
                break;
        }

    }*/

    //Inicia la Activity rellenardatos
    public void rellenadatos(){
        Intent intent=new Intent(this, Usuario_Activity.class);
        startActivity(intent);
    }

    // Activity enviar mensaje
    public void EnviarMensaje(){
        Intent intent=getIntent();
        String correo=intent.getStringExtra("Email");
        String[]addresses={correo};
        String message = "This is the body";
        String subject="This is the message";

        Intent sendIntent=new Intent();

        sendIntent.setAction(Intent.ACTION_SENDTO);
        sendIntent.setData(Uri.parse("mailto:"));
        sendIntent.putExtra(Intent.EXTRA_TEXT,message);
        sendIntent.putExtra(Intent.EXTRA_EMAIL,addresses);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT,subject);

        if(sendIntent.resolveActivity(getPackageManager())!=null){
            startActivity(sendIntent);
        }else{
            Toast.makeText(this,"There is no email client installed.",Toast.LENGTH_SHORT).show();
        }

    }

    // Activity llamada telefonica
    public void phoneDial(){
        Intent intent=new Intent(Intent.ACTION_DIAL);
        Intent intent2=getIntent();
        Integer telefono= intent.getIntExtra("telf",0);
        intent.setData(Uri.parse("tel:" + telefono));
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}