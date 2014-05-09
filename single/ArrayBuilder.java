import java.util.Arrays;

public class ArrayBuilder {

	private Object[][] parametros;
	
	private ArrayBuilder(Object[][] parametros) {
		this.parametros = parametros;
	}

	
	public static ArrayBuilder getInstance(Object[][] parametros){
		return new ArrayBuilder(parametros);
	}
	
	public ArrayBuilder addElement(Object[][] elementos) {
		if (elementos==null || elementos.length<=0 || elementos[0].length<=0)
			return this;
		for (int p = 0; p < parametros.length; p++) {
			Object[] arr = Arrays.copyOf(parametros[p], parametros[p].length + elementos[p].length);
			for (int i = 0; i < elementos[p].length; i++) {
				arr[parametros[p].length + i] = elementos[p][i];
			}
			parametros[p] = arr;
		}
		return this;
	}
	
	public Object[][] build(){
		return parametros;
	}
	
	public String toString(){
		StringBuffer sw = new StringBuffer();
		sw.append("{");
		for (int p0 = 0; p0 < parametros[0].length; p0++) {
			sw.append("{");
			for (int p = 0; p < parametros.length; p++) {
				sw.append(parametros[p][p0]);
				if (p!=parametros.length-1)
					sw.append(",");
			}
			sw.append("}");
			if (p0!=parametros[0].length-1)
				sw.append(",");
		}
		sw.append("}");
		return sw.toString();
	}
	
}
