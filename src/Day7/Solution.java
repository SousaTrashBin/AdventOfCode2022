package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		Folder mainSystemFolder = new Folder("/", null);
		// Represents a list that contains every single folder on the system
		List<Folder> foldersList = new ArrayList<>();
		buildFileSystem(mainSystemFolder, foldersList);
		System.out.println("Part 1 -> "
				+ foldersList.stream().map(Folder::getSize).filter(x -> x <= 100000).mapToInt(x -> x).sum());
		int minRequiredSpace = 30000000 - (70000000 - mainSystemFolder.getSize());
		System.out.println("Part 2 -> " + foldersList.stream().map(Folder::getSize)
				.filter(size -> size >= minRequiredSpace).reduce(Math::min).orElse(0));
		Folder.printFolderStructure(mainSystemFolder, "");
	}

	private static void buildFileSystem(Folder mainSystemFolder, List<Folder> allFolders) throws IOException {
		Folder currentFolder = null;
		List<String> lines = Files.readString(Path.of("src/Day7/input.txt")).lines().toList();
		for (int i = 0; i < lines.size(); i++) {
			String currentLine = lines.get(i);
			// Handles the change directory command (cd)
			if (currentLine.startsWith("$ cd")) {
				// Updates the current folder
				currentFolder = cdCommand(mainSystemFolder, allFolders, currentLine, currentFolder);
			} // Handles the list all system files on current directory command (ls)
			else if (currentLine.startsWith("$ ls")) {
				// Updates the index accordingly so it skips all the lines that represent a
				// system file
				i = lsCommand(i, lines, currentFolder);
			}
		}
	}

	private static Folder cdCommand(Folder mainSystemFolder, List<Folder> allFolders, String currentLine,
			Folder currentFolder) {
		String folderName = currentLine.substring(5);
		if (currentFolder == null)
			currentFolder = mainSystemFolder;
		else if (folderName.equals(".."))
			currentFolder = currentFolder.getParentFolder();
		else
			currentFolder = currentFolder.getFolder(folderName);
		// Keeps track of all the folders created
		if (!allFolders.contains(currentFolder))
			allFolders.add(currentFolder);
		return currentFolder;
	}

	private static int lsCommand(int i, List<String> lines, Folder currentFolder) {
		for (int j = i + 1; j < lines.size(); j++) {
			if (lines.get(j).startsWith("$")) {
				i = j - 1;
				break;
			}
			if (lines.get(j).startsWith("dir ")) {
				currentFolder.addSystemFile(new Folder(lines.get(j).substring(4), currentFolder));
			} else {
				String[] fileData = lines.get(j).split(" ");
				int size = Integer.parseInt(fileData[0]);
				String name = fileData[1];
				currentFolder.addSystemFile(new File(name, size, currentFolder));
			}
		}
		return i;
	}
}
