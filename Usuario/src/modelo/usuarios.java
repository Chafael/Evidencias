package modelo;

/**
 * Representa la tabla USUARIO de la BD.
 */
public class usuarios {

    // ─── Campos ──────────────────────────────────────────
    private int    id_usuario;        // AUTOINCREMENT
    private String nombre;            // VARCHAR(100)
    private String apellidos;         // VARCHAR(100)
    private String fecha_nacimiento;  // YYYY‑MM‑DD
    private String email;             // VARCHAR(150) UNIQUE
    private String contrasena;        // HASH SHA‑256
    private String sexo;              // VARCHAR(10)
    private String fecha_creacion;    // TIMESTAMP (lo asigna MySQL)

    // ─── Constructores ──────────────────────────────────
    public usuarios() {}

    public usuarios(String nombre, String apellidos, String fecha_nacimiento,
                   String email, String contrasena, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.contrasena = contrasena;
        this.sexo = sexo;
    }

    public usuarios(int id_usuario, String nombre, String apellidos, String fecha_nacimiento,
                   String email, String contrasena, String sexo, String fecha_creacion) {
        this(nombre, apellidos, fecha_nacimiento, email, contrasena, sexo);
        this.id_usuario     = id_usuario;
        this.fecha_creacion = fecha_creacion;
    }

    // ─── Getters y Setters ──────────────────────────────
    public int getId_usuario()               { return id_usuario; }
    public void setId_usuario(int id_usuario){ this.id_usuario = id_usuario; }

    public String getNombre()                { return nombre; }
    public void setNombre(String nombre)     { this.nombre = nombre; }

    public String getApellidos()             { return apellidos; }
    public void setApellidos(String apellidos){ this.apellidos = apellidos; }

    public String getFecha_nacimiento()      { return fecha_nacimiento; }
    public void setFecha_nacimiento(String f){ this.fecha_nacimiento = f; }

    public String getEmail()                 { return email; }
    public void setEmail(String email)       { this.email = email; }

    public String getContrasena()            { return contrasena; }
    public void setContrasena(String c)      { this.contrasena = c; }

    public String getSexo()                  { return sexo; }
    public void setSexo(String sexo)         { this.sexo = sexo; }

    public String getFecha_creacion()        { return fecha_creacion; }
    public void setFecha_creacion(String fc) { this.fecha_creacion = fc; }

    // ─── toString ───────────────────────────────────────
    @Override
    public String toString() {
        return "Usuario{" +
               "id_usuario=" + id_usuario +
               ", nombre='"   + nombre + '\'' +
               ", apellidos='"+ apellidos + '\'' +
               ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
               ", email='"     + email + '\'' +
               ", sexo='"      + sexo + '\'' +
               ", fecha_creacion='" + fecha_creacion + '\'' +
               '}';
    }
}