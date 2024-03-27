public class Libro_v2
{
    private String codigo;
    private String titulo;
    private String autor;
    private int prestamos;

    public Libro_v2(String codigo, String titulo, String autor, int prestamos)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.prestamos = prestamos;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    public int getPrestamos()
    {
        return prestamos;
    }

    public void setPrestamos(int prestamos)
    {
        this.prestamos = prestamos;
    }

    public int sumarPrestamo (int num)
    {
        prestamos += num;
        return prestamos; 
    }
}