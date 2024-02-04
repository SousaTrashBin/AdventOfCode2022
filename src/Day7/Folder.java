package Day7;

import java.util.ArrayList;
import java.util.List;

public class Folder implements SystemFile {
	private final List<SystemFile> folderFiles;
	private final String name;
	private final Folder parentFolder;

	public Folder(String name, Folder parentFolder) {
		this.name = name;
		this.parentFolder = parentFolder;
		folderFiles = new ArrayList<>();
	}

	public void addSystemFile(SystemFile sf) {
		if (!folderFiles.contains(sf))
			folderFiles.add(sf);
	}

	public Folder getFolder(String name) {
		List<Folder> filteredFolders = folderFiles.stream().filter(file -> file instanceof Folder)
				.map(file -> (Folder) file).toList();
		Folder f = null;
		for (Folder folder : filteredFolders) {
			if (folder.getName().equals(name))
				f = folder;
		}
		return f;
	}

	@Override
	public int getSize() {
		return folderFiles.stream().mapToInt(SystemFile::getSize).sum();
	}

	@Override
	public String getName() {
		return name;
	}

	public List<SystemFile> getFolderFiles() {
		return folderFiles;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("- " + name + " (dir) \n");
		for (SystemFile folderFile : folderFiles) {
			sb.append("  ").append(folderFile.toString());
		}
		return sb.toString();
	}

	public static void printFolderStructure(Folder folder, String prefix) {
		System.out.println(prefix + "- " + folder.getName());
		for (SystemFile file : folder.getFolderFiles()) {
			if (file instanceof Folder) {
				printFolderStructure((Folder) file, prefix + "  ");
			} else {
				System.out.println(prefix + "  - " + file.getName() + " (file, size=" + ((File) file).getSize() + ")");
			}
		}
	}

	@Override
	public Folder getParentFolder() {
		return parentFolder;
	}
}
