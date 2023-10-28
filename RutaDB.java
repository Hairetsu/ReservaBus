public class RutaDB {
    private DBHelper dbHelper;

    public RutaDB(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertRuta(Ruta ruta) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Origen", ruta.getOrigen());
        values.put("Destino", ruta.getDestino());
        values.put("Distancia", ruta.getDistancia());
        values.put("PrecioBoleto", ruta.getPrecioBoleto());

        db.insert("Rutas", null, values);
        db.close();
    }

    // Implementa otras operaciones según tus necesidades (actualizar, eliminar, consultar).
}
