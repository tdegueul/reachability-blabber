package blabber;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang.RandomStringUtils;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Blabber {
	public String intraClass(int depth) {
		var methods = new ArrayList<MethodSpec>();
		var names = randomNames(depth, 12);

		for (int i = 0; i < depth; i++) {
			MethodSpec.Builder m = MethodSpec.methodBuilder(names.get(i))
				.addModifiers(Modifier.PUBLIC)
				.returns(void.class);

			if (i + 1 < depth)
				m.addStatement(names.get(i + 1) + "()");

			methods.add(m.build());
		}

		TypeSpec cls = TypeSpec.classBuilder("IntraClassReachability")
			.addModifiers(Modifier.PUBLIC)
			.addMethods(methods)
			.build();

		return cls.toString();
	}

	public List<String> randomNames(int count, int length) {
		return IntStream.range(0, count)
			.mapToObj(i -> RandomStringUtils.randomAlphabetic(length))
			.toList();
	}
}
