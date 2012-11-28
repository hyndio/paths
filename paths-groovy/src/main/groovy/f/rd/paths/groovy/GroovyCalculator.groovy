package f.rd.paths.groovy;

import org.springframework.stereotype.Service;

@Service
class GroovyCalculator implements Calculator {

	@Override
	public int add(int x, int y) {
		return x+y;
	}

}
