package app;

import modelo.Cliente;
import modelo.Direccion;
import modelo.Pedido;
import servicio.ClienteService;
import servicio.DireccionService;
import servicio.PedidoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
    	

        ClienteService clienteService = new ClienteService();
        DireccionService direccionService = new DireccionService();
        PedidoService pedidoService = new PedidoService();
        
        
//        System.out.println(clienteService.obtenerCliente(1L));
//        clienteService.obtenerTodosLosClientes();
//        clienteService.getClienteYDireccion(1L);
        clienteService.getClientesEmpiezanPor("d%");
    }
}
