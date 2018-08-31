package extendspackage;

public class CulcuratorExtends extends CulcuratorExtended{
	int mulMeth(int num1, int num2) {
		int result = super.addMeth(10, 10);
		System.out.println("ºÎ¸ð °ª:"+result);
		int sum = num1 * num2;
		return sum;
	}
}
