package project;

import java.util.HashMap;

public class BaseballTeam {
	public HashMap<Integer, String> hanHwaBat() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "�̿��");
		map.put(2, "�缺��");
		map.put(3,"�۱���");
		map.put(4,"ȣ��");
		map.put(5,"���±�");
		map.put(6,"�̼���");
		map.put(7,"���ּ�");
		map.put(8,"������");
		map.put(9,"���ٿ�");

		return map;
	}
	public HashMap<Integer, String> hanHwaPit(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "����");
		map.put(2, "�ٷ�");
		map.put(3, "���翵");
		map.put(4, "�����");
		map.put(5, "�迵��");
		map.put(6, "����");
		map.put(7, "�ȿ���");
		map.put(8, "�����");
		
		return map;
	}
	public HashMap<Integer, String> kiaBat(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "������");
		map.put(2, "�輱��");
		map.put(3, "��ġȫ");
		map.put(4, "������");
		map.put(5, "������");
		map.put(6, "������");
		map.put(7, "�̹�ȣ");
		map.put(8, "��ν�");
		map.put(9, "�̸���");
		return map;
	}
	public HashMap<Integer, String> kiaPit(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "����");
		map.put(2, "������");
		map.put(3, "�ֵ�");
		map.put(4, "�ӱ⿵");
		map.put(5, "�ѽ���");
		map.put(6, "������");
		map.put(7, "�輼��");
		map.put(8, "��â��");
		
		return map;
	}
}
