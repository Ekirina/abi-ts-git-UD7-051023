import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class stockproductos {

	public static void main(String[] args) {

		Hashtable<String, String> agua=new Hashtable<String, String>();

		agua.put("precio", "0.95");
		agua.put("cantidad", "150");

		Hashtable<String, String> caramelo= new Hashtable<String, String>();
		caramelo.put("precio", "0.10");
		caramelo.put("cantidad", "400");

		Hashtable<String, String> regaliz= new Hashtable<String, String>();

		regaliz.put("precio", "0.50");
		regaliz.put("cantidad", "50");

		Hashtable<String, String> chupachups= new Hashtable<String, String>();

		chupachups.put("precio", "1.00");
		chupachups.put("cantidad", "200");

		Hashtable<String, String> piruleta= new Hashtable<String, String>();

		piruleta.put("precio", "0.75");
		piruleta.put("cantidad", "200");

		Hashtable<String, String> cocacola= new Hashtable<String, String>();

		cocacola.put("precio", "2.20");
		cocacola.put("cantidad", "100");

		Hashtable<String, String> huevokinder= new Hashtable<String, String>();

		huevokinder.put("precio", "1.50");
		huevokinder.put("cantidad", "80");

		Hashtable<String, String> nestea= new Hashtable<String, String>();

		nestea.put("precio", "2.20");
		nestea.put("cantidad", "50");

		Hashtable<String, String> monedadechocolate =new Hashtable<String, String>();

		monedadechocolate.put("precio", "0.15");
		monedadechocolate.put("cantidad", "300");

		Hashtable<String, String> chicle =new Hashtable<String, String>();

		chicle.put("precio", "0.25");
		chicle.put("cantidad", "400");

		Hashtable<String, Hashtable <String, String>> stockprecio=new Hashtable<String, Hashtable <String,String>>();
		stockprecio.put("agua", agua);
		stockprecio.put("caramelo", caramelo);
		stockprecio.put("regaliz", regaliz);
		stockprecio.put("chupa-chups", chupachups);
		stockprecio.put("piruleta", piruleta);
		stockprecio.put("coca-cola", cocacola);
		stockprecio.put("huevo kinder", huevokinder);
		stockprecio.put("nestea", nestea);
		stockprecio.put("moneda de chocolate", monedadechocolate);
		stockprecio.put("chicle", chicle);

		String [] eleccion = {"añadir", "buscar", "listar"};
		String opcion;


		opcion=(String) JOptionPane.showInputDialog(null, "Elige tu opción ", "Tienda de chuches", JOptionPane.DEFAULT_OPTION, null, eleccion, "listar");
		switch (opcion) {
		case "listar":
			enorden (stockprecio);
			break;
		case "añadir":
			añadir (stockprecio);
			enorden (stockprecio);
			break;
		case "buscar":
			buscar (stockprecio);
			break;
		default:
			break;

		}
	}

	public static Hashtable <String, String> stock (String valor, String stock){

		Hashtable<String, String> articulousuario1 = new Hashtable <String, String>();
		articulousuario1.put("precio", valor);
		articulousuario1.put("cantidad", stock);
		return articulousuario1;
	}			

	public static void añadir (Hashtable<String, Hashtable<String, String>> stockprecio) {
		String articulo=JOptionPane.showInputDialog("Introduce el artículo nuevo:");
		String price=JOptionPane.showInputDialog("Introduce el precio del artículo nuevo:");
		String quantity=JOptionPane.showInputDialog("Introduce la cantidad de artículos nuevos:");	

		stockprecio.put(articulo,stock(price, quantity));
	}

	public static void buscar (Hashtable<String, Hashtable<String, String>> stockprecio){
		Enumeration <String> enumeration = stockprecio.keys();
		String cosa=JOptionPane.showInputDialog("Introduce el artículo que quiere información:");

		while (enumeration.hasMoreElements()) {
			String element = enumeration.nextElement();
			if (cosa.equals(element)) {
				System.out.println(element);
				System.out.println(stockprecio.get(element).get("precio"));
				System.out.println(stockprecio.get(element).get("cantidad"));

			}

		}
	}
	public static void enorden (Hashtable<String, Hashtable<String, String>> stockprecio){
		Enumeration <String> enumeration = stockprecio.keys();

		while (enumeration.hasMoreElements()) {
			String element = enumeration.nextElement();
			System.out.println(element);
			System.out.println(stockprecio.get(element).get("precio"));
			System.out.println(stockprecio.get(element).get("cantidad"));
		}     
	}
}












