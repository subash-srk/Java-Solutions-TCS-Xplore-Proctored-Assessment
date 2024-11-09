import java.util.*;
class Solution{

	static int searchAntenna(Antenna[] arr, String fName){
		for(int i=0; i<4; i++){
			if(arr[i].getantennaName().equalsIgnoreCase(fName)){
				return arr[i].getantennaid();
			}
		}
		return 0;

	}

	static Antenna[] sortAntenna(Antenna[] arr, double fVSWR){
		Antenna[] resArr = new Antenna[0];
		for(int i=0; i<4; i++){
			if(arr[i].getantennaVSWR() < fVSWR){
				resArr = Arrays.copyOf(resArr, resArr.length+1);
				resArr[resArr.length - 1] = arr[i];
			}
		}
		Antenna temp;
		for(int i=0; i<resArr.length; i++){
			for(int j=i+1; j<resArr.length; j++){
				if(resArr[i].getantennaVSWR() > resArr[j].getantennaVSWR()){
					temp = resArr[i];
					resArr[i] = resArr[j];
					resArr[j] = temp;
				}
			}
		}
		return resArr;
	}

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		Antenna[] arr = new Antenna[4];
		for(int i=0; i<4; i++){
			int a = sc.nextInt();
			sc.nextLine();
			String b = sc.nextLine();
			String c = sc.nextLine();
			double d = sc.nextDouble();
			sc.nextLine();

			arr[i] = new Antenna(a, b, c, d);
		}
		String fName = sc.nextLine();
		double fVSWR = sc.nextDouble();
		//System.out.println(fVSWR);

		int resId = searchAntenna(arr, fName);
		if(resId == 0){
			System.out.println("There is no antenna with the given parameter");
		}
		else{
			System.out.println(resId);
		}

		Antenna[] resArr = sortAntenna(arr, fVSWR);
		if(resArr.length == 0){
			System.out.println("No Antenna found");
		}
		else{
			for(int i=0; i<resArr.length; i++){
				System.out.println(resArr[i].getprojectLead());
			}
		}
	}
}


class Antenna{
	private int antennaid;
	private String antennaName, projectLead;
	private double antennaVSWR;

	Antenna(int a, String b, String c, double d){
		this.antennaid = a;
		this.antennaName= b;
		this.projectLead = c;
		this.antennaVSWR = d;
	}

	public int getantennaid(){
		return this.antennaid;
	}
	public String getantennaName(){
		return this.antennaName;
	}
	public String getprojectLead(){
		return this.projectLead;
	}
	public double getantennaVSWR(){
		return this.antennaVSWR;
	}
}
