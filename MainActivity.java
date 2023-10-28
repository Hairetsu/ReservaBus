public class MainActivity extends AppCompatActivity {

    private UserDB userDB;
    private BusDB busDB;
    private RutaDB rutaDB;
    private ReservaDB reservaDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa las bases de datos
        userDB = new UserDB(this);
        busDB = new BusDB(this);
        rutaDB = new RutaDB(this);
        reservaDB = new ReservaDB(this);

        // Abre las bases de datos
        try {
            userDB.open();
            busDB.open();
            rutaDB.open();
            reservaDB.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Realiza operaciones, por ejemplo:
        // Insertar un usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Ejemplo");
        usuario.setApellido("Usuario");
        usuario.setCorreoElectronico("ejemplo@example.com");
        usuario.setContrasena("contrasena");
        userDB.insertUsuario(usuario);

        // Obtener información, por ejemplo:
        // Obtener todas las rutas disponibles
        List<Ruta> rutasDisponibles = rutaDB.getRutasDisponibles();

        // Cierra las bases de datos cuando hayas terminado
        userDB.close();
        busDB.close();
        rutaDB.close();
        reservaDB.close();
    }

    // Implementa métodos para manejar la interacción del usuario y la navegación a otras actividades.
}
