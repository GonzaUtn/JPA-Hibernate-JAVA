package org.example;



import org.example.Entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("SISTEMA FACTURACION");

        try {

            // Persistir una nueva entidad
            entityManager.getTransaction().begin();
/*
        Factura factura1= Factura.builder().numero(0001).fecha("06/08/24").build();
        Factura factura2= Factura.builder().numero(0025).fecha("25/09/24").build();



            Domicilio domicilio1= Domicilio.builder().nombreCalle("Adolfo Calle").numero(7653).build();
            Domicilio domicilio2= Domicilio.builder().nombreCalle("Juan B. Justo").numero(5600).build();



            Cliente cliente1 = Cliente.builder()
                    .nombre("Gonzalo")
                    .apellido("Moyano")
                    .dni(42422123)
                    .build();

            Cliente cliente2 = Cliente.builder()
                    .nombre("Bianca")
                    .apellido("Poblete")
                    .dni(43556987)
                    .build();


            domicilio1.setCliente(cliente1);
            cliente1.setDomicilio(domicilio1);

            domicilio2.setCliente(cliente2);
            cliente2.setDomicilio(domicilio2);


            factura1.setCliente(cliente1);
            factura2.setCliente(cliente2);

            //Creamos categorias
            Categoria categoria1 = Categoria.builder().denominacion("Remeras").build();
            Categoria categoria2 = Categoria.builder().denominacion("Pantalones").build();
            Categoria categoria3 = Categoria.builder().denominacion("Camperas").build();

            //Creamos articulos y añadimos el articulos en la categoria para poder tener la bidireccionalidad
            Articulo art1 = Articulo.builder().cantidad(20).denominacion("Remera Corta negra Basic").precio(100).categoria(Arrays.asList(categoria1)).build();
            Articulo art2 = Articulo.builder().cantidad(20).denominacion("Remera larga Basic").precio(100).categoria(Arrays.asList(categoria1)).build();
            Articulo art3 = Articulo.builder().cantidad(10).denominacion("Pantalon chino negro Basic").precio(180).categoria(Arrays.asList(categoria2)).build();
            Articulo art4 = Articulo.builder().cantidad(25).denominacion("Pantalon Jean Oversiza").precio(200).categoria(Arrays.asList(categoria2)).build();
            Articulo art5 = Articulo.builder().cantidad(10).denominacion("Camperon Gris").precio(300).categoria(Arrays.asList(categoria3)).build();
            Articulo art6 = Articulo.builder().cantidad(10).denominacion("Campera polar basic").precio(150).categoria(Arrays.asList(categoria3)).build();
            Articulo art7 = Articulo.builder().cantidad(30).denominacion("Remera Corta c/Estampado").precio(120).categoria(Arrays.asList(categoria1)).build();
            Articulo art8 = Articulo.builder().cantidad(10).denominacion("Campera deportiva ").precio(250).categoria(Arrays.asList(categoria3)).build();


            // Definimos los detalles factura
            DetalleFactura detalle1 = DetalleFactura.builder().articulo(art1).cantidad(5).factura(factura1).build();
            detalle1.setSubtotal(detalle1.getCantidad()*art1.getPrecio());
            art1.getDetalle().add(detalle1);

            DetalleFactura detalle2 = DetalleFactura.builder().articulo(art5).cantidad(3).factura(factura1).build();
            detalle2.setSubtotal(detalle1.getCantidad()*art5.getPrecio());
            art5.getDetalle().add(detalle2);

            DetalleFactura detalle3 = DetalleFactura.builder().articulo(art6).cantidad(5).factura(factura1).build();
            detalle3.setSubtotal(detalle1.getCantidad()*art6.getPrecio());
            art6.getDetalle().add(detalle3);

            factura1.getDetalle().add(detalle1);
            factura1.getDetalle().add(detalle2);
            factura1.getDetalle().add(detalle3);

            factura1.setTotal(detalle1.getSubtotal()+detalle2.getSubtotal()+detalle3.getSubtotal());


            //-------------------------

            DetalleFactura detalle4 = DetalleFactura.builder().articulo(art2).cantidad(4).factura(factura2).build();
            detalle4.setSubtotal(detalle4.getCantidad()*art2.getPrecio());
            art2.getDetalle().add(detalle4);

            DetalleFactura detalle5 = DetalleFactura.builder().articulo(art3).cantidad(9).factura(factura2).build();
            detalle5.setSubtotal(detalle5.getCantidad()*art3.getPrecio());
            art3.getDetalle().add(detalle5);

            DetalleFactura detalle6 = DetalleFactura.builder().articulo(art7).cantidad(5).factura(factura2).build();
            detalle6.setSubtotal(detalle6.getCantidad()*art7.getPrecio());
            art7.getDetalle().add(detalle6);


            factura2.getDetalle().add(detalle4);
            factura2.getDetalle().add(detalle5);
            factura2.getDetalle().add(detalle6);

            factura2.setTotal(detalle4.getSubtotal()+detalle5.getSubtotal()+detalle6.getSubtotal());


            entityManager.persist(art1);
            entityManager.persist(art2);
            entityManager.persist(art3);
            entityManager.persist(art4);
            entityManager.persist(art5);
            entityManager.persist(art6);
            entityManager.persist(art7);
            entityManager.persist(art8);

            entityManager.persist(factura1);
            entityManager.persist(factura2);


*/

            //Cambiamos el numero de la factura
            Factura factura1 = entityManager.find(Factura.class, 1L);
            factura1.setNumero(123);
            entityManager.merge(factura1);

            //Removemos articulo
            Factura factura2= entityManager.find(Factura.class, 2L);
            entityManager.remove(factura2);

            entityManager.flush();
            entityManager.getTransaction().commit();


            // Consultar y mostrar la entidad persistida


        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Persona");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
