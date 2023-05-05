package ar.edu.unq.po2.tpComposite.fileSystem;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Directory extends DirectoryNode implements FileSystem {
	private LocalDateTime creationDate;
	private HashSet<DirectoryNode> content;

	public Directory(String name) {
		super(name);
		setCreationDate(LocalDateTime.now());
		setContent(new HashSet<DirectoryNode>());
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	private void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int totalSize() {
		return getContent().stream().mapToInt(n -> n.totalSize()).sum();
	}

	@Override
	public void printStructure() {
		System.out.println(getStructure(0));
	}

	@Override
	public DirectoryNode lastModifed() {
		// precondicion: debe haber un elemento en el directorio
		return Collections
				.max(getContent(), Comparator.comparing(DirectoryNode::getLastModificationDate));
	}

	@Override
	public DirectoryNode oldestElement() {
		// precondicion: debe haber un elemento en el directorio
		return Collections
				.min(getContent(), Comparator.comparing(DirectoryNode::getLastModificationDate));
	}

	public void addNode(DirectoryNode unNodo) {
		getContent().add(unNodo);	
	}

	public Set<DirectoryNode> getContent() {
		return content;
	}
	
	private void setContent(HashSet<DirectoryNode> content) {
		this.content = content;
	}

	@Override
	public String getStructure(int depth) {
		return getName()
				+ "/"
				+ getContent()
					.stream()
					.map(n -> "\n" + "\t".repeat(depth + 1) + n.getStructure(depth+1))
					.collect(Collectors.joining());
	}
}
