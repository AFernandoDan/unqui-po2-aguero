package ar.edu.unq.po2.tpComposite.fileSystem;

import java.time.LocalDateTime;

public abstract class DirectoryNode {
	private String name;
	private LocalDateTime lastModificationDate;
	
	public DirectoryNode(String name) {
		setName(name);
	}
	
	public void setName(String name) {
		this.name = name;
		updateLastModificationDate();
	}
	
	public String getName() {
		return name;
	}
	
	private void updateLastModificationDate() {
		setLastModificationDate(LocalDateTime.now());
	}
	
	private void setLastModificationDate(LocalDateTime lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	
	public LocalDateTime getLastModificationDate() {
		return lastModificationDate;
	}
	
	public abstract int totalSize();
	public abstract String getStructure(int depth);
}
