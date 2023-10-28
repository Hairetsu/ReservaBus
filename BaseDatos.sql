-- Tabla de Usuarios
CREATE TABLE Usuarios (
    UserID INT PRIMARY KEY,
    Nombre NVARCHAR(50),
    Apellido NVARCHAR(50),
    CorreoElectronico NVARCHAR(100),
    Contrasena NVARCHAR(50),
    Telefono NVARCHAR(20),
    Direccion NVARCHAR(100)
);

-- Tabla de Buses
CREATE TABLE Buses (
    BusID INT PRIMARY KEY,
    NumeroPlaca NVARCHAR(20),
    Modelo NVARCHAR(50),
    CapacidadPasajeros INT,
    Asientos INT 
);

-- Tabla de Rutas
CREATE TABLE Rutas (
    RutaID INT PRIMARY KEY,
    Origen NVARCHAR(100),
    Destino NVARCHAR(100),
    Distancia DECIMAL(10, 2),
    DuracionEstimada INT, -- Duración en minutos
    PrecioBase DECIMAL(10, 2)
);

-- Tabla de Reservas
CREATE TABLE Reservas (
    ReservaID INT PRIMARY KEY,
    UserID INT, -- Clave foránea para el usuario
    RutaID INT, -- Clave foránea para la ruta
    BusID INT, -- Clave foránea para el bus
    FechaReserva DATETIME,
    FechaViaje DATETIME,
    EstadoReserva NVARCHAR(20), -- Confirmada, Pendiente, Cancelada, etc.
    CantidadPasajeros INT,
    PrecioTotal DECIMAL(10, 2),
    AsientoReservado INT, -- Número de asiento reservado
    FOREIGN KEY (UserID) REFERENCES Usuarios(UserID),
    FOREIGN KEY (RutaID) REFERENCES Rutas(RutaID),
    FOREIGN KEY (BusID) REFERENCES Buses(BusID)
);

-- Tabla de Horarios
CREATE TABLE Horarios (
    HorarioID INT PRIMARY KEY,
    RutaID INT, -- Clave foránea para la ruta
    HoraSalida TIME,
    HoraLlegada TIME
);

-- Relación entre Horarios y Rutas
ALTER TABLE Horarios
ADD FOREIGN KEY (RutaID) REFERENCES Rutas(RutaID);

-- Tabla de Historial de Reservas
CREATE TABLE HistorialReservas (
    HistorialID INT PRIMARY KEY,
    ReservaID INT, -- Clave foránea para la reserva
    EstadoAnterior NVARCHAR(20),
    NuevoEstado NVARCHAR(20),
    FechaCambioEstado DATETIME
);

-- Relación entre Reservas e Historial de Reservas
ALTER TABLE HistorialReservas
ADD FOREIGN KEY (ReservaID) REFERENCES Reservas(ReservaID);

-- Tabla de Pagos
CREATE TABLE Pagos (
    PagoID INT PRIMARY KEY,
    ReservaID INT, -- Clave foránea para la reserva
    MontoPagado DECIMAL(10, 2),
    MetodoPago NVARCHAR(50),
    FechaPago DATETIME
);

-- Relación entre Reservas y Pagos
ALTER TABLE Pagos
ADD FOREIGN KEY (ReservaID) REFERENCES Reservas(ReservaID);