package br.com.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDatabase extends SQLiteOpenHelper {

    private static  final String NAME_DATABASE = "database.db";
    private static final String TABLE = "livros";
    private static final String ID = "_id";
    private static final String TITLE = "titulo";
    private static final String AUTHOR = "autor";
    private static final String PUBLISHING = "editora";
    private static final int VERSION = 1;


    public CreateDatabase(Context context) {
        super(context, name, factory, version);
    }

    public static String getTABLE() {
        return TABLE;
    }

    public static String getID() {
        return ID;
    }

    public static String getTITLE() {
        return TITLE;
    }

    public static String getAUTHOR() {
        return AUTHOR;
    }

    public static String getPUBLISHING() {
        return PUBLISHING;
    }

    public static int getVERSION() {
        return VERSION;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE" + TABLE + "("
                + ID + " integer primary key autoincrement,"
                + TITLE + "text"
                + AUTHOR + "text"
                + PUBLISHING + "TEXT"
                +")";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE);
        onCreate(sqLiteDatabase);
    }
}
