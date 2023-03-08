package Datos;

public class comboBox {
    private String codigo;
    private int id;

    public comboBox(int id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return codigo;
    }
}
