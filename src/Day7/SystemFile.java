package Day7;

public interface SystemFile {
	int getSize();

	String getName();

	@Override
	String toString();

	Folder getParentFolder();
}
