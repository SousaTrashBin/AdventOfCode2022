package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import AuxiliarClasses.Day;

public class Day7 extends Day {
	private final Folder mainSystemFolder = new Folder("/", null);
	private final List<Folder> foldersList = new ArrayList<>();

	public Day7() throws IOException {
		super(7);
		buildFileSystem();
	}

	private void buildFileSystem() throws IOException {
		Folder currentFolder = null;
		List<String> lines = Files.readString(Path.of(super.getFile())).lines().toList();
		for (int i = 0; i < lines.size(); i++) {
			String currentLine = lines.get(i);
			// Handles the change directory command (cd)
			if (currentLine.startsWith("$ cd")) {
				// Updates the current folder
				currentFolder = cdCommand(mainSystemFolder, foldersList, currentLine, currentFolder);
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

	@Override
	public String Part1() {
		return String
				.valueOf(foldersList.stream().map(Folder::getSize).filter(x -> x <= 100000).mapToInt(x -> x).sum());
	}

	@Override
	public String Part2() {
		int minRequiredSpace = 30000000 - (70000000 - mainSystemFolder.getSize());
		return foldersList.stream().map(Folder::getSize).filter(size -> size >= minRequiredSpace).reduce(Math::min)
				.orElse(0).toString();
	}
}
