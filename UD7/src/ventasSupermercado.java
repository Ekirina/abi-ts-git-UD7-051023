import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ventasSupermercado {

	public static void main(String[] args) {
			
		double producto1 = 4.95;
		double producto2 = 2.50;
		double producto3 = 3.75;
		double producto4 = 1.50;
		double producto5 = 9.25;
		
		System.out.println("El precio del producto1 es de: "+producto1);
		System.out.println("El precio del producto2 es de: "+producto2);
		System.out.println("El precio del producto3 es de: "+producto3);
		System.out.println("El precio del producto4 es de: "+producto4);
		System.out.println("El precio del producto5 es de: "+producto5);

		
		double producto1iva= producto1*0.21;
		double producto2iva= producto2*0.04;
		double producto3iva= producto3*0.21;
		double producto4iva= producto1*0.04;
		double producto5iva= producto1*0.21;
		
		System.out.println("El IVA aplicado (21%) en el producto 1 es: "+(String.format("%.2f", producto1iva)));
		System.out.println("El IVA aplicado (4%) en el producto 2 es: "+(String.format("%.2f", producto2iva)));
		System.out.println("El IVA aplicado (21%) en el producto 3 es: "+(String.format("%.2f", producto3iva)));
		System.out.println("El IVA aplicado (4%) en el producto 4 es: "+(String.format("%.2f", producto4iva)));
		System.out.println("El IVA aplicado (21%) en el producto 5 es: "+(String.format("%.2f", producto5iva)));
		
		String prod1=JOptionPane.showInputDialog("¿Cuántos artículos del producto1 ha comprado?");
		int compra1 = Integer.parseInt(prod1);
		String prod2=JOptionPane.showInputDialog("¿Cuántos artículos del producto2 ha comprado?");
		int compra2 = Integer.parseInt(prod2);
		String prod3=JOptionPane.showInputDialog("¿Cuántos artículos del producto3 ha comprado?");		
		int compra3 = Integer.parseInt(prod3);
		String prod4=JOptionPane.showInputDialog("¿Cuántos artículos del producto4 ha comprado?");
		int compra4 = Integer.parseInt(prod4);
		String prod5=JOptionPane.showInputDialog("¿Cuántos artículos del producto5 ha comprado?");
		int compra5 = Integer.parseInt(prod5);
		
	ArrayList<Integer> listacantidades=new ArrayList<Integer>();
		
		listacantidades.add(compra1);
		listacantidades.add(compra2);
		listacantidades.add(compra3);
		listacantidades.add(compra4);
		listacantidades.add(compra5);
		
		System.out.println("Número de artículos comprados "+listacantidades);

		double totalbruto1 = compra1*producto1;
		double totalbruto2 = compra2*producto2;
		double totalbruto3 = compra3*producto3;
		double totalbruto4 = compra4*producto4;
		double totalbruto5 = compra5*producto5;		
		
		double totaliva1 = compra1*(producto1+producto1iva);
		double totaliva2 = compra2*(producto2+producto2iva);
		double totaliva3 = compra3*(producto3+producto3iva);
		double totaliva4 = compra4*(producto4+producto4iva);
		double totaliva5 = compra5*(producto5+producto5iva);
		
		double totalcompra = totaliva1+ totaliva2 + totaliva3 + totaliva4 + totaliva5;
		 
		
		System.out.println("El precio total bruto del producto 1 es: " +(String.format("%.2f", totalbruto1))+ " y con el IVA: "+(String.format("%.2f",totaliva1)));
		System.out.println("El precio total bruto del producto 2 es: " +(String.format("%.2f", totalbruto2))+ " y con el IVA: "+(String.format("%.2f",totaliva2)));
		System.out.println("El precio total bruto del producto 3 es: " +(String.format("%.2f", totalbruto3))+ " y con el IVA: "+(String.format("%.2f",totaliva3)));
		System.out.println("El precio total bruto del producto 4 es: " +(String.format("%.2f", totalbruto4))+ " y con el IVA: "+(String.format("%.2f",totaliva4)));
		System.out.println("El precio total bruto del producto 5 es: " +(String.format("%.2f", totalbruto5))+ " y con el IVA: "+(String.format("%.2f",totaliva5)));
		
		System.out.println("El total de la compra es de: "+(String.format("%.2f", totalcompra)));
		
		String abono=JOptionPane.showInputDialog("Cantidad pagada: ");
		double pago = Double.parseDouble(abono);
		double cambio = (pago-totalcompra);
		double totalproductos = (compra1+compra2+compra3+compra4+compra5);
		
		System.out.println("Número total de productos comprados: "+(String.format("%.0f", totalproductos)));
		
		System.out.println("La cantidad abonada es de: "+(String.format("%.2f", pago))+"€");
		System.out.println("Y el cambio: "+(String.format("%.2f", cambio))+"€");

	}

}
