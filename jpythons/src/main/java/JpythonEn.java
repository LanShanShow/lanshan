import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public final class JpythonEn {

	private static JpythonEn instance = new JpythonEn();
	
	private JpythonEn() {}
	
	public static JpythonEn getInstance() {
		return instance;
	}
	private PySystemState getPySystemState() {
		PySystemState.initialize();
		final PySystemState state = new PySystemState();
		state.setClassLoader(getClass().getClassLoader());
		return state;
	}
	public PythonInterpreter getPyInterPerter() {
		PythonInterpreter interpreter = new PythonInterpreter(null, getPySystemState());
		return interpreter;
	}
}
