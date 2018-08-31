package extendspackage;

public class ExtendsPractice {
	public static void main(String[] args) {
		CulcuratorExtends obj = new CulcuratorExtends();
		int result= obj.sumMeth(300, 200);
		int result2 = obj.mulMeth(20, 20);
		System.out.println(result);
		System.out.println(result2);
		CulcuratorExtended obj1 = new CulcuratorExtends();
		int result3 = obj1.addMeth(10, 10);
		System.out.println(result3);
	}
}
