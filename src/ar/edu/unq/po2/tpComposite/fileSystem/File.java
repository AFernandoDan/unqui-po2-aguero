package ar.edu.unq.po2.tpComposite.fileSystem;

public class File extends DirectoryNode {

	private int totalSize;

	public File(String name, int sizeInBytes) {
		super(name);
		setTotalSize(sizeInBytes);
	}

	private void setTotalSize(int sizeInBytes) {
		totalSize = sizeInBytes;
	}
	
	@Override
	public int totalSize() {
		return totalSize;
	}

	@Override
	public String getStructure(int depth) {
		return "\t".repeat(depth) + getName();
	}

}
