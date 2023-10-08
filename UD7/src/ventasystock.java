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
		
		String [] eleccion = {"añadir", "buscar", "listar", "comprar", "exit"};
		String opcion;
		
		do {
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
			comprar(stockprecio);
		default:
			break;
		}
		
	}while(!opcion.equals("exit"));
		
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
	public static void comprar (Hashtable<String, Hashtable<String, String>> stockprecio) {
		String [] arrayarticulos = {"agua", "caramelo", "regaliz", "chupa-chups", "piruleta", "coca-cola", "huevo kinder", "nestea", "moneda de chocolate", "chicle"};
		String selection;
		double sumaSin = 0;
		double sumaCon = 0;
		int sumaCantidad = 0;
		
		String cpregunta0=JOptionPane.showInputDialog("¿Cuántos productos diferentes quieres?");
		int quiero = Integer.parseInt(cpregunta0);
		
		for (int i = 0; i < quiero; i++) {
		Enumeration <String> enumeration = stockprecio.keys();
			selection=(String) JOptionPane.showInputDialog(null, "Elige tu artículo de compra: ", "IVA del 4%", JOptionPane.DEFAULT_OPTION, null, arrayarticulos, "agua");
		while (enumeration.hasMoreElements()) {
			String element = enumeration.nextElement();
				if (selection.equals(element)) {
					String cpregunta1=JOptionPane.showInputDialog("¿Cuántos quieres?");
					double elpedido = Double.parseDouble(cpregunta1);
					
					double particulo = Double.parseDouble(stockprecio.get(element).get("precio"));
					double stockcantidad = Double.parseDouble(stockprecio.get(element).get("cantidad"));
					if(stockcantidad<elpedido) {
						JOptionPane.showMessageDialog(null,"No hay suficiente stock");
					}else {
					double elresto = stockcantidad-elpedido;
					String queda = Double.toString(elresto);
					
					stockprecio.get(element).put("cantidad", queda);
					
					double conIVA = elpedido*(particulo + (particulo*0.04));
					double sinIVA = elpedido*particulo;
					sumaSin += sinIVA;
					sumaCon += conIVA;
					sumaCantidad += elpedido;
					
					JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",+sinIVA)+" con el IVA: "+(String.format("%.2f",conIVA))));
					JOptionPane.showMessageDialog(null, "Queda en el stock de la tienda: "+stockprecio.get(element).get("cantidad"));
				}
			}
		}
	}	
		JOptionPane.showMessageDialog(null, "Cantidad de productos comprados: "+sumaCantidad);
		JOptionPane.showMessageDialog(null, "El precio total de productos es de: "+(String.format("%.2f",+sumaSin)+" con el IVA: "+(String.format("%.2f",sumaCon))));
		
		String abono=JOptionPane.showInputDialog("Cantidad pagada: ");
		double pago = Double.parseDouble(abono);
		double cambio = (pago-(sumaCon));
		
		JOptionPane.showMessageDialog(null,"La cantidad abonada es de: "+(String.format("%.2f", pago))+"€");
		JOptionPane.showMessageDialog(null,"Y el cambio: "+(String.format("%.2f", cambio))+"€");

		
		
		/*switch (selection) {
		case "agua":
			String cpregunta1=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menosagua = Double.parseDouble(cpregunta1);
			double pagua = 0.95;
			double norealagua = menosagua*pagua;
			double realagua = menosagua*(pagua + (pagua*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",+norealagua)+" con el IVA: "+(String.format("%.2f",realagua))));
			
			break;
		case "caramelo":
			String cpregunta2=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoscaramelo = Double.parseDouble(cpregunta2);
			double pcaramelo = 0.10;
			double norealcaramelo = menoscaramelo*pcaramelo;
			double realcaramelo = menoscaramelo*(pcaramelo + (pcaramelo*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",norealcaramelo)+" con el IVA: "+(String.format("%.2f",realcaramelo))));

			
			break;
		case "regaliz":
			String cpregunta3=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menosregaliz = Double.parseDouble(cpregunta3);
			double pregaliz = 0.50;
			double norealregaliz = menosregaliz * pregaliz;
			double realregaliz = menosregaliz*(pregaliz + (pregaliz*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",norealregaliz)+" con el IVA: "+(String.format("%.2f",realregaliz))));


			break;
		case "chupa-chups":
			String cpregunta4=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoschupachups = Double.parseDouble(cpregunta4);
			double pchupachups = 1.00;
			double norealchupachups = menoschupachups*pchupachups;
			double realchupachups = menoschupachups*(pchupachups + (pchupachups*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",norealchupachups)+" con el IVA: "+(String.format("%.2f",realchupachups))));


			break;
		case "piruleta":
			String cpregunta5=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menospiruleta = Double.parseDouble(cpregunta5);
			double ppiruleta = 0.75;
			double norealpiruleta = menospiruleta*ppiruleta;
			double realpiruleta = menospiruleta*(ppiruleta + (ppiruleta*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",norealpiruleta)+" con el IVA: "+(String.format("%.2f",realpiruleta))));


			break;
		case "coca-cola":
			String cpregunta6=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoscocacola = Double.parseDouble(cpregunta6);
			double pcocacola = 2.20;
			double norealcocacola = menoscocacola*pcocacola;
			double realcocacola = menoscocacola*(pcocacola + (pcocacola*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",norealcocacola)+" con el IVA: "+(String.format("%.2f",realcocacola))));


			break;
		case "huevo kinder":
			String cpregunta7=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoskinder = Double.parseDouble(cpregunta7);
			double pkinder = 1.50;
			double norealkinder=menoskinder*pkinder;
			double realkinder = menoskinder*(pkinder + (pkinder*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",norealkinder)+" con el IVA: "+(String.format("%.2f",realkinder))));


			break;
		case "nestea":
			String cpregunta8=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menosnestea = Double.parseDouble(cpregunta8);
			double pnestea = 2.20;
			double norealnestea=menosnestea*pnestea;
			double realnestea = menosnestea*(pnestea + (pnestea*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",norealnestea)+" con el IVA: "+(String.format("%.2f",realnestea))));


			break;
		case "moneda de chocolate":
			String cpregunta9=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menosmoneda = Double.parseDouble(cpregunta9);
			double pmoneda = 0.15;
			double norealmoneda = pmoneda*menosmoneda;
			double realmoneda = menosmoneda*(pmoneda + (pmoneda*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",norealmoneda)+" con el IVA: "+(String.format("%.2f",realmoneda))));


			break;
		case "chicle":
			String cpregunta10=JOptionPane.showInputDialog("¿Cuántos quieres?");
			double menoschicle = Double.parseDouble(cpregunta10);
			double pchicle = 0.25;
			double norealchicle = pchicle*menoschicle;
			double realchicle = menoschicle*(pchicle + (pchicle*0.04));
			JOptionPane.showMessageDialog(null, "El total de artículos es de: "+(String.format("%.2f",norealchicle)+" con el IVA: "+(String.format("%.2f",realchicle))));

			break;
		default:
			break;
		}*/
	}
}
