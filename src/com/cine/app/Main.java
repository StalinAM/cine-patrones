package com.cine.app;

import java.sql.SQLException;
import java.util.List;

import org.hamcrest.Factory;

import com.cine.bean.Cliente;
import com.cine.bean.Empleado;
import com.cine.bean.Persona;
import com.cine.conexionBaseDatos.BaseDatosConexion;
import com.cine.intancias.FactoryImpl;
import com.cine.intancias.PersonaBuilder;
import com.cine.intancias.TipoPersona;
import com.cine.servicios.ServiciosEmpleado;
import com.cine.servicios.ServiciosEmpleadoImpl;

public class Main {
	public static void main(String[] args) throws SQLException {
//		FactoryImpl fact = new FactoryImpl();
//
//		Persona nuevoCliente = fact.crearPersona(TipoPersona.CLIENTE,
//				new Cliente.Builder().nombrePer("Juan Perez").cedulaPer("123456789").correo("juan.perez@example.com")
//						.telefonoCli("1234567890").direccionCli("Calle Falsa 123"));
//		System.out.println(nuevoCliente);
//		Persona nuevoEmpleado = fact.crearPersona(TipoPersona.EMPLEADO,
//				new Empleado.Builder().nombrePer("Juan Perez").cedulaPer("1234567890").correo("juan.perez@example.com")
//						.cargoEmpl("Gerente").cuentaBancariaEmpl("0123456789").usuarioEmpl("jperez")
//						.contraseniaEmpl("password123"));
//		System.out.println(nuevoEmpleado);
		BaseDatosConexion dbConfig = BaseDatosConexion.getInstance();

		// Implementación del servicio
		ServiciosEmpleadoImpl servicioCliente = new ServiciosEmpleadoImpl();
		servicioCliente.setDbConfig(dbConfig);
		System.out.println(servicioCliente.listarTodos());

//    	 try {
//             // Configuración de la base de datos

//
//             // Crear un nuevo cliente
//             Cliente nuevoCliente = new Cliente.Builder()
//                     .nombrePer("Juan Perez")
//                     .cedulaPer("123456789")
//                     .correo("juan.perez@example.com")
//                     .telefono("1234567890")
//                     .direccionCli("Calle Falsa 123")
//                     .build();
//
//             servicioCliente.crear(nuevoCliente);
//             System.out.println("Cliente creado: " + nuevoCliente);
//
//             // Buscar cliente por ID
//             Cliente clienteEncontrado = servicioCliente.buscarPorId(1);
//             System.out.println("Cliente encontrado: " + clienteEncontrado);
//
// 			// Listar todos los clientes
// 			List<Cliente> clientes = servicioCliente.listarTodos();
// 			System.out.println("Lista de todos los clientes:");
// 			for (Cliente cliente : clientes) {
// 				System.out.println(cliente);
// 			}
//
// 			// Actualizar cliente
// 			clienteEncontrado.setDireccionCli("Nueva Dirección 456");
// 			servicioCliente.actualizar(clienteEncontrado);
// 			System.out.println("Cliente actualizado: " + clienteEncontrado);
//
// 			// Eliminar cliente por ID
// 			servicioCliente.eliminarPorId(clienteEncontrado.getIdCliente());
// 			System.out.println("Cliente eliminado con ID: " + clienteEncontrado.getIdCliente());
//
// 			// Verificar que el cliente ha sido eliminado
// 			Cliente clienteEliminado = servicioCliente.buscarPorId(clienteEncontrado.getIdCliente());
// 			if (clienteEliminado == null) {
// 				System.out.println("El cliente ha sido eliminado correctamente.");
// 			} else {
// 				System.out.println("Error: el cliente aún existe.");
// 			}
// 			
//         } catch (SQLException ex) {
//             System.err.println("Error al conectar con la base de datos: " + ex.getMessage());
//         } catch (Exception ex) {
//             System.err.println("Ocurrió un error: " + ex.getMessage());
//         }

//        try {
//            // Configuración de la base de datos
//            BaseDatosConexion dbConfig = BaseDatosConexion.getInstance();
//
//            // Implementación del servicio
//            ServiciosEmpleado servicioEmpleado = new ServiciosEmpleadoImpl();
//            servicioEmpleado.setDbConfig(dbConfig);
////
////            // Crear un nuevo empleado
////            Empleado nuevoEmpleado = new Empleado.Builder()
////                    .nombrePer("Juan Perez")
////                    .cedulaPer("1234567890")
////                    .correo("juan.perez@example.com")
////                    .telefono("123456789")
////                    .cargoEmpl("Gerente")
////                    .cuentaBancariaEmpl("0123456789")
////                    .usuarioEmpl("jperez")
////                    .contraseniaEmpl("password123")
////                    .build();
////            servicioEmpleado.crear(nuevoEmpleado);
////            System.out.println("Empleado creado: " + nuevoEmpleado);
////
////            // Buscar empleado por ID
////            Empleado empleadoEncontrado = servicioEmpleado.buscarPorId(nuevoEmpleado.getIdEmpleado());
////            if (empleadoEncontrado != null) {
////                System.out.println("Empleado encontrado: " + empleadoEncontrado);
////
////                // Actualizar el cargo del empleado encontrado
////                empleadoEncontrado.setCargoEmpl("Director");
////                servicioEmpleado.actualizar(empleadoEncontrado);
////                System.out.println("Empleado actualizado: " + empleadoEncontrado);
////
////                // Eliminar empleado por ID
////                servicioEmpleado.eliminarPorId(empleadoEncontrado.getIdEmpleado());
////                System.out.println("Empleado eliminado con ID: " + empleadoEncontrado.getIdEmpleado());
////
////                // Verificar que el empleado ha sido eliminado
////                Empleado empleadoEliminado = servicioEmpleado.buscarPorId(empleadoEncontrado.getIdEmpleado());
////                if (empleadoEliminado == null) {
////                    System.out.println("El empleado ha sido eliminado correctamente.");
////                } else {
////                    System.out.println("Error: el empleado aún existe.");
////                }
////            } else {
////                System.out.println("Error: empleado no encontrado después de la creación.");
////            }
//
//            // Listar todos los empleados
//            List<Empleado> empleados = servicioEmpleado.listarTodos();
//            System.out.println("Lista de empleados:");
//            for (Empleado empleado : empleados) {
//                System.out.println(empleado);
//            }
//            
//        } catch (SQLException ex) {
//            System.err.println("Error al conectar con la base de datos: " + ex.getMessage());
//        } catch (Exception ex) {
//            System.err.println("Ocurrió un error: " + ex.getMessage());
//        }
	}
}
