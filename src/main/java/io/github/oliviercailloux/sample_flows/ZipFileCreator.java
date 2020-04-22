package io.github.oliviercailloux.sample_flows;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ZipFileCreator {
	public static void main(String[] args) throws Exception {
		Path zipFilePath = Path.of("anewzipfile.zip");
		URI zipFileUri = zipFilePath.toUri();
		URI jarZipFileUri = URI.create("jar:" + zipFileUri.toString());

		Map<String, String> env = new HashMap<>();
		env.put("create", "true");
		try (FileSystem fs = FileSystems.newFileSystem(jarZipFileUri, env)) {
			Path rootInsideZip = fs.getPath("");
//			…
		}
	}
}
