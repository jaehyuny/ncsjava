package mypackage;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer sb =new StringBuffer();
		sb.append("�ϴ��� �췯�� ���� �β�����\n");
		sb.append("�Ի��� �̴� �ٶ�����...");
		System.out.println(sb);
		String str = "�ϴ��� �췯�� ���� �β����� \n";
		str+="�Ի��� �̴� �ٶ�����...";
		System.out.println(str);
	}
}
