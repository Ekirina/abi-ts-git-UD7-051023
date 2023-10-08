import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class ventasystock {

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
		
		String [] eleccion = {"añadir", "buscar", "listar", "comprar"};
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
		case "comprar":
			comprar();
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
				System.out.println("Artículo escogido: " + element);
				System.out.println("Sin IVA: " + stockprecio.get(element).get("precio"));
				System.out.println("Stock: " + stockprecio.get(element).get("cantidad"));
			}
		}
	}
	public static void enorden (Hashtable<String, Hashtable<String, String>> stockprecio){
		Enumeration <String> enumeration = stockprecio.keys();

		while (enumeration.hasMoreElements()) {
			String element = enumeration.nextElement();
			System.out.println("Artículo: " + element);
			System.out.println("Sin IVA: "+ stockprecio.get(element).get("precio"));
			System.out.println("Stock: "+stockprecio.get(element).get("cantidad"));
		}     
	}
	public static void comprar () {
		String [] arrayarticulos = {"agua", "caramelo", "regaliz", "chupa-chups", "piruleta", "coca-cola", "huevo kinder", "nestea", "moneda de chocolate", "chicle"};
		String selection;
		selection=(String) JOptionPane.showInputDialog(null, "Elige tu artículo de compra: ", "IVA incluido", JOptionPane.DEFAULT_OPTION, null, arrayarticulos, "agua");

		switch (selection) {
		case "agua":
			String cpregunta1=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menosagua = Double.parseDouble(cpregunta1);
			double pagua = 0.95;
			double realagua = 0.95 + (0.95*0.04);
			
			break;
		case "caramelo":
			String cpregunta2=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoscaramelo = Double.parseDouble(cpregunta2);
			double pcaramelo = 0.10;
			double realcaramelo = 0.95 + (0.95*0.04);

			
			break;
		case "regaliz":
			String cpregunta3=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menosregaliz = Double.parseDouble(cpregunta3);
			double pregaliz = 0.10;
			double realregaliz = 0.95 + (0.95*0.04);


			break;
		case "chupa-chups":
			String cpregunta4=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoschupachups = Double.parseDouble(cpregunta4);
			double pchupachups = 0.10;
			double realchupachups = 0.95 + (0.95*0.04);


			break;
		case "piruleta":
			String cpregunta5=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menospiruleta = Double.parseDouble(cpregunta5);
			double ppiruleta = 0.10;
			double realpiruleta = 0.95 + (0.95*0.04);


			break;
		case "coca-cola":
			String cpregunta6=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoscocacola = Double.parseDouble(cpregunta6);
			double pcocacola = 0.10;
			double realcocacola = 0.95 + (0.95*0.04);


			break;
		case "huevo kinder":
			String cpregunta7=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoskinder = Double.parseDouble(cpregunta7);
			double pckinder = 0.10;
			double realkinder = 0.95 + (0.95*0.04);


			break;
		case "nestea":
			String cpregunta8=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menosnestea = Double.parseDouble(cpregunta8);
			double pnestea = 0.10;
			double realnestea = 0.95 + (0.95*0.04);


			break;
		case "moneda de chocolate":
			String cpregunta9=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menomoneda = Double.parseDouble(cpregunta9);
			double pmoneda = 0.10;
			double realmoneda = 0.95 + (0.95*0.04);


			break;
		case "chicle":
			String cpregunta10=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoschicle = Double.parseDouble(cpregunta10);
			double pchicle = 0.10;
			double realchicle = 0.95 + (0.95*0.04);


			break;
		default:
			break;
		}
	}
}
