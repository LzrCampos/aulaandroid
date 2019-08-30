package br.com.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseController {
    private SQLiteDatabase db;
    private CreateDatabase database;

    public DatabaseController(Context context){
        database = new CreateDatabase(context);
    }
    public String insereDado(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;
        db = database.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CreateDatabase.getTITLE(), titulo);
        valores.put(CreateDatabase.getAUTHOR(), autor);
        valores.put(CreateDatabase.getPUBLISHING(), editora);
        resultado = db.insert(CreateDatabase.getTABLE(), null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }
    public Cursor carregaDados(){
        Cursor cursor;
        String[] fields = {CreateDatabase.getID(),CreateDatabase.getTITLE()};
        db = database.getReadableDatabase();
        cursor = db.query(CreateDatabase.getTABLE(), fields, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
