package Day7;

public interface SystemFile {
	public int getSize();

	public String getName();

	@Override
	public String toString();

	public Folder getParentFolder();
}
