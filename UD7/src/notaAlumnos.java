import java.util.Hashtable;

public class notaAlumnos {

	public static void main(String[] args) {

		Hashtable<String, Double> alumno=new Hashtable<String, Double>();
		
		double toniJava = 9;
		double toniBbdd = 7.5;
		double toniTrans = 6;
		
		double marcJava = 7;
		double marcBbdd = 8;
		double marcTrans = 8.1;
		
		double a100Java = 5.5;
		double a100Bbdd = 9;
		double a100Trans = 9.5;
		
		double notatoni = ((toniJava+toniBbdd+toniTrans)/3);
		double notamarc = ((marcJava+marcBbdd+marcTrans)/3);
		double notaa100 = ((a100Java+a100Bbdd+a100Trans)/3);
		
		alumno.put("a100", notaa100);
		alumno.put("marc", notamarc);
		alumno.put("toni", notatoni);
		
		System.out.println(alumno);

	}

}
