package Objetos;

public class Departamento {
    private int id;
    private String Codigo;
    private String nombre;
    private String Descripcion;

    public Departamento(int id,String Nombre){
        this.id = id;
        this.nombre =Nombre;
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

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public boolean equals(Object other) {
        return this.id == ((Departamento) other).id;
    }
}
