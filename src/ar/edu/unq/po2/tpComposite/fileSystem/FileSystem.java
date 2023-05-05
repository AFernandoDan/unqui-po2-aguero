package ar.edu.unq.po2.tpComposite.fileSystem;

public interface FileSystem {
	public int totalSize();
	public void printStructure();
	public DirectoryNode lastModifed();
	public DirectoryNode oldestElement();
}
