import java.io.*;

public class ListaLibros 
{
    private BufferedReader lector;
    private int pLibre;
    private int talla;
    private Libro_v2 listaLibros[];

    public ListaLibros()
    {
        lector = new BufferedReader(new InputStreamReader(System.in));
        this.pLibre = 0;
        this.talla = 0;
    }


    public void ejecutar() {
        try {
            inicializarBiblioteca();
            int opcion = 0;

            while (opcion != 6) {
                mostrarMenu();
                opcion = Integer.parseInt(lector.readLine());

                switch (opcion) {
                    case 1:
                        agregarLibro();
                        break;
                    case 2:
                        buscarLibro();
                        break;
                    case 3:
                        eliminarLibro();
                        break;
                    case 4:
                        registrarPrestamo();
                        break;
                    case 5:
                        mostrarLibrosDisponibles();
                        break;
                    case 6:
                        System.out.println("Adiós, que tenga un buen día");
                        break;
                    default:
                        System.out.println("Opción no válida, por favor seleccione otra opción.");
                }
            }
        }
        //¿QUE es esto?
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void inicializarBiblioteca() throws IOException
    {
        do 
        {
            System.out.print("Ingrese la cantidad de espacio disponible para libros: ");
            talla = Integer.parseInt(lector.readLine());
        } while (talla <= 0);

        listaLibros = new Libro_v2[talla];
    }


    private void mostrarMenu()
    {
        System.out.println("\nSeleccione qué acción quiere realizar:\n");
        System.out.println("1- Agregar libro");
        System.out.println("2- Buscar libro");
        System.out.println("3- Eliminar libro");
        System.out.println("4- Registrar libro como prestado");
        System.out.println("5- Mostrar todos los libros disponibles");
        System.out.println("6- Salir");
        System.out.println("=====================================\n");
        System.out.print("Ingrese su opción: ");
    }


    private void agregarLibro() throws IOException
    {
        if (pLibre < talla)
        {
            System.out.print("Ingrese código de libro: ");
            String codigo = lector.readLine();

            System.out.print("Ingrese título de libro: ");
            String titulo = lector.readLine();

            System.out.print("Ingrese autor de libro: ");
            String autor = lector.readLine();

            listaLibros[pLibre] = new Libro_v2(codigo, titulo, autor, 0);
            pLibre++;

            System.out.println("Se ha agregado su libro con exito.");
        }
        else
        {
            System.out.println("Ha superado el límite disponible para guardar libros.");
        }
    }


    private void buscarLibro() throws IOException
    {
        System.out.print("Ingrese título del libro a buscar: ");
        String titulo = lector.readLine();
        int flag = 0;

        for (int i = 0; i < pLibre; i++)
        {
            if (listaLibros[i].getTitulo().equals(titulo)) 
            {
                System.out.println("\nDatos del libro buscado:\n");
                System.out.println("Título: " + listaLibros[i].getTitulo());
                System.out.println("Autor: " + listaLibros[i].getAutor());
                System.out.println("Cantidad de veces prestado: " + listaLibros[i].getPrestamos());
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            System.out.println("\nNo se ha logrado encontrar el libro.");
        }
    }


    private void eliminarLibro() throws IOException
    {
        System.out.print("Ingrese título del libro a eliminar: ");
        String titulo = lector.readLine();
        int flag = 0;
        for (int i = 0; i < pLibre; i++)
        {
            if (listaLibros[i].getTitulo().equals(titulo))
            {
                for (int j = i; j < pLibre - 1; j++)
                {
                    listaLibros[j] = listaLibros[j + 1];
                }
                listaLibros[pLibre - 1] = null;
                pLibre--;
                flag = 1;
                System.out.println("Se ha eliminado el libro con éxito.");
                break;
            }
        }

        if (flag == 0) {
            System.out.println("No se ha podido eliminar el libro.");
        }
    }


    private void registrarPrestamo() throws IOException
    {
        System.out.print("Ingrese título del libro a prestar: ");
        String titulo = lector.readLine();
        int flag = 0;

        for (int i = 0; i < pLibre; i++)
        {
            if (listaLibros[i].getTitulo().equals(titulo))
            {
                listaLibros[i].sumarPrestamo(1);
                flag = 1;
                System.out.println("El libro " + listaLibros[i].getTitulo() + " se ha prestado con éxito un total de " + listaLibros[i].getPrestamos() + " veces.");
                break;
            }
        }

        if (flag == 0) {
            System.out.println("El libro no se encuentra disponible para prestar.");
        }
    }

    private void mostrarLibrosDisponibles()
    {
        if (pLibre != 0) 
        {
            System.out.println("Libros disponibles:\n");
            for (int i = 0; i < pLibre; i++)
            {
                System.out.println("Libro " + (i + 1) + ": " + listaLibros[i].getTitulo());
            }
        }
        else
        {
            System.out.println("No hay libros disponibles.");
        }
    }
}