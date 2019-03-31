package Objetos;

public class Empleado {
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String contraseña;
    private int idRol;
    private int idDepartamento; 
    
    public Empleado(int id,String nombre){
        this.id = id;
        this.nombre= nombre;
    }
     @Override
    public String toString() {
        return this.nombre;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
     @Override
    public boolean equals(Object other) {
        return this.id == ((Empleado) other).getId();
    }

}
