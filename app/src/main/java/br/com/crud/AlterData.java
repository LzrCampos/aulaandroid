package br.com.crud;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterData extends AppCompatActivity {
    EditText livro;
    EditText autor;
    EditText editora;
    Button alterar;
    Button deletar;
    Cursor cursor;
    DatabaseController crud;
    String codigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_data);
        codigo = this.getIntent().getStringExtra("codigo");
        crud = new DatabaseController(getBaseContext());
        livro = (EditText)findViewById(R.id.editText4);
        autor = (EditText)findViewById(R.id.editText5);
        editora = (EditText)findViewById(R.id.editText6);
        alterar = (Button)findViewById(R.id.button2);
        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CreateDatabase.getTITLE())));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CreateDatabase.getAUTHOR())));

        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(CreateDatabase.getPUBLISHING())));
    }
}
