package blabber;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "reachability-blabber")
public class Main implements Runnable {
	@Option(names = "--intra")
	boolean intra;
	@Option(names = { "-d", "--depth" }, required = true, description = "Call depth")
	private int depth;

	public void run() {
		Blabber blabber = new Blabber();

		if (intra)
			System.out.println(blabber.intraClass(depth));
	}

	public static void main(String[] args) {
		int exitCode = new CommandLine(new Main()).execute(args);
		System.exit(exitCode);
	}
}
