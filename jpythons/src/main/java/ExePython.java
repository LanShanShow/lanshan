import java.util.Map;
import java.util.Map.Entry;

import org.python.util.PythonInterpreter;

public enum ExePython {

	instance;
	public void execute(String file,Map<String, String> properties) {
		final PythonInterpreter interpreter = JpythonEn.getInstance().getPyInterPerter();
		for (Entry<String, String> entry : properties.entrySet()) {
			interpreter.set(entry.getKey(),entry.getValue());
		}
		try {
			interpreter.execfile(file);
		} catch (Exception e) {
			System.err.println(e);
			// TODO: handle exception
		} 
	}
}
