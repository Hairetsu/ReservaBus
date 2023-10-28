public class ReservaDB {
    private DBHelper dbHelper;

    public ReservaDB(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertReserva(Reserva reserva) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("UserID", reserva.getUserID());
        values.put("RutaID", reserva.getRutaID());
        values.put("BusID", reserva.getBusID());
        values.put("FechaReserva", reserva.getFechaReserva().toString());
        values.put("FechaViaje", reserva.getFechaViaje().toString());
        values.put("EstadoReserva", reserva.getEstadoReserva());
        values.put("CantidadPasajeros", reserva.getCantidadPasajeros());
        values.put("PrecioTotal", reserva.getPrecioTotal());
        values.put("AsientoReservado", reserva.getAsientoReservado());

        db.insert("Reservas", null, values);
        db.close();
    }

    // Implementa otras operaciones según tus necesidades (actualizar, eliminar, consultar).
}
