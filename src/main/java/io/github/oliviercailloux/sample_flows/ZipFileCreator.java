package io.github.oliviercailloux.sample_flows;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.common.collect.ImmutableMap;

public class ZipFileCreator {
	public static void main(String[] args) throws Exception {
		Path zipFilePath = Path.of("anewzipfile.zip");
		URI zipFileUri = zipFilePath.toUri();
		URI jarZipFileUri = URI.create("jar:" + zipFileUri.toString());

		/**
		 * See
		 * https://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/zipfilesystemprovider.html
		 * for reference information.
		 */
		ImmutableMap<String, String> env = ImmutableMap.of("create", "true");
		try (FileSystem fs = FileSystems.newFileSystem(jarZipFileUri, env)) {
			Path rootInsideZip = fs.getPath("");
//			…
		}
	}
}
