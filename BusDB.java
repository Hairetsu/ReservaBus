public class BusDB {
    private DBHelper dbHelper;

    public BusDB(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertBus(Bus bus) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("NumeroPlaca", bus.getNumeroPlaca());
        values.put("Modelo", bus.getModelo());
        values.put("CapacidadPasajeros", bus.getCapacidadPasajeros());
        values.put("EmpresaAutobuses", bus.getEmpresaAutobuses());
        values.put("Asientos", bus.getAsientos());

        db.insert("Buses", null, values);
        db.close();
    }

    // Implementa otras operaciones según tus necesidades (actualizar, eliminar, consultar).
}
