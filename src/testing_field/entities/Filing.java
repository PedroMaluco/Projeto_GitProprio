package testing_field.entities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

public class Filing {
	
	private String path;
	
	public Filing() {
	}

	public Filing(String path, String name) {
		this.path = path;
	}
	
	public void createRepo(String path) {
		File repo = new File(path);
		if(repo.exists()) {
			System.out.println("Directory already exists");
		}
		else {
		repo.mkdir();
		System.out.println("Directory created succesfully");
		}
	}
	
	public void CopyDirectory(Path path, Path target) throws IOException {
		var stream = Files.walk(path); {
			stream.forEach(sourcePath -> {
				try {
					Path targetPath = target.resolve(path.relativize(sourcePath));
					if(Files.isDirectory(path)) {
						Files.createDirectories(targetPath);
					}
					else {
						Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
					}
				}catch(IOException e){
						throw new RuntimeException("Failed to copy"+sourcePath, e);
						
					}
				
				});
			}
		}
	
}
