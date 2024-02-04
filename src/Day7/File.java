package Day7;

public class File implements SystemFile {
	private final int size;
	private final String name;
	private final Folder parentFolder;

	public File(String name, int size, Folder parentFolder) {
		this.size = size;
		this.name = name;
		this.parentFolder = parentFolder;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Folder getParentFolder() {
		return parentFolder;
	}

	@Override
	public String toString() {
		return "- " + name + " (file, size=" + size + ") \n";
	}
}
