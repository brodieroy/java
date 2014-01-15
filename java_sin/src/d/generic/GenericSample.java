package d.generic;

import java.util.ArrayList;

public class GenericSample {
	public static void main(String[] args) {
		GenericSample sample = new GenericSample();
		sample.checkCastingDTD();

	}

	private void checkCastingDTD() {
		CastingDTO dto1 = new CastingDTO();
		dto1.setObject(new String());

		CastingDTO dto2 = new CastingDTO();
		dto2.setObject(new StringBuffer());

		CastingDTO dto3 = new CastingDTO();
		dto3.setObject(new StringBuilder());

		ArrayList<CastingDTO> list1 = new ArrayList<CastingDTO>();
		list1.add(dto1);
		list1.add(dto2);
		list1.add(dto3);
		
		for(CastingDTO tempdto:list1){
			Object tempobj = tempdto.getObject();
			if (tempobj instanceof String) {
				System.out.println("String");
			} else if (tempobj instanceof StringBuffer) {
				System.out.println("StringBuffer");
			} else if (tempobj instanceof StringBuilder) {
				System.out.println("StringBuilder");
			}
		}
		
	}

}
