package Objetos;

public class Rol {
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    private int id;
    private String Rol;
    private String Descripcion;
    
    public Rol(int id,String Rol){
        this.id = id;
        this.Rol = Rol;
    }
    @Override
    public String toString(){
        return this.getRol();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getDescripcion() {
        return Descripcion;
    }
     @Override
    public boolean equals(Object other) {
        return this.id == ((Rol) other).getId();
    }

}
