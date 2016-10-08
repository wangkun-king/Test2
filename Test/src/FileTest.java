import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTest {
	public static void main(String[] args) throws IOException {
		 showDirectory(new File("D:\\SVN"));

		Path initPath = Paths.get("D:\\SVN");
		Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file.getFileName().toString());
				return FileVisitResult.CONTINUE;
			}

		});
	}

	// 文件拷贝
	public static void fileCopy(String source, String target) throws IOException {
		try (InputStream in = new FileInputStream(source)) {
			try (OutputStream out = new FileOutputStream(target)) {
				byte[] buffer = new byte[4096];
				int bytesToRead;
				while ((bytesToRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytesToRead);
				}
			}
		}
	}

	// 文件拷贝
	public static void fileCopyNIO(String source, String target) throws IOException {
		try (FileInputStream in = new FileInputStream(source)) {
			try (FileOutputStream out = new FileOutputStream(target)) {
				FileChannel inChannel = in.getChannel();
				FileChannel outChannel = out.getChannel();
				ByteBuffer buffer = ByteBuffer.allocate(4096);
				while (inChannel.read(buffer) != -1) {
					buffer.flip();
					outChannel.write(buffer);
					buffer.clear();
				}
			}
		}
	}

	public static void showDirectory(File f) {
		_walkDirectory(f, 0);
	}

	private static void _walkDirectory(File f, int level) {
		if (f.isDirectory()) {
			for (File file : f.listFiles()) {
				_walkDirectory(file, level + 1);
			}
		} else {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("  ");
			}
			System.out.println("|---"+f.getName());
		}
	}
}
