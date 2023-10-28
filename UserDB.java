public class UserDB {
    private DBHelper dbHelper;

    public UserDB(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertUsuario(Usuario usuario) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Nombre", usuario.getNombre());
        values.put("Apellido", usuario.getApellido());
        values.put("CorreoElectronico", usuario.getCorreoElectronico());
        values.put("Contrasena", usuario.getContrasena());

        db.insert("Usuarios", null, values);
        db.close();
    }

    public Usuario getUsuarioPorCorreo(String correoElectronico) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columns = {"UserID", "Nombre", "Apellido", "Contrasena"};
        String selection = "CorreoElectronico = ?";
        String[] selectionArgs = {correoElectronico};

        Cursor cursor = db.query("Usuarios", columns, selection, selectionArgs, null, null, null);
        Usuario usuario = null;

        if (cursor.moveToFirst()) {
            usuario = new Usuario();
            usuario.setUserID(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setApellido(cursor.getString(2));
            usuario.setContrasena(cursor.getString(3));
        }

        cursor.close();
        db.close();
        return usuario;
    }
}
